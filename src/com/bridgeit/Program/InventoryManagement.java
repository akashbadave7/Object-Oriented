package com.bridgeit.Program;
import com.bridgeit.Utility.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;  
public class InventoryManagement 
{
	public static void main(String args[]) throws IOException, ParseException
	{    
		Utility u = new Utility();
		u.writingData();
		u.readingData();
	}
}