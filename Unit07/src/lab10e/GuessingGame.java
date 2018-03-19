package lab10e;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/09
//Class - APCSA
//Lab  - 10e

import java.util.Scanner;
//import static java.lang.System.*;

public class GuessingGame
{
	private int upperBound;
	private int totalGuesses;

	public GuessingGame(int stop)
	{
		upperBound = stop;
	}

	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		
		int num = (int) (Math.random() * upperBound + 1);
		int guess = 0;
		
		do {
			System.out.print("Enter a number between 1 and "+upperBound+": ");
			guess = keyboard.nextInt();
			if(guess < 1 || guess > upperBound) {
				System.out.println("Number out of range!");
				totalGuesses -= 1;
			} 
			totalGuesses += 1;
		} while(num != guess);
		
		if(totalGuesses == 1) System.out.println("It took you "+totalGuesses+" guess to guess "+num);
		else System.out.println("\nIt took you "+totalGuesses+" guesses to guess "+num);
		String wrongCount = String.format("%.0f", ((double) (totalGuesses-1)/upperBound * 100));
		System.out.println("You guessed wrong "+ wrongCount +" percent of the time\n\n");
		
		System.out.print("Do you want to play again? ");
		String response = keyboard.next();
		if((response == "y") || (response == "yes")) {
			System.out.println("hi");
			playGame();
		}
		keyboard.close();

	}

	public String toString()
	{
		String output="";
		output+=upperBound;
		return output;
	}
}