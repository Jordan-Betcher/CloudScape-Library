package helper;

public class FileCheck
{
	/**
	 * http://stackoverflow.com/questions/3024002/how-to-create-a-folder-in-java
	 */
	public static void createFile(String directory)
	{
		
		java.io.File file = new java.io.File(directory);
		
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
		java.io.File file = new java.io.File(directory);
		if (file.isDirectory())
		{
			return true;
		}
		
		return false;
	}
}
