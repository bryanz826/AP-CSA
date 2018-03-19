package lab15e;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/17
//Class - APCSA 
//Lab  - 15e

//import java.util.Arrays;
//import java.util.Scanner;
//import java.io.File;
//import java.io.IOException;
//import static java.lang.System.*;

public class NumberSort
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;
		while(number > 0) {
			number/=10;
			count++;
		}
		return count;
	}
	
	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits(number)];
		
		//build array
		int index = 0;
		while(number > 0) {
			int digit = number % 10;
			sorted[index++] = digit;
			number/=10;
		}
		
		//sort array
		for(int i = 0; i < sorted.length; i++) {
			for(int j = 0; j < sorted.length-1; j++) {
				if(sorted[j] > sorted[j+1]) {
					int temp = sorted[j];
					sorted[j] = sorted[j+1];
					sorted[j+1] = temp;
				}
			}
		}
		
		return sorted;
	}
}