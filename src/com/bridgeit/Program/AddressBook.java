package com.bridgeit.Program;
import com.bridgeit.Utility.*;

import java.io.IOException;
import java.util.Scanner;

public class AddressBook 
{
	public static void main(String[] args) throws IOException 
	{
		try
		{
			AddressBookUtility addressbook = new AddressBookUtility();
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
				case 1:	 	addressbook.addPerson();
				break;
				case 2 :	addressbook.deletePerson();
				break;
				case 3 : 	addressbook.editDetails();
				break;
				case 4 :	addressbook.sort();
				break;
				case 5 :	addressbook.displayDetails();
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
