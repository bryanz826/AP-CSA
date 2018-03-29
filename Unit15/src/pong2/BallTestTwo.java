package pong2;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong2

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;

import java.awt.Canvas;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable
{
	
	private static final long serialVersionUID = 1L;
	private Ball2 ball;
	public BallTestTwo()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		ball = new Ball2();
		
		ball = new Ball2(100,90);
		
		ball = new Ball2(100,100,30,50);
		
		ball = new Ball2(100,100,30,50,Color.BLUE);
		
		ball = new Ball2(100,100,30,50,Color.BLUE,5,6);
		
		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);

		if(!(ball.getX() >= 10 && ball.getX() <= 550))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(!(ball.getY() >= 10 && ball.getY() <= 450))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
	}
	
	public void run()
	{
		try {
			while(true) {
				Thread.currentThread();
				Thread.sleep(19);
				repaint();
			}
		} catch(Exception e) {
			System.out.println("oops");
		}
  	}	
}