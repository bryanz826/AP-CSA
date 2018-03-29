package lab18e;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/16
//Class - APCSA
//Lab  - 18e

import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Arrays;
import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{
		//analyze file with new "list" upon finish
		Scanner file = new Scanner(new File("D:\\Program Files\\csa\\readUnits (this is just for my reference)\\Unit12\\Unit12-2016\\Unit12-Assignments\\lab18e\\lab18e.dat"));
		int size = file.nextInt();
		file.nextLine();
		Word2[] list = new Word2[size];
		for(int i = 0; i < size; i++) {
			list[i] = new Word2(file.next());
		} file.close();
		
		//sort
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < list.length-1; j++) {
				if(list[j].compareTo(list[j+1]) == 1) {
					Word2 t = list[j+1];
					list[j+1] = list[j];
					list[j] = t;
				}
			}
		}
				
		//display sorted
		for(Word2 w : list) out.println(w);










	}
}