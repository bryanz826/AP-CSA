package pong3;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong3

import java.awt.Color;
import java.awt.Graphics;

import pong3.Block3;

public class Ball3 extends Block3
{
	private int xSpeed;
	private int ySpeed;

	public Ball3()
	{
		super(200, 200);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball3(int x, int y)
	{
		super(x, y);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball3(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball3(int x, int y, int w, int h, Color col)
	{
		super(x, y, w, h, col);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball3(int x, int y, int w, int h, Color col, int xS, int yS)
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
		Ball3 other = (Ball3) obj;
		return super.equals(other) 
				&& this.getXSpeed() == other.getXSpeed()
				&& this.getYSpeed() == other.getYSpeed();
	}
	
	public String toString() {
		return super.toString() +" "+ getXSpeed() +" "+ getYSpeed();
	}
}