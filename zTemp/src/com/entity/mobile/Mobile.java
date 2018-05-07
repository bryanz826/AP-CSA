package com.entity.mobile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.entity.Entity;
import com.manager.Bounds;

import coc.utils.Resource;

public abstract class Mobile extends Entity implements Moveable
{
	private Resource	image;

	private double		dx;
	private double		dy;

	public Mobile(double x, double y, double dx, double dy)
	{
		this(x, y, 10, 10, dx, dy);
	}

	public Mobile(double x, double y, double width, double height, double dx, double dy)
	{
		super(x, y, width, height);
		setSpeed(dx, dy);
	}

	@Override
	public void update() {
		setX(getX() + getDx());
		setY(getY() + getDy());
	}

	@Override
	public void render(Graphics2D g) {
		image.render(g, getX(), (int) getY(), (int) getWidth(), (int) getHeight());
	}

	@Override
	public void ddx(double ddx) {
		setDx(getDx() + ddx);
	}

	@Override
	public void ddy(double ddy) {
		setDy(getDy() + ddy);
	}

	public void setImage(String fileName) {
		this.image = new Resource(fileName);
	}

	public void setImage(Resource image) {
		this.image = image;
	}

	@Override
	public void setSpeed(double dx, double dy) {
		setDx(dx);
		setDy(dy);
	}

	@Override
	public void setDx(double dx) {
		this.dx = dx;
	}

	@Override
	public void setDy(double dy) {
		this.dy = dy;
	}

	public BufferedImage getImage() {
		return image.getImage();
	}

	@Override
	public double getDx() {
		return dx;
	}

	@Override
	public double getDy() {
		return dy;
	}

	@Override
	public Bounds getBounds() {
		return new Bounds(getX(), getY(), getWidth());
	}

	@Override
	public String toString() {
		return super.toString() + ", dx=" + getDx() + ", dy=" + getDy();
	}
}
