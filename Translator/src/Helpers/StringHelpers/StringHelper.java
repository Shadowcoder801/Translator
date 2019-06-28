package Helpers.StringHelpers;

import java.util.ArrayList;
import java.util.List;

public class StringHelper 
{
	/**
	 * Deletes any leading tabs, spaces, or \n's in a String.
	 * 
	 * @param text The String to be stripped of leading white space.
	 * @return The String without leading white space.
	 */
	public static String deleteLeadingWhiteSpace(String text)
	{
		String out = "";
		
		for (int i = 0; (i < text.length() && out.isEmpty()); i++)
		{
			char ch = text.charAt(i);
			
			if (ch != ' ' && ch != '\t')
			{
				out = text.substring(i);
			}
		}
			
		return out;
	}
	
	public static String deleteSurroundingWhiteSpace(String text)
	{
		return deleteLeadingWhiteSpace(deleteTrailingWhiteSpace(text));
	}
	
	public static String deleteTrailingWhiteSpace(String text)
	{
		String out = "";
		
		for (int i = text.length() - 1; (i >= 0 && out.isEmpty()); i--)
		{
			char ch = text.charAt(i);
			
			if (ch != ' ' && ch != '\t')
			{
				out = text.substring(0, i + 1);
			}
		}
			
		return out;
	}
	
	/**
	 * Converts a list of Strings into a single String with every String in
	 * the list separated by the delimiter specified in the parameter.  The user
	 * can choose to place the delimiter at the beginning and/or end of the string if
	 * he / chooses to do so.
	 * 
	 * @param list The list of Strings to be converted into a String.
	 * @param delimiter The String used to separate the Strings of the list
	 * @param atStart Whether or not to place the delimiter at the beginning of the String
	 * @param atEnd Whether or not to place the delimiter at the end of the String
	 */
	public static String join(List <String> list, String delimiter, boolean atStart, boolean atEnd)
	{
		StringBuilder sb = new StringBuilder(list.size() * 10);
		
		if (atStart)
		{
			sb.append(delimiter);
		}
		
		for (int i = 0; i < list.size(); i++)
		{
			sb.append(list.get(i) + ((i == list.size() - 1) ? "" : delimiter));
		}
		
		if (atEnd)
		{
			sb.append(delimiter);
		}
		
		return sb.toString();
	}
	
	/**
	 * Converts a list of Strings into a single String with every String in
	 * the list separated by the character \n.  There is no \n character
	 * added to the beginning or end of the String.
	 * 
	 * @param list The list of Strings to be converted into a String.
	 * @return The String made of the list of Strings separated by a \n.
	 */
	public static String listToString(List <String> list)
	{
		StringBuilder sb = new StringBuilder(list.size() * 10);
		
		for (int i = 0; i < list.size(); i++)
		{
			sb.append(list.get(i) + ((i == list.size() - 1) ? "" : "\n"));
		}
		
		return sb.toString();
	}
	
	
	public static String[] microsoftExcelSplit(String text)
	{
		List <String> cellList = new ArrayList<>();
		boolean quotes = false;
		
		StringBuilder cell = new StringBuilder();
		for (int i = 0; i < text.length(); i++)
		{
			char ch = text.charAt(i);
			
			// If it is a regular comma separating cells
			if (ch == ',' && !quotes)
			{
				cellList.add(cell.toString());
				cell = new StringBuilder();
			}
			
			// If it is a start quote of a cell
			else if (ch == '\"' && !quotes)
			{
				quotes = true;
			}
			
			// If it is the end quote of the last cell
			else if (ch == '\"' && quotes && i == text.length() - 1)
			{
				cellList.add(cell.toString());
				quotes = false;
			}
			
			// If it is a double quote ("") within a cell
			else if (ch == '\"' && quotes && text.charAt(i + 1) == '\"')
			{
				cell.append('\"');
				i++;
			}
			
			// If it is the end quote of a cell (that is not the last cell)
			else if (ch == '\"' && quotes && text.charAt(i + 1) == ',')
			{
				cellList.add(cell.toString());
				cell = new StringBuilder();
				quotes = false;
				i++;
			}
			
			// This should never occur
			else if (ch == '\"' && quotes)
			{
				Integer.parseInt("Something unexpected occured: " + String.format("{ i: %d, ch + 1: %s, text: \"%s\"", 
						i, text.charAt(i + 1) + "", text));
			}
			
			// If it is just a character inside a cell
			else
			{
				cell.append(ch);
			}
		}
		
		String[] split = new String[cellList.size()];
		
		for (int i = 0; i < cellList.size(); i++)
		{
			split[i] = cellList.get(i);
		}
		
		return split;
	}
	
	/**
	 * Repeats a String without separators for an entered number of times.
	 * 
	 * @param text The String to be repeated
	 * @param times How many times the String is repeated
	 * @return
	 */
	public static String repeatString(String text, int times)
	{
		StringBuilder out = new StringBuilder(text.length() * times);
		
		for (int i = 0; i < times; i++)
		{
			out.append(text);
		}
		
		return out.toString();
	}
	
	/**
	 * Splits a String by its \n characters and puts the substrings into
	 * an ArrayList.  The \n characters are not included in the Strings of
	 * the list.  The capacity of the List is text.length()
	 * 
	 * @param text The text to be converted to a list.
	 * @return A List with the substrings between the \n characters
	 */
	public static List <String> stringToList(String text)
	{
		List <String> ls = new ArrayList<>(text.length());
		
		int startIdx = 0;
		for (int i = 0; i < text.length(); i++)
		{
			char ch = text.charAt(i);
			
			if (ch == '\n')
			{
				ls.add(text.substring(startIdx, i));
				startIdx = i + 1;
			}
		}
		
		ls.add(text.substring(startIdx, text.length()));
		
		return ls;
	}
	
	
	/**
	 * Checks if a substring of a String equals another String.
	 * The normal substring method will return an error if the indices are
	 * outside of the String's range.  In subEquals(), it will return false
	 * if that is the case with no Exception.
	 * 
	 * The substring checked will start at the start index and go up to but
	 * not including the upTo index.
	 * 
	 * @param text The text to check the substring of
	 * @param start The starting index of the substring
	 * @param upTo The ending index of the substring
	 * @param sub The String to check of if the substring of text is equal 
	 *  to.
	 * @return
	 */
	public static boolean subEquals(String text, int start, int upTo,
			String sub)
	{
		boolean subEquals = false;
		
		if (start >= 0 && 
			upTo >= 0 &&
			start < text.length() &&
			upTo <= text.length() &&
			upTo >= start &&
			text.substring(start, upTo).equals(sub))
		{
			subEquals = true;
		}
		
		return subEquals;
	}
	
	/**
	 * Checks if a substring of a StringBuilder equals a specified String.
	 * The normal substring method will return an error if the indices are
	 * outside of the String's range.  In subEquals(), it will return false
	 * if that is the case with no Exception.
	 * 
	 * The substring checked will start at the start index and go up to but
	 * not including the upTo index.
	 * 
	 * @param text The text to check the substring of
	 * @param start The starting index of the substring
	 * @param upTo The ending index of the substring
	 * @param sub The String to check of if the substring of text is equal 
	 *  to.
	 * @return
	 */
	public static boolean subEquals(StringBuilder text, int start, int upTo,
			String sub)
	{
		boolean subEquals = false;
		
		if (start >= 0 && 
			upTo >= 0 &&
			start < text.length() &&
			upTo <= text.length() &&
			upTo >= start &&
			text.substring(start, upTo).equals(sub))
		{
			subEquals = true;
		}
		
		return subEquals;
	}
	
	/**
	 * Takes in a String and returns the String with only the first letter in the String capitalized.
	 * 
	 * @param text
	 * @return
	 */
	public static String toNameCase(String text)
	{
		if (text.isEmpty())
		{
			return text;
		}
		
		String firstLetter = "" + text.charAt(0);
		String otherLetters = text.substring(1);
		
		return firstLetter.toUpperCase() + otherLetters.toLowerCase();
	}
	
	public static abstract class ToString <T>
	{
		public abstract String toString(T value);
	}
	
	public static abstract class ToJavaScriptString <T> extends ToString
	{
		public abstract String toString(int indent, String value);
		
		protected String spaces(int n)
		{
			return repeatString(" ", n);
		}
	}
}
