package com.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import com.main.GamePanel;

/**
 * This class utilizes circles for collision detection.
 * 
 * @author bryan
 *
 */
public class Bounds
{
	private float	x;
	private float	y;
	private float	radius;

	public Bounds(float x, float y, float size)
	{
		this.x = x;
		this.y = y;
		this.radius = size / 2;
	}

	public boolean collides(Bounds c) {
		float xDis = this.getX() + this.getRadius() - c.getX() - c.getRadius();
		float yDis = this.getY() + this.getRadius() - c.getY() - c.getRadius();
		float radDis = this.getRadius() + c.getRadius();
		return xDis * xDis + yDis * yDis <= radDis * radDis;
	}

	public void DEBUG(Graphics2D g) {
		if (GamePanel.DEBUGGING) {
			g.setColor(new Color(0, 255, 99, 128));
			g.fillOval((int) x, (int) y, (int) radius * 2, (int) radius * 2);
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getRadius() {
		return radius;
	}
}
