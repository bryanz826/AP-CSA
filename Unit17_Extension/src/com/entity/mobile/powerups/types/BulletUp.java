package com.entity.mobile.powerups.types;

import com.entity.mobile.powerups.PowerUp;

public class BulletUp extends PowerUp
{
	public BulletUp(double x, double y)
	{
		super(x, y);
		setImage("bullet_powerup.png");
	}

	@Override
	public String getName() {
		return "BULLETUP";
	}
}
