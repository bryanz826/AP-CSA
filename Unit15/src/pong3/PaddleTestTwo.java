package pong3;
//� A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong3

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Canvas;
//import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
//import java.awt.image.BufferedImage;

import pong3.Ball3;

//import java.awt.event.ActionListener;

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable
{
	private static final long serialVersionUID = 1L;
	private Ball3 ball;
	private Paddle3 leftPaddle;
	private Paddle3 rightPaddle;
	private boolean[] keys;		//keeps track of what keys are pressed

	public PaddleTestTwo()
	{
		//set up all game variables
		ball = new Ball3();
		leftPaddle = new Paddle3(10,250,10,50,4);
		rightPaddle = new Paddle3(760,250,10,50,4);
		keys = new boolean[4];

		//set up the Canvas
		setBackground(Color.WHITE);
		setVisible(true);

		this.addKeyListener(this);
		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);
		leftPaddle.draw(window);
		rightPaddle.draw(window);

		if(!(ball.getX()>=10 && ball.getX()<=760))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(!(ball.getY()>=10 && ball.getY()<=540))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		if(keys[0] == true)
		{
			leftPaddle.moveUpAndDraw(window);
		}
		if(keys[1] == true)
		{
			leftPaddle.moveDownAndDraw(window);

		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(window);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(window);
		}
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
		//no code needed here
	}
	
   public void run()
   {
   		try
   		{
   			while(true)
   			{
   				Thread.currentThread();
				Thread.sleep(8);
   				repaint();
   			}
   		} catch(Exception e) {
   			System.out.println("oops");
   		}
  	}		
}