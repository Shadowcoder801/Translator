package DataTranslator;

import Helpers.StringHelpers.StringHelper;

public class TranslationEntry 
{
	private String from;
	private String dest;
	
	public TranslationEntry(String from, String dest)
	{
		this.from = StringHelper.deleteSurroundingWhiteSpace(from);
		this.dest = StringHelper.deleteSurroundingWhiteSpace(dest);
	}
	
	public String from()
	{
		return from;
	}
	
	public String dest()
	{
		return dest;
	}
	
	@Override
	public int hashCode()
	{
		return from.hashCode();
	}
}
