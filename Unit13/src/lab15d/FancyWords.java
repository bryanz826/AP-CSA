package lab15d;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/16
//Class - APCSA 
//Lab  - 15d

//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.Collections;
//import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		setWords(sentence);
	}

	public void setWords(String sentence)
	{
		wordRay = sentence.split(" ");
	}

	public String toString()
	{
		String output="";
		int max = Integer.MIN_VALUE;
		for(String word : wordRay)
			if(word.length() > max) max = word.length();
		
		//make all strings same length
		for(int i = 0; i < wordRay.length; i++) {
			for(int j = wordRay[i].length(); j < max; j++)
				wordRay[i] = " "+wordRay[i];
		}
		
		//build FancyWord
		for(int i = max-1; i >= 0; i--) {
			for(int j = wordRay.length-1; j >= 0; j--)
				output+=wordRay[j].charAt(i);
			output+="\n";
		}
		
		return output+"\n";
	}
}