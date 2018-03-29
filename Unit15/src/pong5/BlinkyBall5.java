package pong5;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

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



   }

   public BlinkyBall5(int x, int y, int wid, int ht)
   {



   }

   public BlinkyBall5(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {



   }

   public BlinkyBall5(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {




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
	   
   }
}