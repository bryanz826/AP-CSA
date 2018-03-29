package the_pong_game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import the_pong_game.Ball;

class BlinkyBall extends Ball
{

   //constructors
   public BlinkyBall()
   {
		super();
   }

   public BlinkyBall(int x, int y)
   {



   }

   public BlinkyBall(int x, int y, int wid, int ht)
   {



   }

   public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {



   }

   public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
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