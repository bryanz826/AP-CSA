package lab08i;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/08
//Class - APCSA
//Lab  - 08i

//import static java.lang.System.*;
//import java.lang.Math;

public class Lab08i
{
	public static void main ( String[] args )
	{
		//add test cases
		Prime p = new Prime(24);
		System.out.println(p);
		
		p.setPrime(7);
		System.out.println(p);

		p.setPrime(100);
		System.out.println(p);

		p.setPrime(113);
		System.out.println(p);

		p.setPrime(65535);
		System.out.println(p);

		p.setPrime(2);
		System.out.println(p);

		p.setPrime(7334);
		System.out.println(p);

		p.setPrime(7919);
		System.out.println(p);

		p.setPrime(1115125003);
		System.out.println(p);
	}	
}