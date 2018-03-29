package pong1;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.awt.Color;

class Block1TestOne
{
	public static void main( String args[] )
	{
		Block1 one = new Block1();
		out.println(one);

		Block1 two = new Block1(50,50,30,30);
		out.println(two);

		Block1 three = new Block1(350,350,15,15,Color.RED);
		out.println(three);

		Block1 four = new Block1(450,50,20,60, Color.GREEN);
		out.println(four);
		
		out.println(one.equals(two));
		out.println(one.equals(one));		
	}
}