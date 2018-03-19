package lab09f;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/08
//Class - APCSA
//Lab  - 09f

//import static java.lang.System.*;

public class Lab09f
{
	public static void main( String args[] )
	{
		//add test cases
		LetterRemover lr = new LetterRemover("I am Sam I am", 'a');
		System.out.println(lr);
		System.out.println(lr.removeLetters()+"\n\n");
		
		lr.setRemover("ssssssssxssssesssssessss", 's');
		System.out.println(lr);
		System.out.println(lr.removeLetters()+"\n\n");
		
		lr.setRemover("qwertyqwertyqwerty", 'a');
		System.out.println(lr);
		System.out.println(lr.removeLetters()+"\n\n");
		
		lr.setRemover("abababababa", 'b');
		System.out.println(lr);
		System.out.println(lr.removeLetters()+"\n\n");
		
		lr.setRemover("abababababa", 'x');
		System.out.println(lr);
		System.out.println(lr.removeLetters()+"\n\n");
	}
}