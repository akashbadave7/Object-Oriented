package com.bridgeit.Program;
import com.bridgeit.Utility.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;  
public class InventoryManagement 
{
	public static void main(String args[]) throws IOException, ParseException
	{    
		Utility.writingData();
		Utility.readingData();
	}
}