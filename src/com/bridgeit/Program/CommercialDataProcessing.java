package com.bridgeit.Program;
import com.bridgeit.Utility.Utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CommercialDataProcessing
{
	public static void main(String []args) throws IOException, ParseException 
	{
		Scanner scan = new Scanner(System.in);
		while(true)
		{	
			System.out.println("Enter your choice:");
			System.out.println("1. Create user");
			System.out.println("2. Buy Share");
			System.out.println("3. Sale Share");
			System.out.println("4. Display Details");
			System.out.println("5. Exit");
			int choice = scan.nextInt();
			switch(choice)
			{
			case 1:	 	Utility.createAcc();
			break;
			case 2 :	Utility.buyShare();
			break;
			
			case 3 :	Utility.saleShare();
			break;
			case 4 :	Utility.display();
			break;
			default : return;
			}
		}
	}
}