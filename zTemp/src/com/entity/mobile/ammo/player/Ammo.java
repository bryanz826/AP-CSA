package com.entity.mobile.ammo.player;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import com.entity.mobile.Mobile;
import com.entity.mobile.live.player.Ship;
import com.manager.Bounds;

import coc.utils.Reference;
import coc.utils.Resource;

public abstract class Ammo extends Mobile
{
	protected double	radians;
	private int			damage;
	private boolean		landed;

	public Ammo(double x, double y, double angdeg)
	{
		this(x, y, 1, angdeg);
	}

	public Ammo(double x, double y, int damage, double angdeg)
	{
		this(x, y, 10, 10, 10, 10, damage, angdeg);
	}

	public Ammo(double x, double y, double width, double height, double dx, double dy, int damage, double angdeg)
	{
		super(x, y, width, height, dx, dy);
		setPos(x, y);
		setSpeed(dx, dy);
		this.radians = Math.toRadians(angdeg);
		setDamage(1);
		setLanded(false);
	}

	public void rotate() {
		AffineTransform details = AffineTransform.getRotateInstance(radians, getWidth() / 2, getHeight() / 2);
		setImage(
				new Resource(new AffineTransformOp(details, AffineTransformOp.TYPE_BILINEAR).filter(getImage(), null)));
	}

	@Override
	public void update() {
		setX(getX() + getDx() * Math.sin(radians));
		setY(getY() - getDy() * Math.cos(radians));
		ddx(0.2);
		ddy(0.2);
	}

	public void update(Ship ship) {
		setX(getX() + getDx() * Math.sin(radians) + ship.getDx());
		setY(getY() - getDy() * Math.cos(radians));
		ddx(0.2);
		ddy(0.2);
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(getImage(), (int) getX(), (int) getY(), null);
		getBounds().DEBUG(g);
	}
	
	@Override
	public void setImage(String fileName) {
		super.setImage(Reference.BULLET_LOC + fileName);
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setLanded(boolean landed) {
		this.landed = landed;
	}

	public int getDamage() {
		return damage;
	}

	public boolean isLanded() {
		return landed;
	}

	@Override
	public Bounds getBounds() {
		double ammoRad = getWidth() / 2 * 2 / 3; // acquire 2/3 of radius
		double boundsSize = getWidth() * 1 / 2;

		double xFinal = ammoRad * Math.sin(radians);
		double yFinal = ammoRad * Math.cos(radians);
		return new Bounds(getX() + getWidth() / 2 + xFinal - boundsSize / 2,
				getY() + getWidth() / 2 - yFinal - boundsSize / 2, boundsSize);
	}
}
