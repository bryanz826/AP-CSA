package lab24d;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/18
//Class - APCSA
//Lab  - lab24d

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner (new File("D:\\Program Files\\csa\\readUnits (this is just for my reference)\\Unit14\\Unit14_2016\\Unit14-Assignments\\lab24d.dat"));
		int size = file.nextInt();
		file.nextLine();
		for(int i = 0; i < size; i++) {
			TicTacToe test = new TicTacToe(file.next());
			out.println(test);
		}
		file.close();
	}
}



