package com.bridgeit.Program;

import java.awt.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CompanyShares {

	private static Scanner scan;

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException, ParseException 
	{
		scan = new Scanner(System.in);
		Stack stk = new Stack();
		Queue que = new Queue();
		File file = new File("/home/bridgeit/Akash/ObjectOriented/src/Companyshare.json");
		FileReader fr = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(fr);
		List list = new List();
		Iterator itr = array.iterator();
		LinkedList ll = new LinkedList();
		System.out.println("Enter the share symbol");
		String symbol = scan.nextLine();
		while(itr.hasNext())
		{
			JSONObject obj = (JSONObject) itr.next();
			//ll.add(obj.get(symbol));
			//System.out.println(ll);
			if(obj.containsKey(symbol))
			{
				System.out.println("Share symbol already their in list");
				System.out.println("To add share press 1 and To remove share press 2");
				int choice = scan.nextInt();
				switch(choice)
				{
				case 1 : 
							System.out.println("Enter the number of share want to buy");
							int num_share = scan.nextInt();
							JSONObject object = (JSONObject) obj.get(symbol);
							int key = Integer.parseInt(object.get("NumOfShare").toString());
							int new_shares_count = key + num_share;
							object.remove("NumOfShare");
							object.put("NumOfShare", new_shares_count);
							FileWriter fw = new FileWriter(file);
							fw.write(JSONValue.toJSONString(array));
							fw.flush();
							fw.close();
						
					break;
				case 2 : 	System.out.println("Enter the amount of share to sale");
							int amt = scan.nextInt();
							JSONObject object1 = (JSONObject) obj.get(symbol);
							int share_amt = Integer.parseInt(object1.get("ShareAmt").toString());
							int num_share1 = Integer.parseInt(object1.get("NumOfShare").toString());
							int new_shares_count1 = num_share1 - (amt/share_amt);
							object1.remove("NumOfShare");
							object1.put("NumOfShare", new_shares_count1);
							FileWriter fw1 = new FileWriter(file);
							fw1.write(JSONValue.toJSONString(array));
							fw1.flush();
							fw1.close();
					break;
				}
				
			}
			else
			{
				JSONObject object = new JSONObject();
				System.out.println("Enter number of share");
				int num = scan.nextInt();
				System.out.println("Enter share amount");
				int amt = scan.nextInt();
				object.put("NumOfShare",num );
				object.put("ShareAmt",amt);
				obj.put(symbol,object);
				System.out.println("Added succesfull");
				stk.push(symbol);
				stk.display();
				que.insert(symbol);
				que.display();
				FileWriter fw = new FileWriter(file);
				fw.write(JSONValue.toJSONString(array));
				fw.flush();
				fw.close();
			}
			
		}
		
	}
}
