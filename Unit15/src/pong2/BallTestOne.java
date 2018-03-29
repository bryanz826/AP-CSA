package pong2;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong2

import static java.lang.System.*;
import java.awt.Color;

class BallTestOne
{
	public static void main( String args[] )
	{
		Ball2 one = new Ball2();
		out.println(one);
		
		Ball2 two = new Ball2(100,90);
		out.println(two);
		
		Ball2 three = new Ball2(100,100,30,50);
		out.println(three);
		
		Ball2 four = new Ball2(100,100,30,50,Color.BLUE);
		out.println(four);
		
		Ball2 five = new Ball2(100,100,30,50,Color.BLUE,5,6);
		out.println(five);
		
		Ball2 six = new Ball2(100,100,30,50,Color.blue,5,6);
		out.println(six);		
		
		out.println(five.equals(four));		
		
		out.println(five.equals(five));										
	}
}