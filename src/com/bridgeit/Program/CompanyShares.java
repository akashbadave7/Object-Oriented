package com.bridgeit.Program;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CompanyShares {

	public static void main(String[] args) throws IOException, ParseException 
	{
		Scanner scan = new Scanner(System.in);
		File file = new File("/home/bridgeit/Akash/ObjectOriented/src/Companyshare.json");
		FileReader fr = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(fr);
		List list = new List();
		Iterator itr = array.iterator();
		LinkedList ll = new LinkedList();
		while(itr.hasNext())
		{
			JSONObject obj = new JSONObject();
			obj = (JSONObject) itr.next();
			ll.add(obj);
			System.out.println("Enter the company name check");
			System.out.println(ll);
			System.out.println(ll.size());
		}
		
	}

}
