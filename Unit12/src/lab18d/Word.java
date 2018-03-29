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
	
	public int compareTo( Word other )
	{
		if(this.word.length() < other.word.length()) return 1;
		if(this.word.length() > other.word.length()) return -1;
		for (int i = 0; i < word.length(); i++){
			if ((int)this.word.charAt(i) < (int)other.word.charAt(i)){
				return 1;
			}
			else if ((int)this.word.charAt(i) > (int)other.word.charAt(i)){
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