package DataTranslator;

import java.util.Hashtable;
import java.util.List;

import FileHelpers.FileHelper;

public class Dictionary 
{
	private static final int INITIAL_CAPACITY = 300000;
	private static final float LOAD_CAPACITY = (float) 0.75;
	
	private Hashtable <Integer, TranslationEntry> data;
	
	public Dictionary()
	{
		data = new Hashtable<>(INITIAL_CAPACITY, LOAD_CAPACITY);
	}
	
	public Dictionary(String dir)
	{
		this();
		collectData(dir);
	}
	
	public void collectData(String dir)
	{
		data.clear();
		
		appendData(dir);
	}
	
	public void appendData(String dir)
	{
		List <String> entries = FileHelper.toList(dir);
		for (int i = 0; i < entries.size(); i++)
		{
			String[] entryArray = entries.get(i).split("[,]");
			
			TranslationEntry t = new TranslationEntry(entryArray[0], entryArray[1]);
					
			data.put(t.hashCode(), t);
		}
	}
	
	public void put(String from, String dest)
	{
		TranslationEntry t = new TranslationEntry(from, dest);
		
		data.put(t.hashCode(), t);
	}
	
	public String getTranslation(String from)
	{
		return data.get(from.hashCode()).dest();
	}
	
	public static String translate(String phrase)
	{
		return null;
	}
	
	public static void main(String[] args)
	{
		Dictionary d = new Dictionary("../../Desktop/Vietnam_Data.txt");
		
		System.out.println(d.getTranslation("apple"));	
		System.out.println(d.getTranslation("lemon"));
		System.out.println(d.getTranslation("cherry"));
	}
}
