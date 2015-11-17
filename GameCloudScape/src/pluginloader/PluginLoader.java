package pluginloader;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/*
 * Classes loaded will be overriden if a class with the same name is part of the core game
 * 
 * Multiple different classes will be loaded even if they have the same name
 * 
 * 
 */

public class PluginLoader
{
	
	private ArrayList<String> jarPaths = new ArrayList<String>();
	private ArrayList<String> classPaths = new ArrayList<String>();
	private ArrayList<Class> classes = new ArrayList<Class>();
	private ArrayList<Plugin> plugins = new ArrayList<Plugin>();
	
	/**
	 * If an exception is thrown there is something wrong with the jar or class,
	 * I'm not knowledgable enough to tell you how to fix them
	 * 
	 * I also couldn't make it so you could pass in a generic interface in so the classes you are looking for
	 * have to be plugins
	 * 
	 * @author pplluumm
	 * @param Folder is the directory for the folder the jars are stored in (in eclipse it is on the same level as the src folder)
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public PluginLoader(String Folder) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException
	{
		this.jarPaths = getJarPaths(Folder);
		this.classes = getClasses(jarPaths);
		this.plugins = getPluginClasses(classes);
	}
	
	
	
	private ArrayList<Plugin> getPluginClasses(ArrayList<Class> classes)
			throws InstantiationException, IllegalAccessException
	{
		ArrayList<Plugin> plugins = new ArrayList<Plugin>();
		
		for (Class c : classes)
		{
			Object test = c.newInstance();
			if (test instanceof Plugin)
			{
				Plugin plugin = (Plugin) test;
				plugins.add(plugin);
			}
		}
		return plugins;
	}
	
	private ArrayList<Class> getClasses(ArrayList<String> jarPaths)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException
	{
		ArrayList<Class> classes = new ArrayList<Class>();
		
		for (String jarPath : jarPaths)
		{
			classes.addAll(getClasses(jarPath));
		}
		
		return classes;
	}
	
	/**
	 *  Copied from http://stackoverflow.com/questions/11016092/how-to-load-classes-at-runtime-from-a-folder-or-jar
	 *  
	 * @param pathToJar
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private ArrayList<Class> getClasses(String pathToJar) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException
	{
		
		ArrayList<Class> classes = new ArrayList<Class>();
		
		URL[] urls =
		{
			new URL("jar:file:" + pathToJar + "!/")
		};
		
		URLClassLoader cl = URLClassLoader.newInstance(urls);
		JarFile jarFile = new JarFile(pathToJar);
		Enumeration<JarEntry> jars = jarFile.entries();
		
		while (jars.hasMoreElements())
		{
			JarEntry entry = (JarEntry) (jars.nextElement());
			if (entry.isDirectory() || !entry.getName().endsWith(".class"))
			{
				continue;
			}
			String className = entry.getName().substring(0,
					entry.getName().length() - 6);
			className = className.replace('/', '.');
			
			classes.add(cl.loadClass(className));
			this.classPaths.add(className);
		}
		
		return classes;
	}
	
	private ArrayList<String> getJarPaths(String folder) throws IOException
	{
		ArrayList<String> jarPaths = new ArrayList<String>();
		
		Files.walk(Paths.get(folder)).forEach(filePath ->
		{
			if (Files.isRegularFile(filePath))
			{
				jarPaths.add("" + filePath);
			}
		});
		
		return jarPaths;
	}
	
	/**
	 * Created at initialization by private method getJarPaths
	 * 
	 * @author pplluumm
	 * @return the paths to each jar in the folder given at initialization
	 */
	public ArrayList<String> getJarPaths()
	{
		return jarPaths;
	}
	
	/**
	 * Created at initialization by private method getClasses
	 * 
	 * @author pplluumm
	 * @return all the classes loaded
	 */
	public ArrayList<Class> getLoadedClasses()
	{
		return classes;
	}
	
	/**
	 * Created at initialization by private method getPluginClasses
	 * 
	 * @author pplluumm
	 * @return all the class that are instances of Plugin that were found and loaded in the folder
	 */
	public ArrayList<Plugin> getPlugins()
	{
		return plugins;
	}
	
	/**
	 * Gets an arraylist of strings that represents the directory for where the class was found
	 * You can use this to find out where a certain class is found
	 * 
	 * @author pplluumm
	 * @return an arrayList of strings that are the directories for classes
	 */
	public ArrayList<String> getClassPaths()
	{
		return this.classPaths;
	}
	
}
