package pong4;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong4

import java.awt.Color;
import java.awt.Graphics;

import pong4.Block4;

public class Ball4 extends Block4 implements Collidable4
{
	private int xSpeed;
	private int ySpeed;

	public Ball4()
	{
		super(200, 200);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball4(int x, int y)
	{
		super(x, y);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball4(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball4(int x, int y, int w, int h, Color col)
	{
		super(x, y, w, h, col);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball4(int x, int y, int w, int h, Color col, int xS, int yS)
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
		Ball4 other = (Ball4) obj;
		return super.equals(other) 
				&& this.getXSpeed() == other.getXSpeed()
				&& this.getYSpeed() == other.getYSpeed();
	}

	//IMPLEMENTED FROM COLLIDABLE
	public boolean didCollideLeft(Object obj) {
		Wall4 other = (Wall4) obj;
		return this.getX() <= other.getLeft();
	}
	
	public boolean didCollideRight(Object obj) {
		Wall4 other = (Wall4) obj;
		return this.getX() >= other.getRight();
	}
	
	public boolean didCollideTop(Object obj) {
		Wall4 other = (Wall4) obj;
		return this.getY() <= other.getTop();
	}

	public boolean didCollideBottom(Object obj) {
		Wall4 other = (Wall4) obj;
		return this.getY()+9 /*because the bottom wall is screwed up*/ >= other.getBottom();
	}
	
	public String toString() {
		return super.toString() +" "+ getXSpeed() +" "+ getYSpeed();
	}
}