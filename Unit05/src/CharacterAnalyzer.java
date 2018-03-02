//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/07
//Class - APCSA
//Lab  - 05d

//import static java.lang.System.*;
//import java.util.Scanner;

public class CharacterAnalyzer
{
	private char theChar;

	public CharacterAnalyzer()
	{
		setChar('a');
	}

	public CharacterAnalyzer(char c)
	{
		setChar(c);
	}

	public void setChar(char c)
	{
		theChar = c;
	}

	public char getChar()
	{
		return theChar;
	}

	public boolean isUpper( )
	{
		if((int)theChar>=65 && (int)theChar<=90) return true;
		return false;
	}

	public boolean isLower( )
	{
		if((int)theChar>=97 && (int)theChar<=122) return true;
		return false;
	}
	
	public boolean isNumber( )
	{
		if((int)theChar>=48 && (int)theChar<=57) return true;
		return false;
	}	

	public int getASCII( )
	{
		return (int)theChar;
	}

	public String toString()
	{
		String output = "";
		if(isUpper()) output=getChar() + " is an uppercase character. ASCII == " + getASCII() + "\n";
		else if(isLower()) output=getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";
		else if(isNumber()) output=getChar() + " is a number. ASCII == " + getASCII() + "\n";
		else output=getChar() + " is not a character or a number. ASCII == " + getASCII() + "\n";
		return output;
	}
}