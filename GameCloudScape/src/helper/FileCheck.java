package helper;

import java.io.File;

public class FileCheck
{
	/**
	 * http://stackoverflow.com/questions/3024002/how-to-create-a-folder-in-java
	 */
	public static void createFile(String directory)
	{
		
		File file = new File(directory);
		
		try
		{
			if (file.mkdir())
			{
				System.out.println("Directory Created");
			} 
			else
			{
				System.out.println("Directory is not created");
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean exists(String directory)
	{
		File file = new File(directory);
		if (file.isDirectory())
		{
			return true;
		}
		
		return false;
	}
}
