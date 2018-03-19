package lab08g;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/08
//Class - APCSA
//Lab  - 08g

//import static java.lang.System.*;

public class Lab08g
{
	public static void main ( String[] args )
	{
		//add test cases
		LoopStats c = new LoopStats(1, 5);
		System.out.println(c);
		System.out.println("total "+c.getTotal());
		System.out.println("even count "+c.getEvenCount());
		System.out.println("odd count "+c.getOddCount());
		System.out.println("\n");
		
		c.setNums(2, 8);
		System.out.println(c);
		System.out.println("total "+c.getTotal());
		System.out.println("even count "+c.getEvenCount());
		System.out.println("odd count "+c.getOddCount());
		System.out.println("\n");

		c.setNums(5, 15);
		System.out.println(c);
		System.out.println("total "+c.getTotal());
		System.out.println("even count "+c.getEvenCount());
		System.out.println("odd count "+c.getOddCount());
		System.out.println("\n");
	}
}