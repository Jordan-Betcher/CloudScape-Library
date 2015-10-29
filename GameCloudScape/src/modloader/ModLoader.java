package modloader;

import helper.FileCheck;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;

public class ModLoader
{
	private static String MODFOLDER = "Mods/";
	
	private static ArrayList<Mod> allMods = new ArrayList<Mod>();
	private static ArrayList<Mod> notLoadedMods = new ArrayList<Mod>();
	private static ArrayList<Mod> loadedMods = new ArrayList<Mod>();
	
	private static HashMap<Mod, File> modToDirectory = new HashMap<Mod, File>();
	
	public static void load()
	{
		
	}
	
	public static void loadMods()
	{
		for(int i = 0; i < allMods.size() - 1; i++)
		{
			if(notLoadedMods.contains(allMods.get(i)))
			{
				try
				{
					loadMod(allMods.get(i));
				}
				catch (IOException e)
				{
					//Gets thrown when 
					e.printStackTrace();
				}
			}
		}
	}
	
	private static boolean isAllreadyLoaded(ArrayList<String> names)
	{
		return contains(loadedMods, names);
	}
	
	private static boolean isInNotLoadedYet(ArrayList<String> names)
	{
		return contains(notLoadedMods, names);
	}
	
	private static boolean contains(ArrayList<Mod> mods, ArrayList<String> names)
	{
		return getModNames(mods).containsAll(names);
	}
	
	private static ArrayList<String> getModNames(ArrayList<Mod> mods)
	{
		ArrayList<String> modNames = new ArrayList<String>();
		
		for(Mod mod : mods)
		{
			modNames.add(mod.getName());
		}
		
		return modNames;
	}
	
	public static void loadMod(Mod mod) throws IOException
	{
		ArrayList<String> requiredMods = mod.getRequiredMods();
		
		if(isAllreadyLoaded(requiredMods))
		{
			try
			{
				loadMod(modToDirectory.get(mod));
				loadedMods.add(mod);
				mod.starting();
			}
			catch (Throwable t)
			{
				t.printStackTrace();
				throw new IOException("couldn't load mod: " + mod.getName());
			}
			
		}
		//TODO make it so that if part of the mods are already loaded
		//, that it only loads the ones that aren't loaded
		else if(isInNotLoadedYet(requiredMods))
		{
			for(String requiredMod : requiredMods)
			{
				//TODO make it so that if one of these mods throws an exception
				//, that this mod doesn't load and it return;
				// but if it doesn't throw any exceptions, then the mod does the
				// thing 
				try
				{
					loadMod(getModToLoad(requiredMod));
					
					try
					{
						loadMod(modToDirectory.get(mod));
						loadedMods.add(mod);
						mod.starting();
					}
					catch (Throwable t)
					{
						t.printStackTrace();
						throw new IOException("couldn't load mod: " + mod.getName());
					}
				}
				catch (Throwable t)
				{
					t.printStackTrace();
					throw new IOException("couldn't load required mods, this mod: " + mod.getName());
				}
			}
		}
		
		if( ! loadedMods.contains(mod))
		{
			System.out.println("Couldn't find required mods in unloadedMods" + mod.getName() + ". Which are:");
			
			for(String requireModName : requiredMods)
			{
				System.out.println(requireModName);
			}
			
			throw new IOException("mod wasn't loaded: " + mod.getName());
		}
		
		notLoadedMods.remove(mod);
	}

	private static Mod getModToLoad(String requiredMod)
	{
		Mod mod;
		
		for(Mod notLoadedMod : notLoadedMods)
		{
			if(notLoadedMod.getName().equals(requiredMod))
			{
				return notLoadedMod;
			}
		}
		
		return null;
	}

	/**
	 * http://stackoverflow.com/questions/60764/how-should-i-load-jars-dynamically-at-runtime
	 * @throws IOException 
	 * 
	 */
	public static void loadMod(File file) throws IOException
	{
		URL url = getURL(file);
		
		URLClassLoader sysloader = (URLClassLoader) ClassLoader
				.getSystemClassLoader();
		Class systemclass = URLClassLoader.class;
		
		try
		{
			Method method = systemclass.getDeclaredMethod("addURL");
			method.setAccessible(true);
			method.invoke(sysloader, new Object[]{ url });
		} 
		catch (Throwable t)
		{
			t.printStackTrace();
			throw new IOException(
					"Error, could not add URL to system classloader");
		}
		
	}
	
	private static URL getURL(File file) throws MalformedURLException
	{
		return file.toURI().toURL();
		
	}

	public static void loadMod(String directory) throws IOException
	{
		File file = new File(directory);
		loadMod(file);
		
	}
	
	private static void makeModFileExist()
	{

		if( ! FileCheck.exists(MODFOLDER))
		{
			FileCheck.createFile(MODFOLDER);
		}
	}
	
}
