package com.entities;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.animations.DynamicAnimation;
import com.utils.Loopable;
import com.utils.Reference;

public class Entity implements Loopable
{
	private float			x;
	private float			y;
	private float			width;
	private float			height;
	private float			dx;
	private float			dy;
	private float			terminalDx;
	private float			terminalDy;
	private float			d2x;
	private float			d2y;

	private DynamicAnimation	anim;

	public Entity()
	{
		this(Reference.CENTER_X, Reference.CENTER_Y, 25, 25, new DynamicAnimation());
	}

	public Entity(float x, float y, float width, float height, DynamicAnimation anim)
	{
		this(x, y, width, height, 5, 5, anim);
	}

	public Entity(float x, float y, float width, float height, float terminalDx, float terminalDy, DynamicAnimation anim)
	{
		this(x, y, width, height, terminalDx, terminalDy, 0.2f, 0.2f, anim);
	}

	public Entity(float x, float y, float width, float height, float terminalDx, float terminalDy, float d2x, float d2y,
			DynamicAnimation anim)
	{
		setPosition(x, y);
		setDimensions(width, height);
		setTerminalVelocities(terminalDx, terminalDy);
		setAccelerations(d2x, d2y);
		this.anim = anim;
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
		anim.update();
	}

	@Override
	public void render(Graphics2D g) {
		anim.render(g, getX(), getY(), getWidth(), getHeight());
		for (Bounds bounds : getBounds())
			bounds.DEBUG(g);
	}

	public void setPosition(float x, float y) {
		setX(x);
		setY(y);
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setDimensions(float width, float height) {
		setWidth(width);
		setHeight(height);
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}

	public void setTerminalVelocities(float terminalDx, float terminalDy) {
		setTerminalDx(terminalDx);
		setTerminalDy(terminalDy);
	}

	public void setTerminalDx(float terminalDx) {
		this.terminalDx = terminalDx;
	}

	public void setTerminalDy(float terminalDy) {
		this.terminalDy = terminalDy;
	}

	public void setAccelerations(float d2x, float d2y) {
		setD2x(d2x);
		setD2y(d2y);
	}

	public void setD2x(float d2x) {
		this.d2x = d2x;
	}

	public void setD2y(float d2y) {
		this.d2y = d2y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getDx() {
		return dx;
	}

	public float getDy() {
		return dy;
	}

	public float getD2x() {
		return d2x;
	}

	public float getTerminalDx() {
		return terminalDx;
	}

	public float getTerminalDy() {
		return terminalDy;
	}

	public float getD2y() {
		return d2y;
	}

	public ArrayList<Bounds> getBounds() {
		ArrayList<Bounds> list = new ArrayList<Bounds>();
		list.add(new Bounds(getX(), getY(), getWidth()));
		return list;
	}

	@Override
	public String toString() {
		return "Entity [x=" + x + ", y" + y + ", width=" + width + ", height=" + height + ", dx=" + dx + ", dy=" + dy
				+ ", terminalDx=" + terminalDx + ", terminalDy=" + terminalDy + ", d2x=" + d2x + ", d2y=" + d2y
				+ ", boundsCount=" + getBounds().size() + "]";
	}
}
