package com.entity.mobile.ammo.player.types;

import com.entity.mobile.ammo.player.Ammo;

public class Rocket extends Ammo
{
	public Rocket(double x, double y, double angdeg)
	{
		super(x, y, angdeg);
		setDims(36, 36);
		setSpeed(0, -3);
		setImage("rocket.png");
		setDamage(15);
		// TODO maybe add splash???
		rotate();
	}
	
	@Override
	public void update() {
		super.update();
		ddx(0.4);
		ddy(0.4);
	}

	@Override
	public String getName() {
		return "ROCKET";
	}
}
