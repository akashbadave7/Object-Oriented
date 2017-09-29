package com.bridgeit.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Demo {

	public static void main(String[] args) throws IOException, ParseException 
	{
		File file = new File ("/home/bridgeit/Akash/ObjectOriented/src/Doctor.json");

		Scanner scan = new Scanner(System.in);
		JSONParser parser = new JSONParser();
		FileReader doctor = new FileReader(file);
		JSONArray docArray = (JSONArray) parser.parse(doctor);
		Iterator iterator = docArray.iterator();
		System.out.println("Enter Doctor id to remove appointment");
		String id = scan.next();
		boolean flag = false;
		while (iterator.hasNext())
		{
			JSONObject obj = (JSONObject) iterator.next();
			String id1 = obj.get("Id").toString();
			if(id1.equals(id))
			{
				JSONArray patient1 =(JSONArray) obj.get("Patient");
				System.out.println(patient1);
				/*Iterator itr = patient1.iterator();
				while(itr.hasNext())
				{
					JSONObject obj1 = (JSONObject) iterator.next();
					System.out.println(obj.get("Patient"));
				}*/
			}
		}
		if(flag==false)
		{
			System.out.println("Wrong Doctor id...Plz Try again");
		}
	}
}

