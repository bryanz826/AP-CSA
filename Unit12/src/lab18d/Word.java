package lab18d;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/15
//Class - APCSA
//Lab  - 18d

//import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}
	
	public int compareTo( Word rhs )
	{
		Word other = (Word)rhs;
		if(word.length() < other.toString().length()) return 1;
		if(word.length() > other.toString().length()) return -1;
		for (int i = 0; i < word.length(); i++){
			if ((int)word.charAt(i) < (int)other.toString().charAt(i)){
				return 1;
			}
			else if ((int)word.charAt(i) > (int)other.toString().charAt(i)){
				return -1;
			}
		}
		return 0;
	}

	public String toString()
	{
		return word;
	}
}