package FileHelpers;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHelper 
{
	/**
	 * Returns the number of lines in a given file
	 * 
	 * @param dir The directory of the file.
	 * @return The number of lines in the file.
	 */
	public static int getLength(String dir)
	{
		int length = 0;;
		
		try
		{
			File file = new File(dir);
			Scanner reader = new Scanner(file);
			
			while(reader.hasNext())
			{
				reader.nextLine();
				length++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return length;
	}
	
	/**
	 * Converts a list of Strings into a file, each String separated by a line on the file 
	 * 
	 * @param List <String> texts the Strings to be put on the file
	 * @param dir The directory of the file.
	 */
	public static void toFile(List <String> texts, String dir)
	{
		try
		{
			PrintWriter pw = new PrintWriter(dir);
			
			for (String s: texts)
			{
				pw.println(s);
			}
			
			pw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a list of Strings with each String corresponding with a line
	 * of a file.  
	 * 
	 * @param dir The directory of the file.
	 * @return The list of Strings for each line.
	 */
	public static List <String> toList(String dir)
	{
		List <String> out = new ArrayList <String> (getLength(dir));
		
		try
		{
			File file = new File(dir);
			Scanner reader = new Scanner(file);
			
			while (reader.hasNext())
			{
				out.add(reader.nextLine());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return out;
	}
	
	
}
