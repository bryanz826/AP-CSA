package lab21i;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/18
//Class - APCSA
//Lab  - lab21i

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = null;
		try {
			file = new Scanner(new File("src\\lab21i\\lab21i.dat"));
			
			Maze test1 = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
			out.println(test1 + "\n");
			
			Maze test2 = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
			out.println(test2 + "\n");
			
			Maze test3 = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
			out.println(test3 + "\n");
			
			Maze test4 = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
			out.println(test4 + "\n");
			
			Maze test5 = new Maze(Integer.parseInt(file.nextLine()), file.nextLine());
			out.println(test5 + "\n");
		} catch(IOException e) {
			out.println(e);
		} finally {
			if(file != null) file.close();
		}
	}
}