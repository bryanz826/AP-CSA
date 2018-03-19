package lab24d;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/18
//Class - APCSA
//Lab  - lab24d

//import java.util.Scanner;
//import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		//ok ill try again
		mat = new char[3][3];
	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		
		int c = 0;
		for(int i = 0; i < mat.length; i++)
			for(int j = 0; j < mat[i].length; j++)
				mat[i][j] = game.charAt(c++);
	}

	public String getWinner()
	{
		int diagonalSum1 = 0;
		int diagonalSum2 = 0;
		for(int i = 0; i < mat.length; i++) {
			//check horizontal
			if(mat[i][0] + mat[i][1] + mat[i][2] == 264) return "X wins horizontally!";
			if(mat[i][0] + mat[i][1] + mat[i][2] == 237) return "O wins horizontally!";
			
			//check vertical
			if(mat[0][i] + mat[1][i] + mat[2][i] == 264) return "X wins vertically!";
			if(mat[0][i] + mat[1][i] + mat[2][i] == 237) return "O wins vertically!";
			
			//check diagonally
			diagonalSum1+=mat[i][i];
			if(diagonalSum1 == 264) return "X wins diagonally!";
			if(diagonalSum1 == 237) return "O wins diagonally!";

			diagonalSum2+=mat[i][mat.length-1-i];
			if(diagonalSum2 == 264) return "X wins diagonally!";
			if(diagonalSum2 == 237) return "O wins diagonally!";
		}
		//fail
		return "cat's game - no winner!";
	}

	public String toString()
	{
		String output="";
		for(char[] row : mat) { for(char num : row) output+= num + " "; output+= "\n"; }
		output+=getWinner();
		return output+"\n\n";
	}
}