package lab21g;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/18
//Class - APCSA
//Lab  - lab21g

import static java.lang.System.*;

public class Lab21g
{
	public static void main(String args[])
	{
		//instantiate an AtCounter
		AtCounter test = new AtCounter();
		
		//test the code
		test.countAts(0, 0);
		out.println(test);
		
		test.zeroAtCount();
		test.countAts(2, 5);
		out.println(test);
		
		test.zeroAtCount();
		test.countAts(5, 0);
		out.println(test);
		
		test.zeroAtCount();
		test.countAts(9, 9);
		out.println(test);
		
		test.zeroAtCount();
		test.countAts(3, 9);
		out.println(test);
	}
}