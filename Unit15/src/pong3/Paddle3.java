package pong3;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong3

import java.awt.Color;
import java.awt.Graphics;

import pong3.Block3;

public class Paddle3 extends Block3
{
	private int speed;

	public Paddle3()
	{
		super(10,10);
		setSpeed(5);
	}

	public Paddle3(int x, int y) {
		super(x, y);
		setSpeed(5);
	}
	
	public Paddle3(int x, int y, int s) {
		super(x, y);
		setSpeed(s);
	}
	
	public Paddle3(int x, int y, int w, int h, int s) {
		super(x, y, w, h);
		setSpeed(s);
	}
	
	public Paddle3(int x, int y, int w, int h, Color col, int s) {
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

	public void moveUpAndDraw(Graphics window)
	{
		System.out.println("hssi");
		Color temp = getColor();
		draw(window, Color.WHITE);
		setY(getY()-speed);
		draw(window, temp);
	}

	public void moveDownAndDraw(Graphics window)
	{
		Color temp = getColor();
		draw(window, Color.WHITE);
		setY(getY()+speed);
		draw(window, temp);
	}
	
	public boolean equals(Object obj)
	{
   		Paddle3 other = (Paddle3) obj;
   		return super.equals(other) 
				&& this.getSpeed() == other.getSpeed();	
	}
   
	public String toString() {
		return super.toString() +" "+ getSpeed();
	}
}