package com.entities;

import java.awt.Graphics2D;

import com.utils.Loopable;
import com.utils.Reference;
import com.utils.Resource;

public class Entity implements Loopable
{
	private double		x;
	private double		y;
	private double		width;
	private double		height;
	private double		dx;
	private double		dy;
	private double		terminalDx;
	private double		terminalDy;
	private double		d2x;
	private double		d2y;

	private Resource	image;

	public Entity()
	{
		this(Reference.CENTER_X, Reference.CENTER_Y, 25, 25, "");
	}

	public Entity(double x, double y, double width, double height, String fileName)
	{
		this(x, y, width, height, 5, 5, fileName);
	}

	public Entity(double x, double y, double width, double height, double terminalDx, double terminalDy,
			String fileName)
	{
		this(x, y, width, height, terminalDx, terminalDy, 0, 0, fileName);
	}

	public Entity(double x, double y, double width, double height, double terminalDx, double terminalDy, double d2x,
			double d2y, String fileName)
	{
		setPosition(x, y);
		setDimensions(width, height);
		setTerminalVelocities(terminalDx, terminalDy);
		setAccelerations(d2x, d2y);
		setImage(fileName);
	}

	public void accelPosX() {
		setDx(getDx() + getD2x());
		if (getDx() >= getTerminalDx()) setDx(getTerminalDx());
	}

	public void decelPosX() {
		if (getDx() > 0) {
			setDx(getDx() - getD2x());
			if (getDx() <= 0) setDx(0);
		}
	}

	public void accelNegX() {
		setDx(getDx() - getD2x());
		if (getDx() <= -getTerminalDx()) setDx(-getTerminalDx());
	}
	
	public void decelNegX() {
		if (getDx() < 0) {
			setDx(getDx() + getD2x());
			if (getDx() >= 0) setDx(0);
		}
	}

	public void accelPosY() {
		setDy(getDy() + getD2y());
		if (getDy() >= getTerminalDy()) setDy(getTerminalDy());
	}

	public void decelPosY() {
		if (getDy() > 0) {
			setDy(getDy() - getD2y());
			if (getDy() <= 0) setDy(0);
		}
	}

	public void accelNegY() {
		setDy(getDy() - getD2y());
		if (getDy() <= -getTerminalDy()) setDy(-getTerminalDy());
	}
	
	public void decelNegY() {
		if (getDy() < 0) {
			setDy(getDy() + getD2y());
			if (getDy() >= 0) setDy(0);
		}
	}

	@Override
	public void update() {
		setX(getX() + getDx());
		setY(getY() + getDy());
	}

	@Override
	public void render(Graphics2D g) {
		image.render(g, getX(), (int) getY(), (int) getWidth(), (int) getHeight());
		getBounds().DEBUG(g);
	}

	public void setPosition(double x, double y) {
		setX(x);
		setY(y);
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setDimensions(double width, double height) {
		setWidth(width);
		setHeight(height);
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public void setTerminalVelocities(double terminalDx, double terminalDy) {
		setTerminalDx(terminalDx);
		setTerminalDy(terminalDy);
	}

	public void setTerminalDx(double terminalDx) {
		this.terminalDx = terminalDx;
	}

	public void setTerminalDy(double terminalDy) {
		this.terminalDy = terminalDy;
	}

	public void setAccelerations(double d2x, double d2y) {
		setD2x(d2x);
		setD2y(d2y);
	}

	public void setD2x(double d2x) {
		this.d2x = d2x;
	}

	public void setD2y(double d2y) {
		this.d2y = d2y;
	}

	public void setImage(String fileName) {
		this.image = new Resource(fileName);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public double getD2x() {
		return d2x;
	}

	public double getTerminalDx() {
		return terminalDx;
	}

	public double getTerminalDy() {
		return terminalDy;
	}

	public double getD2y() {
		return d2y;
	}

	public Bounds getBounds() {
		return new Bounds(getX() + getWidth() / 2, getY() + getHeight() / 2, getWidth());
	}

	@Override
	public String toString() {
		return "Entity [x=" + x + ", y" + y + ", width=" + width + ", height=" + height + ", dx=" + dx + ", dy=" + dy
				+ ", terminalDx=" + terminalDx + ", terminalDy=" + terminalDy + ", d2x=" + d2x + ", d2y=" + d2y + "]";
	}
}
