
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Graphics;

public abstract class MovingThing implements Moveable {
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	public MovingThing() {
		this(10, 10, 10, 10);
	}

	public MovingThing(int x, int y) {
		this(x, y, 10, 10);
	}

	public MovingThing(int x, int y, int w, int h) {
		setPos(x - w / 2, y - w / 2);
		setWidth(w);
		setHeight(h);
	}

	public boolean isCollidingMT(MovingThing mt) {
		// check collision at central left, right, top, and bottom
		if (partialCollision(this.getX(), this.getY() + this.getHeight() / 2, mt))
			return true;
		else if (partialCollision(this.getX() + this.getWidth(), this.getY() + this.getHeight() / 2, mt))
			return true;
		else if (partialCollision(this.getX() + this.getWidth() / 2, this.getY(), mt))
			return true;
		else if (partialCollision(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight(), mt))
			return true;
		return false;
	}

	private boolean partialCollision(int pointX, int pointY, MovingThing mt) {
		return pointX > mt.getX() && pointX < mt.getX() + mt.getWidth() && pointY > mt.getY()
				&& pointY < mt.getY() + mt.getHeight();
	}

	public void setPos(int x, int y) {
		setX(x);
		setY(y);
	}

	public void setX(int x) {
		xPos = x;
	}

	public void setY(int y) {
		yPos = y;
	}

	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}

	public void setWidth(int w) {
		width = w;
	}

	public void setHeight(int h) {
		height = h;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public abstract void move(String direction);

	public abstract void draw(Graphics window);

	public String toString() {
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
	}
}