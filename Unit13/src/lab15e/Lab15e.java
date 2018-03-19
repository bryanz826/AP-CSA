package lab15e;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/17
//Class - APCSA 
//Lab  - 15e

//import java.util.Arrays;
import static java.lang.System.*;

public class Lab15e
{
	public static void main(String args[])
	{
		//test case 1
		int[] one = NumberSort.getSortedDigitArray(567891);
		for(int item : one) out.print(item + " ");
		out.println();
		
		//test case 2	
		int[] two = NumberSort.getSortedDigitArray(901912468);
		for(int item : two) out.print(item + " ");
		out.println();

		
		//test case 3
		int[] three = NumberSort.getSortedDigitArray(864213507);
		for(int item : three) out.print(item + " ");
		out.println();
	}
}