package pong2;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong2

import java.awt.Color;
import java.awt.Graphics;

import pong2.Block2;

public class Ball2 extends Block2
{
	private int xSpeed;
	private int ySpeed;

	public Ball2()
	{
		super(200, 200);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball2(int x, int y)
	{
		super(x, y);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball2(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball2(int x, int y, int w, int h, Color col)
	{
		super(x, y, w, h, col);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball2(int x, int y, int w, int h, Color col, int xS, int yS)
	{
		super(x, y, w, h, col);
		setXSpeed(xS);
		setYSpeed(yS);
	}
	
	//SET METHODS
	public void setXSpeed(int xS) {
		xSpeed = xS;
	}
	
	public void setYSpeed(int yS) {
		ySpeed = yS;
	}
	
	//GET METHODS
	public int getXSpeed() {
		return xSpeed;
	}
	
	public int getYSpeed() {
		return ySpeed;
	}

	//OTHER METHODS
	public void moveAndDraw(Graphics window)
	{
		Color temp = getColor();
		draw(window, Color.WHITE);
		setPos(getX()+xSpeed, getY()+ySpeed);
		draw(window, temp);
	}

	public boolean equals(Object obj)
	{
		Ball2 other = (Ball2) obj;
		return super.equals(other) 
				&& this.getXSpeed() == other.getXSpeed()
				&& this.getYSpeed() == other.getYSpeed();
	}
	
	public String toString() {
		return super.toString() +" "+ getXSpeed() +" "+ getYSpeed();
	}
}