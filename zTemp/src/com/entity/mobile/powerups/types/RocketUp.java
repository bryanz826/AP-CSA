package com.entity.mobile.powerups.types;

import com.entity.mobile.powerups.PowerUp;

public class RocketUp extends PowerUp
{
	public RocketUp(double x, double y)
	{
		super(x, y);
		setImage("rocket_powerup.png");
	}

	@Override
	public String getName() {
		return "ROCKETUP";
	}
}
