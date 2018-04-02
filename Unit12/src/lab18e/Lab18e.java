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
import lab18e.Word;
import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{
		//analyze file with new "list" upon finish
		Scanner file = null;
		try {
			file = new Scanner(new File("src\\lab18e\\lab18e.dat"));
			int size = file.nextInt();
			file.nextLine();
			Word[] list = new Word[size];
			for(int i = 0; i < size; i++) {
				list[i] = new Word(file.next());
			} file.close();
			
			//sort
			for(int i = 0; i < list.length; i++) {
				for(int j = 0; j < list.length-1; j++) {
					if(list[j].compareTo(list[j+1]) == 1) {
						Word t = list[j+1];
						list[j+1] = list[j];
						list[j] = t;
					}
				}
			}
					
			//display sorted
			for(Word w : list) out.println(w);
		} catch(IOException e) {
			out.println(e);
		} finally {
			if(file != null) file.close();
		}
	}
}