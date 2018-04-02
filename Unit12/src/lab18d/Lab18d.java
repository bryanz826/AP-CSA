package lab18d;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/15
//Class - APCSA
//Lab  - 18d

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//import java.util.Arrays;
//import java.util.Collections;
import lab18d.Word;
import static java.lang.System.*;


public class Lab18d extends Object
{
	public static void main( String args[] ) throws IOException
	{
		//analyze file with new "list" upon finish
		Scanner file = null;
		try {
			file = new Scanner(new File("src\\lab18d\\lab18d.dat"));
			int size = file.nextInt();
			file.nextLine();
			Word[] list = new Word[size];
			for(int i = 0; i < size; i++) {
				list[i] = new Word(file.next());
			}
			
			//sort
			for(int i = 0; i < list.length; i++) {
				for(int j = 0; j < list.length-1; j++) {
					if(list[j].compareTo(list[j+1]) == -1) {
						Word t = list[j];
						list[j] = list[j+1];
						list[j+1] = t;
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