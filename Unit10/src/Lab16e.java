//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/8
//Class - APCSA
//Lab  - 16e

//import java.io.File;
import java.io.IOException;
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.Collections;
import static java.lang.System.*;

public class Lab16e
{
	public static void main( String args[] ) throws IOException
	{
		Histogram test1 = new Histogram(new char[]{'a','b','c'},"D:\\Program Files\\csa\\readUnits (this is just for my reference)\\Unit10\\Unit10-2016\\Unit10-Assignments\\Lab16e\\Lab16e1.dat");
		test1.loadAndAnalyzeFile();
		out.println("Letters occurring most : "+test1.mostFrequent());
		out.println("Letters occurring least : "+test1.leastFrequent());
		out.println("\n");
		out.println(test1);

		Histogram test2 = new Histogram(new char[]{'d','e','a'},"D:\\Program Files\\csa\\readUnits (this is just for my reference)\\Unit10\\Unit10-2016\\Unit10-Assignments\\Lab16e\\Lab16e2.dat");
		test2.loadAndAnalyzeFile();
		out.println("Letters occurring most : "+test2.mostFrequent());
		out.println("Letters occurring least : "+test2.leastFrequent());
		out.println("\n");
		out.println(test2);
		
		Histogram test3 = new Histogram(new char[]{'x','a','r','g'},"D:\\Program Files\\csa\\readUnits (this is just for my reference)\\Unit10\\Unit10-2016\\Unit10-Assignments\\Lab16e\\Lab16e3.dat");
		test3.loadAndAnalyzeFile();
		out.println("Letters occurring most : "+test3.mostFrequent());
		out.println("Letters occurring least : "+test3.leastFrequent());
		out.println("\n");
		out.println(test3);
	}
}