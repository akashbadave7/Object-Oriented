package com.bridgeit.Utility;


import java.util.Comparator;

import org.json.simple.JSONObject;

public class SortAddressBook implements Comparator<Object> 
{
	String str ;
	public SortAddressBook(String str) 
	{
		this.str =str;
	}

	public int compare(Object o1, Object o2) 
	{
		JSONObject obj1=(JSONObject)o1;  
		JSONObject obj2=(JSONObject)o2;  
		return (obj1.get(str).toString()).compareTo(obj2.get(str).toString());
	}

}
