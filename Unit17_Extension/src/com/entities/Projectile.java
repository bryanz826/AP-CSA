package com.entities;

import java.util.ArrayList;

import com.animations.DynamicAnimation;

public abstract class Projectile extends Entity
{
	private int		damage;
	private float	radians;
	private boolean	landed;

	public Projectile(float x, float y, float terminalDx, float terminalDy, float d2x, float d2y, int damage,
			float angdeg, DynamicAnimation anim)
	{
		this(x, y, 10, 10, terminalDx, terminalDy, d2x, d2y, damage, angdeg, anim);
	}

	public Projectile(float x, float y, float width, float height, float terminalDx, float terminalDy, float d2x,
			float d2y, int damage, float angdeg, DynamicAnimation anim)
	{
		super(x, y, width, height, terminalDx, terminalDy, anim);
		this.radians = (float) Math.toRadians(angdeg);
		setDamage(damage);
		setLanded(false);
	}

	public abstract void actionOnLanding();

	@Override
	public void update() {
		accelNegY();
		
		setX((float) (getX() + getDx() /** Math.sin(radians)*/));
		setY((float) (getY() + getDy() /** Math.cos(radians)*/));
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

	public float getRadians() {
		return radians;
	}

	public boolean isLanded() {
		return landed;
	}

	@Override
	public ArrayList<Bounds> getBounds() {
		ArrayList<Bounds> list = new ArrayList<Bounds>(1);
		float ammoRad = getWidth() / 2 * 2 / 3; // acquire 2/3 of radius
		float boundsSize = getWidth() * 1 / 2;

		float xFinal = (float) (ammoRad * Math.sin(radians));
		float yFinal = (float) (ammoRad * Math.cos(radians));
		list.add(new Bounds(getX() + getWidth() / 2 + xFinal - boundsSize / 2,
				getY() + getWidth() / 2 - yFinal - boundsSize / 2, boundsSize));
		return list;
	}
}
