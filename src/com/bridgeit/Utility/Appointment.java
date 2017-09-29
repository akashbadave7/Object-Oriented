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

public class Appointment 
{
	public void fixAppointment()
	{
		try
		{
			Scanner scan = new Scanner(System.in);
			File file = new File ("/home/bridgeit/Akash/ObjectOriented/src/Doctor.json");
			File file1 = new File ("/home/bridgeit/Akash/ObjectOriented/src/Patient.json");
			if(file.exists() && file.exists())
			{
				if(file.canWrite() && file.canRead() && file1.canWrite() && file1.canRead())
				{
					JSONParser parser = new JSONParser();
					FileReader doctor = new FileReader(file);
					JSONArray docArray = (JSONArray) parser.parse(doctor);
					
					FileReader patient = new FileReader(file1);
					JSONArray patArray = (JSONArray) parser.parse(patient);
					
					//System.out.println(patArray.size());
					Iterator iterator = patArray.iterator();
					System.out.println("Enter the Patient id to get appointment");
					String pid = scan.nextLine();
					boolean flag=false;
					while (iterator.hasNext())
					{
						JSONObject object = (JSONObject) iterator.next();
						String key = object.get("Id").toString();
						if (pid.equals(key))
						{
							System.out.println("Enter the doctor id to assign patient");
							String did = scan.nextLine();
							Iterator iterator1 = docArray.iterator();
							
							while (iterator1.hasNext())
							{
								JSONObject object1 = (JSONObject) iterator1.next();
								String key1 = object1.get("Id").toString();
								if (key1.equals(did))
								{
									JSONArray arr = (JSONArray) object1.get("Patient");
					
									if (arr.size()==2)
									{
										System.out.println("Doctor appointment is full ... Take appointment next day.");
										break;
									}
									else
									{
										arr.add(object);
										FileWriter write = new FileWriter(file);
										write.write(JSONValue.toJSONString(docArray));
										write.flush();
										flag = true;
										break;
									}
								}
							}
							break;
						}
					}
					if(flag==false)
					{
						System.out.println("Wrong user id");
					}
				}
				else
				{
					System.out.println("File can not read or write");
				}
			}
			else
			{
				System.out.println("File Not exits in disk.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
