package lab15d;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/16
//Class - APCSA 
//Lab  - 15d

//import java.util.Arrays;
import java.util.Scanner;
//import java.util.Collections;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class Lab15d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("D:\\Program Files\\csa\\readUnits (this is just for my reference)\\Unit13\\Unit13-2016\\Unit13-Assignments\\lab15d.dat"));
		int size = file.nextInt();
		FancyWords[] test = new FancyWords[size];
		file.nextLine();
		for(int i = 0; i < size; i++) {
			test[i] = new FancyWords(file.nextLine());
		}
		file.close();
		for(FancyWords f : test) out.println(f);
	}
}