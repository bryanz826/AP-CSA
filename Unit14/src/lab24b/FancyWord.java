package lab24b;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/18
//Class - APCSA
//Lab  - lab24b

//import java.util.Scanner;
//import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;
	private String word;

	public FancyWord()
	{
		//wow! efficient!
		mat = new char[0][0];
		word = "";
	}

	public FancyWord(String s)
	{
		int size = s.length();
		mat = new char[size][size];
		word = s;
	}

	public String toString()
	{
		for(int i = 0; i < mat.length; i++) {
			mat[0][i] = word.charAt(i);
			mat[mat.length-1][i] = word.charAt(i);
			mat[i][i] = word.charAt(i);
			mat[mat.length-1-i][i] = word.charAt(i);
		}
		
		String output="";
		for(char[] row : mat) { for(char num : row) output+= num; output+= "\n"; }
		return output+"\n\n";
	}
}