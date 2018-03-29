package pong1;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong1

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

public class BlockTestTwo extends Canvas
{
	private static final long serialVersionUID = 1L;

	public BlockTestTwo()
	{
		setBackground(Color.WHITE);
		
	}

	public void paint(Graphics window)
	{
		Block1 one = new Block1();
		one.draw(window);

		Block1 two = new Block1(50,50,30,30);
		two.draw(window);

		Block1 three = new Block1(350,350,15,15,Color.RED);
		three.draw(window);

		two.draw(window, Color.black);

		Block1 four = new Block1(450,50,20,60, Color.GREEN);
		four.draw(window);
		
		//add more test cases			
	}
}