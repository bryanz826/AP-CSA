package com.entity;

import java.awt.Graphics2D;

import com.manager.Bounds;

public abstract class Entity extends Object implements Locatable
{
	private double	x;
	private double	y;
	private double	width;
	private double	height;

	public Entity() {
		this(10, 10, 10, 10);
	}
	
	public Entity(double x, double y) {
		this(x, y, 10, 10);
	}
	
	public Entity(double x, double y, double width, double height) {
		setPos(x - width / 2, y - height / 2);
		setDims(width, height);
	}
	
	public abstract void update();

	public abstract void render(Graphics2D g);
	
	public abstract String getName();

	@Override
	public void setPos(double x, double y) {
		setX(x);
		setY(y);
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public void setDims(double w, double h) {
		setWidth(w);
		setHeight(h);
	}

	@Override
	public void setWidth(double w) {
		width = w;
	}

	@Override
	public void setHeight(double h) {
		height = h;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}
	
	@Override
	public Bounds getBounds() {
		return new Bounds(getX(), getY(), getWidth());
	}

	@Override
	public String toString() {
		return "(" + (int) getX() + ", " + (int) getY() + ")\nwidth=" + getWidth() + ", height=" + getHeight();
	}
}
