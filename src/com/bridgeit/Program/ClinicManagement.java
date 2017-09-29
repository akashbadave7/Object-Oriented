package com.bridgeit.Program;
import com.bridgeit.Utility.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgeit.Utility.Appointment;
import com.bridgeit.Utility.*;
public class ClinicManagement 
{
	public static void main(String[] args) 
	{
		try
		{
			Appointment a = new Appointment();
			ClinicUtility u = new ClinicUtility();
			Scanner scan = new Scanner(System.in);
			while(true)
			{	
				System.out.println("Enter your choice:");
				System.out.println("1. Add Doctor.");
				System.out.println("2. Add Patient.");
				System.out.println("3. Display Details.");
				System.out.println("4. Fix Appointments.");
				System.out.println("5. Appointment Details.");
				System.out.println("6. Exit");
				int choice = scan.nextInt();
				switch(choice)
				{
				case 1 :	 u.addDoctor();
				break;
				case 2 :	u.addPatient();
				break;
				case 3 :	 System.out.println("Enter whose details you want to see press D for doctor and P for Patient ");
							char ch = scan.next().charAt(0);
							if(ch=='D')
							{
								u.doctorsDetails();
							}
							if(ch=='P')
							{
								u.patientDetails();
							}
				break;
				case 5 	:	u.appointmentDetails();
				break;
				case 4: 	a.fixAppointment();
				break;
				default : return;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
