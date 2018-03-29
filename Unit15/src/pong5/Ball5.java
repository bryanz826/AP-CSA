package pong5;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong4

import java.awt.Color;
import java.awt.Graphics;

import pong5.Block5;

public class Ball5 extends Block5 implements Collidable5
{
	private int xSpeed;
	private int ySpeed;

	public Ball5()
	{
		super(200, 200);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball5(int x, int y)
	{
		super(x, y);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball5(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball5(int x, int y, int w, int h, Color col)
	{
		super(x, y, w, h, col);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball5(int x, int y, int w, int h, Color col, int xS, int yS)
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
		setPos(getX()+getXSpeed(), getY()+getYSpeed());
		draw(window, temp);
	}

	public boolean equals(Object obj)
	{
		Ball5 other = (Ball5) obj;
		return super.equals(other)
				&& this.getXSpeed() == other.getXSpeed()
				&& this.getYSpeed() == other.getYSpeed();
	}

	//IMPLEMENTED FROM COLLIDABLE
	public boolean didCollideLeft(Object obj) {
		Wall5 other = (Wall5) obj;
		return this.getX() <= other.getLeft();
	}
	
	public boolean didCollideRight(Object obj) {
		Wall5 other = (Wall5) obj;
		return this.getX() >= other.getRight();
	}
	
	public boolean didCollideTop(Object obj) {
		Wall5 other = (Wall5) obj;
		return this.getY() <= other.getTop();
	}

	public boolean didCollideBottom(Object obj) {
		Wall5 other = (Wall5) obj;
		return this.getY()+9 /*because the bottom wall is screwed up*/ >= other.getBottom();
	}
	
	public String toString() {
		return super.toString() +" "+ getXSpeed() +" "+ getYSpeed();
	}
}