package lab16e;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/8
//Class - APCSA
//Lab  - 16e

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private char[] values;
	private String fileName;

	public Histogram()
	{
		count = new ArrayList<Integer>();
		letters = new ArrayList<Character>();
		fileName = "";
	}

	public Histogram(char[] v, String fName)
	{
		count = new ArrayList<Integer>();
		letters = new ArrayList<Character>();
		values = v;
		fileName = fName;
		out.println("search letters = "+Arrays.toString(values));
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		try {
			Scanner file = new Scanner(new File(fileName));
			file.nextLine();
			while(file.hasNext()){
				String s = file.next();
				for(int i = 0; i < s.length(); i++) {
					letters.add(s.charAt(i));
				}
			}
			file.close();
		}
		catch(Exception IOException) {
			out.println("Houston, we have a problem.");
		}
		for(int i = 0; i < values.length; i++) {
			int c = 0;
			for(int j = 0; j < letters.size(); j++) {
				if(values[i] == letters.get(j)) c+=1;
			}
			count.add(c);
		}
	}

	public char mostFrequent()
	{
		int max = count.get(0);
		for(int i = 1; i < count.size(); i++) {
			if(count.get(i) > max) max = count.get(i);
		}
		return values[count.indexOf(max)];
	}

	public char leastFrequent()
	{
		int min = count.get(0);
		for(int i = 1; i < count.size(); i++) {
			if(count.get(i) < min) min = count.get(i);
		}
		return values[count.indexOf(min)];
	}

	public String toString()
	{
	   return fileName
	   + "\n" + Arrays.toString(values)
	   + "\n" + count + "\n\n\n";
	}
}