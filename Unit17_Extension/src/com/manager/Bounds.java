package com.manager;

import java.awt.Color;
import java.awt.Graphics2D;

import com.main.OuterSpace;

/**
 * THIS COLLISION DETECTOR UTILIZES CIRCLES
 **/

public class Bounds
{
	private double	x;
	private double	y;
	private double	radius;

	public Bounds(double x, double y, double size)
	{
		this.x = x;
		this.y = y;
		this.radius = size / 2;
	}

	public boolean collides(Bounds c) {
		double xDis = this.getX() + this.getRadius() - c.getX() - c.getRadius();
		double yDis = this.getY() + this.getRadius() - c.getY() - c.getRadius();
		double radDis = this.getRadius() + c.getRadius();
		return xDis * xDis + yDis * yDis <= radDis * radDis;
	}

	public void DEBUG(Graphics2D g) {
		if (OuterSpace.DEBUGGING) {
			g.setColor(new Color(0, 255, 99, 128));
			g.fillOval((int) x, (int) y, (int) radius * 2, (int) radius * 2);
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}
}
