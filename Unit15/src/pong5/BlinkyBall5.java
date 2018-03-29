package pong5;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
//import java.util.Random;

import pong5.Ball5;

public class BlinkyBall5 extends Ball5
{

   //constructors
   public BlinkyBall5()
   {
		super();
   }

   public BlinkyBall5(int x, int y)
   {
	    super(x, y);
   }

   public BlinkyBall5(int x, int y, int wid, int ht)
   {
	   	super(x, y, wid, ht);
   }

   public BlinkyBall5(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	    super(x, y, wid, ht);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
   }

   public BlinkyBall5(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x, y, wid, ht, col, xSpd, ySpd);
   }

   public Color randomColor()
   {
   		int r = (int) (Math.random() * 255);
 		int g = (int) (Math.random() * 255);
 		int b = (int) (Math.random() * 255);
 		return new Color(r,g,b);
   }

   public void moveAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setPos(getX()+getXSpeed(), getY()+getYSpeed());
	   draw(window, randomColor());
   }
}