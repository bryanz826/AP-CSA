package lab22c;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/17
//Class -  APCSA
//Lab  - 22c

//import java.util.Collections;
//import java.util.ArrayList;
import static java.lang.System.*;

public class Lab22c
{
	public static void main(String args[])
	{
		InsertionSort test = new InsertionSort();
		out.println("adding alice");
		test.add("alice");
		out.println("adding tommy");
		test.add("tommy");
		out.println("adding bobby");
		test.add("bobby");
		out.println("printing the list ::  "+test+"\n\n");
		out.println("removing bobby");
		test.remove("bobby");
		out.println("printing the list ::  "+test+"\n\n");
		out.println("removing alice");
		test.remove("alice");
		out.println("printing the list ::  "+test+"\n\n");
		out.println("adding fred");
		test.add("fred");
		out.println("adding xylophone");
		test.add("xylophone");
		out.println("printing the list ::  "+test+"\n\n");
		out.println("removing bobby");
		test.remove("tommy");
		test.remove("tommy");  //should do nothing		
		out.println("printing the list ::  "+test+"\n\n");		
		out.println("removing fred");
		test.remove("fred");  		
		out.println("printing the list ::  "+test+"\n\n");				
	}
}