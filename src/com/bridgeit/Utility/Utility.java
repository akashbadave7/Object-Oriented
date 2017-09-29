package com.bridgeit.Utility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utility 
{
	// Inventory Managemnt
	public static void readingData() throws IOException, ParseException 
	{
		File file =new File("D:/Akash/ObjectOriented/src/File.json");
		FileReader fr = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(fr);
		Iterator<?> iterator = obj.keySet().iterator(); 
		while(iterator.hasNext()) 
		{
		    String topkey = (String) iterator.next();
			JSONObject jsonObject1=(JSONObject)obj.get(topkey);
			Iterator<?> iterator1 = jsonObject1.keySet().iterator(); 
			
			while(iterator1.hasNext()) 
			{
				String key=(String) iterator1.next();
				System.out.println(key+" : "+jsonObject1.get(key));
			}
			System.out.println("The Toatal cost of "+jsonObject1.get("Name")+" is: "+Integer.parseInt(jsonObject1.get("Price").toString())*Integer.parseInt(jsonObject1.get("Weight").toString()));
		}
	}

	public static void writingData() throws IOException
	{
		File file =new File("D:/Akash/ObjectOriented/src/File.json");
		FileWriter fw = new FileWriter(file);
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		JSONObject obj3 = new JSONObject();
		obj1.put("Name", "Rice");
		obj1.put("Weight", 100);
		obj1.put("Price", 50);
		
		obj2.put("Name", "Pulses");
		obj2.put("Weight", 80);
		obj2.put("Price", 40);
		
		obj3.put("Name", "Wheat");
		obj3.put("Weight", 30);
		obj3.put("Price", 40);
		JSONObject items = new JSONObject();
		
		items.put("Rice", obj1);
		items.put("Pulse", obj2);
		items.put("Wheat", obj3);
		fw.write(JSONValue.toJSONString(items));
		fw.flush();
	}
	
	// Share and Stock report
	public static void display() throws IOException, ParseException 
	{
		File file = new File("D:/Akash/ObjectOriented/src/Demo");
		FileReader fr = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray arr1 = (JSONArray) parser.parse(fr);
		Iterator itr = arr1.iterator();
		while (itr.hasNext())
		{
			JSONObject obj = (JSONObject) itr.next();
			System.out.println(obj);
		}
	}

	public static void saleShare() throws IOException, ParseException 
	{
		File file = new File("D:/Akash/ObjectOriented/src/Demo");
		Scanner scan = new Scanner(System.in);
		// reading stock file
		FileReader fr = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray stock = (JSONArray) parser.parse(fr);
		//reading share file
		File file1 =new File("D:/Akash/ObjectOriented/src/Demo1");
		FileReader sf = new FileReader(file1);
		JSONParser parser1 = new JSONParser();
		JSONArray share = (JSONArray) parser1.parse(sf);
		
		System.out.println("Enter the user");
		String name = scan.nextLine();
		Iterator<?> itr = stock.iterator();
		Iterator<?> itr1 = share.iterator();
		while (itr.hasNext())
		{
			JSONObject obj=(JSONObject) itr.next();
			if(obj.get("Name").equals(name))
			{
				System.out.println("Enter the share sysmbol to sale share:[@,!,#]");
				String sym = scan.nextLine();
				System.out.println("Enter the number of share to sale");
				int count= scan.nextInt();
				obj.put("Share Symbol", sym);
				while(itr1.hasNext())
				{
					JSONObject obj1 = (JSONObject) itr1.next();
					if(obj1.get("Symbol").equals(sym))
					{	
						int bal =  Integer.parseInt(obj.get("Balance").toString());
						int price = Integer.parseInt(obj1.get("Price").toString());
						int noShare =  Integer.parseInt(obj.get("ShareCount").toString());
						int stockShare = Integer.parseInt(obj1.get("Count").toString());
						int saleprize = count*price;
						int newbal = bal+saleprize;
						int sharecountcus = noShare-count;
						int sharecountstock = stockShare+count;
						obj.remove("Balance");
						obj.remove("ShareCount");
						obj1.remove("Count");
						
						obj.put("Balance",newbal);
						obj.put("ShareCount",sharecountcus);
						obj1.put("Count", sharecountstock);
						break;
					}
					
				}
			}
			FileWriter fs = new FileWriter(file);
			fs.write(JSONValue.toJSONString(stock));
			fs.flush();	
		}
		FileWriter fw = new FileWriter(file1);
		fw.write(JSONValue.toJSONString(share));
		fw.flush();
	}

	public static void buyShare() throws IOException, ParseException 
	{
		File file = new File("D:/Akash/ObjectOriented/src/Demo");
		Scanner scan = new Scanner(System.in);
		// reading stock file
		FileReader fr = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray stock = (JSONArray) parser.parse(fr);
		//reading share file
		File file1 =new File("D:/Akash/ObjectOriented/src/Demo1");
		FileReader sf = new FileReader(file1);
		JSONParser parser1 = new JSONParser();
		JSONArray share = (JSONArray) parser1.parse(sf);
		
		System.out.println("Enter the user");
		String name = scan.nextLine();
		Iterator<?> itr = stock.iterator();
		Iterator<?> itr1 = share.iterator();
		while (itr.hasNext())
		{
			JSONObject obj=(JSONObject) itr.next();
			if(obj.get("Name").equals(name))
			{
				System.out.println("Enter the share sysmbol to buy share:[@,!,#]");
				String sym = scan.nextLine();
				System.out.println("Enter the amount");
				int amt= scan.nextInt();
				obj.put("Share Symbol", sym);
				while(itr1.hasNext())
				{
					JSONObject obj1 = (JSONObject) itr1.next();
					if(obj1.get("Symbol").equals(sym))
					{	
						int bal =  Integer.parseInt(obj.get("Balance").toString());
						int price = Integer.parseInt(obj1.get("Price").toString());
						int noShare =  Integer.parseInt(obj.get("ShareCount").toString());
						int stockShare = Integer.parseInt(obj1.get("Count").toString());
						int numofshare = amt/price;
						int newbal = bal-amt;
						int sharecountcus = noShare+numofshare;
						int sharecountstock = stockShare-numofshare;
						obj.remove("Balance");
						obj.remove("ShareCount");
						obj1.remove("Count");
						
						obj.put("Balance",newbal);
						obj.put("ShareCount",sharecountcus);
						obj1.put("Count", sharecountstock);
						break;
					}
					
				}
			}
			FileWriter fs = new FileWriter(file);
			fs.write(JSONValue.toJSONString(stock));
			fs.flush();	
		}
		FileWriter fw = new FileWriter(file1);
		fw.write(JSONValue.toJSONString(share));
		fw.flush();
	}

	public static void createAcc() throws IOException, ParseException 
	{
		File file = new File("D:/Akash/ObjectOriented/src/Demo");
		JSONArray arr = new JSONArray();
		Scanner scan1 = new Scanner(System.in);
		boolean check= true;
		while (check==true)
		{	
			System.out.println("Want to add user: y or n");
			char ch = scan1.next().charAt(0); 
			if(ch=='y')
			{	
				Scanner scan = new Scanner(System.in);
				FileReader fr = new FileReader(file);
				JSONParser parser = new JSONParser();
				JSONArray arr1 = (JSONArray) parser.parse(fr);
				JSONObject json = new JSONObject();
		        System.out.println("Enter name");
		        String name = scan.nextLine();
		        System.out.println("Enter balance");
		        int bal = scan.nextInt();
		        json.put("Name",name);
		        json.put("Balance",bal);
		        json.put("ShareCount", 100);
		    
		        arr1.add(json);
		      	FileWriter fw = new FileWriter(file);
		        fw.write(JSONArray.toJSONString(arr1));
		        fw.flush();
			}
			else
			{
				check=false;
			}
		}
	}
	
	//Stock Report
	public static void calculateStockReport() throws IOException, ParseException 
	{
		File file = new File("D:/Akash/ObjectOriented/src/StockReport");
		FileReader fr = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray arr = (JSONArray) parser.parse(fr);
		long total=0;
		Iterator itr = arr.iterator();
		while (itr.hasNext())
		{
			JSONObject obj = (JSONObject) itr.next();
			Iterator<?> iterator = obj.keySet().iterator(); 
			while(iterator.hasNext()) 
			{
			    String topkey = (String) iterator.next();
				JSONObject jsonObject1=(JSONObject)obj.get(topkey);
				Iterator<?> iterator1 = jsonObject1.keySet().iterator(); 
				System.out.println("Company Name: " +topkey);
				long price = (long) jsonObject1.get("Price");
				long shares = (long) jsonObject1.get("NumShare");
				total += price*shares;
				System.out.println("Share price: "+price);
				System.out.println("Number of Shares: "+shares);
			}
		}
		System.out.println("Total cost of share is : "+total);
	}
	
	//DECKOFCARD
	public void initialize(int[] deck) 
	{
		// Initialize cards
	    for (int i = 0; i < deck.length; i++) 
	    {
	      deck[i] = i;
	    }
		
	}
	
	public int[] shuffleCards(int[] deck) 
	{
		// Shuffle the cards
	    for (int i = 0; i < deck.length; i++) 
	    {
	      int index = i + (int)(Math.random() * (52-i));
	      int temp = deck[i];
	      deck[i] = deck[index];
	      deck[index] = temp;
	      //System.out.println(i+"->"+index);
	    }
	    return deck;
	}
	
	public void generateCard(String[] arr, int[] deck, String[] suits, String[] ranks) 
	{
		for (int i = 0; i < 52; i++) 
	    {
	      String suit = suits[deck[i] / 13];
	      String rank = ranks[deck[i] % 13];
	      arr[i]=( rank + "->" + suit);
	    }
	}

	public void distribute(int[] deck, String[] arr) 
	{
		String arr1[][] = new String[4][9];
	    Random r = new Random();
	    int m = deck.length;
	    for(int i=0;i<4;i++)
		{
			for(int j=0;j<9;j++)
			{	
				int a = r.nextInt(m);
				arr1[i][j] = arr[a];
			}
		}
	    for(int i=0;i<arr1.length;i++)
		{	
			System.out.print("Player"+(i+1)+": ");
			for(int j=0;j<arr1[i].length;j++)
			{
				System.out.print(arr1[i][j]+ "\t");
			}
			System.out.println();
		}	
	    
	    System.out.println("--------------------------------");
		   for (String outer[] : arr1) 
		   {
		       Arrays.sort(outer);

		       for (String integer : outer) {
		           System.out.print(integer+"\t");
		       }
		       System.out.println();
		   }
	}

}
