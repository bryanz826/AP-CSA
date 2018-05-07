package com.entity.mobile.ammo.player.types;

import com.entity.mobile.ammo.player.Ammo;

public class Bullet extends Ammo
{
	public Bullet(double x, double y, double angdeg)
	{
		super(x, y, angdeg);
		setDims(27, 27);
		setImage("bullet.png");
		setDamage(2);
		rotate();
	}

	@Override
	public String getName() {
		return "BULLET";
	}
}
