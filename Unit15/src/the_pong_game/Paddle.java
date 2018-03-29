package the_pong_game;

import java.awt.Color;
import java.awt.Graphics;

import the_pong_game.Block;

public class Paddle extends Block
{
	private int speed;
	private int cSpeed;

	public Paddle()
	{
		super(10,10);
		setSpeed(5);
	}

	public Paddle(int x, int y) {
		super(x, y);
		setSpeed(5);
	}
	
	public Paddle(int x, int y, int s) {
		super(x, y);
		setSpeed(s);
	}
	
	public Paddle(int x, int y, int w, int h, int s) {
		super(x, y, w, h);
		setSpeed(s);
	}
	
	public Paddle(int x, int y, int w, int h, Color col, int s) {
		super(x, y, w, h, col);
		setSpeed(s);
	}


	//SET METHODS
	public void setSpeed(int s) {
		speed = s;
	}
	
	public void setcSpeed(int s) {
		cSpeed = s;
	}
	
	//GET METHODS
	public int getSpeed() {
		return speed;
	}
	
	public int getcSpeed() {
		return cSpeed;
	}

	//DRAWING
	public void moveUpAndDraw(Graphics window)
	{
		setcSpeed(-Math.abs(getSpeed()));		
		Color temp = getColor();
		draw(window, Color.WHITE);
		setY(getY()+cSpeed);
		draw(window, temp);
	}
	
	public void moveNothing(Graphics window)
	{
		setcSpeed(0);
	}
	
	public void moveDownAndDraw(Graphics window)
	{
		setcSpeed(Math.abs(getSpeed()));
		Color temp = getColor();
		draw(window, Color.WHITE);
		setY(getY()+cSpeed);
		draw(window, temp);
	}
	
	public boolean equals(Object obj)
	{
   		Paddle other = (Paddle) obj;
   		return super.equals(other) 
				&& this.getSpeed() == other.getSpeed();	
	}

	public boolean didCollideTop(Object obj) {
		Wall other = (Wall) obj;
		return this.getY() <= other.getTop();
	}

	public boolean didCollideBottom(Object obj) {
		Wall other = (Wall) obj;
		return this.getY()+this.getHeight() >= other.getBottom();
	}
	   
	public String toString() {
		return super.toString() +" "+ getSpeed();
	}
}