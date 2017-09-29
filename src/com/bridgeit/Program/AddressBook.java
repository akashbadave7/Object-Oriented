package com.bridgeit.Program;
import com.bridgeit.Utility.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.Utility.SortAddressBook;
import com.bridgeit.Utility.Utility;

public class AddressBook 
{
	public static void main(String[] args) throws IOException 
	{
		try
		{
			AddressBookUtility a = new AddressBookUtility();
			Scanner scan = new Scanner(System.in);
			while(true)
			{	
				System.out.println("Enter your choice:");
				System.out.println("1. Add New Person");
				System.out.println("2. Delete Person");
				System.out.println("3. Edit Details");
				System.out.println("4. Sort");
				System.out.println("5. Display Details");
				System.out.println("6. Exit");
				int choice = scan.nextInt();
				switch(choice)
				{
				case 1:	 	a.addPerson();
				break;
				case 2 :	a.deletePerson();
				break;
				case 3 : 	a.editDetails();
				break;
				case 4 :	a.sort();
				break;
				case 5 :	a.displayDetails();
				break;
				default : return;
				}
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
}
