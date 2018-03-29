package pong4;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong4

import java.awt.Color;
import java.awt.Graphics;

import pong4.Block4;

public class Paddle4 extends Block4
{
	private int speed;
	
	public Paddle4()
	{
		super(10,10);
		setSpeed(5);
	}

	public Paddle4(int x, int y) {
		super(x, y);
		setSpeed(5);
	}
	
	public Paddle4(int x, int y, int s) {
		super(x, y);
		setSpeed(s);
	}
	
	public Paddle4(int x, int y, int w, int h, int s) {
		super(x, y, w, h);
		setSpeed(s);
	}
	
	public Paddle4(int x, int y, int w, int h, Color col, int s) {
		super(x, y, w, h, col);
		setSpeed(s);
	}


	//SET METHODS
	public void setSpeed(int s) {
		speed = s;
	}
	
	//GET METHODS
	public int getSpeed() {
		return speed;
	}

	//DRAWING
	public void moveUpAndDraw(Graphics window)
	{		
		Color temp = getColor();
		draw(window, Color.WHITE);
		setY(getY()-getSpeed());
		draw(window, temp);
	}
	
	public void moveDownAndDraw(Graphics window)
	{
		Color temp = getColor();
		draw(window, Color.WHITE);
		setY(getY()+getSpeed());
		draw(window, temp);
	}
	
	public boolean equals(Object obj)
	{
   		Paddle4 other = (Paddle4) obj;
   		return super.equals(other) 
				&& this.getSpeed() == other.getSpeed();	
	}
   
	public String toString() {
		return super.toString() +" "+ getSpeed();
	}
}