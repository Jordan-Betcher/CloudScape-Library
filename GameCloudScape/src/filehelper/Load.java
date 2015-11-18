package filehelper;

import game.worldmap.WorldMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Load
{
	
	/**
	 * Loads File at the directory
	 * 
	 * @author pplluumm
	 * @param Dir
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	public static WorldMap getMapOfMaps(String Dir) throws Exception
	{
		WorldMap worldMap;
		ObjectInputStream reader = null;
		
		try
		{
			FileInputStream door = new FileInputStream(Dir);
			reader = new ObjectInputStream(door);
			worldMap = ((WorldMap)reader.readObject());
		}
		catch (ClassNotFoundException | IOException e)
		{
			throw e;
		}
		finally
		{
			reader.close();
		}

		return worldMap;
	}

	
	public static Object load(String Dir) throws Exception
	{
		Object object = null;
		ObjectInputStream reader = null;
		
		try
		{
			FileInputStream door = new FileInputStream(Dir);
			reader = new ObjectInputStream(door);
			object = reader.readObject();
		}
		catch (ClassNotFoundException | IOException e)
		{
			throw e;
		}
		finally
		{
			reader.close();
		}
		return object;
	}
}
