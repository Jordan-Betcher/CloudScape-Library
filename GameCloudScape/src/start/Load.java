package start;

import game.worldmap.WorldMap;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Load
{
	
	/**
	 * Loads File at the directory
	 * 
	 * @author pplluumm
	 * @param Dir
	 */
	public static void mapOfMaps(String Dir)
	{
		WorldMap worldMap = null;
		try
		{
			FileInputStream door = new FileInputStream(Dir);
			ObjectInputStream reader = new ObjectInputStream(door);
			try
			{
				worldMap = ((WorldMap)reader.readObject());
				new game.screen.Screen();
			} 
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			reader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
