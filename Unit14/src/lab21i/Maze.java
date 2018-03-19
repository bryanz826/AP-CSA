package lab21i;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/18
//Class - APCSA
//Lab  - lab21i

//import java.io.File;
//import java.io.IOException;
import java.util.Scanner;
//import static java.lang.System.*;

public class Maze
{
    private int[][] maze;
    private boolean exitFound = false;

	public Maze()
	{
		//do nothing?
		maze = new int[0][0];
	}

	public Maze(int size, String line)
	{
		maze = new int[size][size];
		Scanner scan = new Scanner(line);
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				maze[i][j] = scan.nextInt();
		scan.close();
	}

	public void hasExitPath(int r, int c)
	{
		if(r >= 0 && r < maze.length && c >= 0 && c < maze[r].length && maze[r][c] == 1) {
			maze[r][c] = 8;
//DEBUGGING for(int[] row : maze) { for(int num : row) System.out.print(num + " "); System.out.println(); } System.out.println();
			if(c == maze[r].length-1) {
				exitFound = true;
				return;
			}
			else {
				hasExitPath(r-1,c);
				hasExitPath(r,c+1);
				hasExitPath(r+1,c);
				hasExitPath(r,c-1);
			}
		}
	}

	public String toString()
	{
		String output="";
		for(int[] row : maze) { for(int num : row) output+= num + " "; output+= "\n"; }
		hasExitPath(0, 0);
		output+= "exit ";
		if(!exitFound) output+= "not ";
		output+= "found";
		
		return output;
	}
}