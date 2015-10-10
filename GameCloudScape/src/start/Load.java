package start;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Load
{
	public static void mapOfMaps(String Dir)
	{
		//Map gameMap = null;
		try
			{
				FileInputStream door = new FileInputStream(Dir);
				ObjectInputStream reader = new ObjectInputStream(door);
				try
					{
						/*
						gameMap = ((Map)reader.readObject());
						ModeGame mode = new ModeGame(gameMap);
						CloudScapeMain.setMode(mode);
						*/
					//TODO create game mode
					}
				catch(ClassNotFoundException e)
					{
						e.printStackTrace();
					}
				reader.close();
			}
		catch(IOException e)
			{
				e.printStackTrace();
			}
		
	}
}
