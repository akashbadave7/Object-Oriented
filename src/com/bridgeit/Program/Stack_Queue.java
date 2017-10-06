package com.bridgeit.Program;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Stack_Queue {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		Queue que = new Queue();
		Stack stk = new Stack();
		while(true)
		{
			System.out.println("Do you want to buy share or sell 1- Buy and 2-Sale");
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice)
			{
				case 1 : 	System.out.println("Enter the symbol to buy share");
							String symbol = scan.nextLine();
							Date d = new Date();
							String date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(d);
							System.out.println(date);
							stk.push(symbol);
							que.insert(date);
							stk.display();
							que.display();
							
							break;
				case 2	:
							stk.pop();
							stk.display();
							break;
				default : return;
			}
			
		}
	}
}
