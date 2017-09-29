package com.bridgeit.Program;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class RegularExpression {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		String str = "Hello <<name>>, We have your full name as <<full name>> "
				+ "in our system. your contact number is 91-xxxxxxxxxx. "
				+ "Please,let us know in case of any clarification Thank you "
				+ "BridgeLabz 01/01/2016.";
		System.out.println("Enter your name:");
		String name = scan.nextLine();
		String arr[] = name.split(" ");
		System.out.println("Enter your Mob No.:");
		String mob = scan.nextLine();
		
		Date date = new Date();
		String d = new SimpleDateFormat().format(date);
		String d1[] = d.split(" ");
		str=str.replace("<<name>>", arr[0]);
		str=str.replace("<<full name>>", name);
		str=str.replace("xxxxxxxxxx", mob);
		str=str.replace("01/01/2016", d1[0]);
		System.out.println(str);
		
	}

}
