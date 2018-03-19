package lab21g;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/18
//Class - APCSA
//Lab  - lab21g

//import static java.lang.System.*;
//import java.util.Arrays;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;

	public AtCounter()
	{
		atCount=0;
		atMat = new char[][]{{'@','-','@','-','-','@','-','@','@','@'},
							 {'@','@','@','-','@','@','-','@','-','@'},
							 {'-','-','-','-','-','-','-','@','@','@'},
							 {'-','@','@','@','@','@','-','@','-','@'},
							 {'-','@','-','@','-','@','-','@','-','@'},
							 {'@','@','@','@','@','@','-','@','@','@'},
							 {'-','@','-','@','-','@','-','-','-','@'},
							 {'-','@','@','@','-','@','-','-','-','-'},
							 {'-','@','-','@','-','@','-','@','@','@'},
							 {'-','@','@','@','@','@','-','@','@','@'}};
	}
	public void zeroAtCount() { atCount = 0; }
	public int countAts(int r, int c)
	{
		//add in recursive code to count up the # of @s connected
		//start checking at spot [r,c]
		if(r >= 0 && r < atMat.length && c >= 0 && c < atMat[r].length && atMat[r][c] == '@') {
			atMat[r][c] = 'X';
			atCount++;
			countAts(r-1,c);
			countAts(r,c+1);
			countAts(r+1,c);
			countAts(r,c-1);
		}
		//hehe :)
		return Integer.MAX_VALUE;
	}

	public int getAtCount()
	{
		return atCount;
	}
	
	public String toString()
	{
		String output="";
		output+=getAtCount()+" @s connected.";
		return output;
	}
}