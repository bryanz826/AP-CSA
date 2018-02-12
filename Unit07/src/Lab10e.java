//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/09
//Class - APCSA
//Lab  - 10e

import java.util.Scanner;
import static java.lang.System.*;

public class Lab10e
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		char response = 'a';

		do {
			System.out.print("Guessing Game - how many numbers? ");
			int input = keyboard.nextInt();
			GuessingGame g = new GuessingGame(input);
			
			g.playGame();
		} while(response == 'y');



	}
}