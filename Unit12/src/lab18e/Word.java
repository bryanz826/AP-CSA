package lab18e;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/16
//Class - APCSA
//Lab  - 18e

//import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;
	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for(int i = 0; i < word.length(); i++) {
			for(int j = 0; j < vowels.length(); j++) {
				if(word.charAt(i) == vowels.charAt(j)) vowelCount++;
			}
		}
		return vowelCount;
	}

	public int compareTo(Word rhs)
	{
		Word other = (Word)rhs;
		if(numVowels() < other.numVowels()) return -1;
		if(numVowels() > other.numVowels()) return 1;
		for (int i = 0; i < word.length(); i++){
			if ((int)word.charAt(i) < (int)other.toString().charAt(i)){
				return -1;
			}
			else if ((int)word.charAt(i) > (int)other.toString().charAt(i)){
				return 1;
			}
		}
		return 0;
	}

	public String toString()
	{
		return word;
	}
}