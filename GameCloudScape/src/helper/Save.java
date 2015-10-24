package helper;

import game.worldmap.WorldMap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save
{
	private static final String	SAVEFOLDER	= "Saves/";
	private static final String	SAVETYPE	= ".txt";
	
	public static void map(WorldMap map, String saveName)
		{
			String Dir = SAVEFOLDER + saveName + SAVETYPE;
			
			try
				{
					FileOutputStream fileOutputStream = new FileOutputStream(Dir);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
					
					objectOutputStream.writeObject(map);
					objectOutputStream.flush();
					objectOutputStream.close();
				}
			catch(FileNotFoundException e)
				{
					e.printStackTrace();
				}
			catch(IOException e)
				{
					e.printStackTrace();
				}
		}
}
