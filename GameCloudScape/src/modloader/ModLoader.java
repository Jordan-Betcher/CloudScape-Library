package modloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class ModLoader
{
	private ArrayList<String> unloadedModURL = new ArrayList<String>();
	private ArrayList<Mod> queuedMods = new ArrayList<Mod>();
	private ArrayList<Mod> loadedMods = new ArrayList<Mod>();
	
	/**
	 * http://stackoverflow.com/questions/60764/how-should-i-load-jars-dynamically-at-runtime
	 * 
	 */
	public void loadMod(String url) throws IOException
	{
		File f = new File(url);
        URL u = f.toURI().toURL();
		
		URLClassLoader sysloader = (URLClassLoader) ClassLoader
				.getSystemClassLoader();
		Class sysclass = URLClassLoader.class;

		try {
			Method method = sysclass.getDeclaredMethod("addURL");
			method.setAccessible(true);
			method.invoke(sysloader, new Object[] { u });
		} catch (Throwable t) {
			t.printStackTrace();
			throw new IOException(
					"Error, could not add URL to system classloader");
		}

	}
	
}
