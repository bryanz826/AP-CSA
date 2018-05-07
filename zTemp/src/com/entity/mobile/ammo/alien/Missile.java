package com.entity.mobile.ammo.alien;

import java.awt.Graphics2D;

import com.animations.types.ConstantAnimation;
import com.entity.mobile.ammo.player.Ammo;
import com.manager.Bounds;

public abstract class Missile extends Ammo
{
	private ConstantAnimation anim;
	
	public Missile(double x, double y, double angdeg)
	{
		this(x, y, 1, angdeg);
	}

	public Missile(double x, double y, int damage, double angdeg)
	{
		this(x, y, 10, 10, 2, 2, damage, angdeg);
	}

	public Missile(double x, double y, double width, double height, double dx, double dy, int damage, double angdeg)
	{
		super(x, y, width, height, dx, dy, damage, angdeg);
	}

	@Override
	public void update() {
		setX(getX() + getDx() * Math.sin(radians));
		setY(getY() - getDy() * Math.cos(radians));
		anim.update();
	}
	
	@Override
	public void render(Graphics2D g) {
		anim.render(g, getX(), getY(), getWidth(), getHeight());
		getBounds().DEBUG(g);
	}
	
	public void setAnim(ConstantAnimation anim) {
		this.anim = anim;
	}

	@Override
	public Bounds getBounds() {
		return new Bounds(getX(), getY(), getWidth());
	}

	@Override
	public String getName() {
		return "MISSILE";
	}
}
