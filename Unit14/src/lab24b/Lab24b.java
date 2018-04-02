package lab24b;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/18
//Class - APCSA
//Lab  - lab24b

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24b
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = null;
		try {
			file = new Scanner(new File ("src\\lab24b\\lab24b.dat"));
			int size = file.nextInt();
			file.nextLine();
			for(int i = 0; i<size; i++)
			{
				String word = file.next();
				FancyWord test = new FancyWord(word);
				out.println(test);
			}
		} catch(IOException e) {
			out.println(e);
		} finally {
			if(file != null) file.close();
		}
	}
}