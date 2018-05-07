package com.entity.mobile.powerups.types;

import com.entity.mobile.powerups.PowerUp;

public class HealthUp extends PowerUp
{
	public HealthUp(double x, double y)
	{
		super(x, y);
		setImage("hp_powerup.png");
	}

	@Override
	public String getName() {
		return "HEALTHUP";
	}
}
