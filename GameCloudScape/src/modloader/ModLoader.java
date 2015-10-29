package modloader;

import helper.FileCheck;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class ModLoader
{
	private static String MODFOLDER = "Mods/";
	
	private ArrayList<String> unloadedModURL = new ArrayList<String>();
	private ArrayList<Mod> queuedMods = new ArrayList<Mod>();
	private ArrayList<Mod> loadedMods = new ArrayList<Mod>();
	
	/**
	 * http://stackoverflow.com/questions/60764/how-should-i-load-jars-dynamically-at-runtime
	 * 
	 */
	public static void loadMod(String directory) throws IOException
	{
		makeModFileExist();
		
		File file = new File(directory);
		URL url = file.toURI().toURL();
		
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
	
	private static void makeModFileExist()
	{

		if( ! FileCheck.exists(MODFOLDER))
		{
			FileCheck.createFile(MODFOLDER);
		}
	}
	
}
