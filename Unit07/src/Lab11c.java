//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/09
//Class - APCSA
//Lab  - 11c

import static java.lang.System.*;

public class Lab11c
{
	public static void main( String args[] )
	{
		TriangleThree tt = new TriangleThree(3,"A");
		System.out.println(tt);

		tt.setTriangle(7,"X");
		System.out.println(tt);

		tt.setTriangle(1,"R");
		System.out.println(tt);

		tt.setTriangle(5,"T");
		System.out.println(tt);

		tt.setTriangle(4,"W");
		System.out.println(tt);
	}
}