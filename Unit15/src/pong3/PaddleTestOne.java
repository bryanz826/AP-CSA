package pong3;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong3

import static java.lang.System.*;
import java.awt.Color;

class Paddle3TestOne
{
	public static void main( String args[] )
	{
		Paddle3 one = new Paddle3();
		out.println(one);
		
		Paddle3 two = new Paddle3(100,90);
		out.println(two);
		
		Paddle3 three = new Paddle3(100,100,30);
		out.println(three);
		
		Paddle3 four = new Paddle3(100,100,30,50,8);
		out.println(four);
		
		Paddle3 five = new Paddle3(100,100,30,20, Color.GREEN,6);
		out.println(five);
		
		
		out.println(five.equals(four));		
		
		out.println(five.equals(five));										
	}
}