package pong5;

import java.awt.Color;
//import java.awt.Graphics;
//import java.util.Random;

import pong5.Ball5;

public class SpeedUpBall5 extends Ball5 implements Collidable5
{
	private int xSpeed;
	private int ySpeed;

	public SpeedUpBall5()
	{
	    super();
	}

	public SpeedUpBall5(int x, int y)
	{
		super(x, y);
	}

	public SpeedUpBall5(int x, int y, int xSpd, int ySpd)
   	{
		super(x, y);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
   	}

	public SpeedUpBall5(int x, int y, int wid, int ht, int xSpd, int ySpd)
	{
		super(x, y, wid, ht);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
	}

	public SpeedUpBall5(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   	{
		super(x, y, wid, ht, col, xSpd, ySpd);
   	}
	
	//SET METHODS
	public void setXSpeed(int xSpd) {
		xSpeed = xSpd;
	}
	
	public void setYSpeed(int ySpd) {
		ySpeed = ySpd;
	}
	
	//GET METHODS
	public int getXSpeed() {
		return xSpeed;
	}
	
	public int getYSpeed() {
		return ySpeed;
	}
	
	//METHODs
	public void incSpeed()
	{
		xSpeed++;
		ySpeed++;
	}
}