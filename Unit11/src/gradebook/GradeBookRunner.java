package gradebook;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/14
//Class - APCSA
//Lab  - 19b

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.*;
//import static java.util.Arrays.*;

public class GradeBookRunner
{
   public static void main( String args[] )
   {
	   	Scanner keyboard = new Scanner(System.in);
		ArrayList<Class> classes = new ArrayList<Class>();
	   
		out.println("Welcome to the Class Stats program!");
		
		String resp = "y";
		do {
			out.println();
			out.print("What is the name of the class? ");
			String name = keyboard.next();
			out.print("How many students are in the class? ");
			int stuCount = keyboard.nextInt();
			Class c = new Class(name, stuCount);
			classes.add(c);
			
			out.print("Would you like to add more classes? ");
			resp = keyboard.next();
		} while(resp.substring(0,1).toLowerCase().equals("y"));
		
		out.print("\n"+Arrays.toString(classes.toArray()));
		keyboard.close();
		
	}		
}