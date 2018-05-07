package com.entity.mobile.ammo.player.types;

import com.entity.mobile.ammo.player.Ammo;

public class Laser extends Ammo
{
	public Laser(double x, double y, int damage)
	{
		super(x, y, damage);
		setDims(63, 63);
		setImage("laser_body.png");
		setDamage(2);
		setSpeed(10,10);
		rotate();
	}

	@Override
	public String getName() {
		return "LASER";
	}
}
