package com.entity.mobile.powerups.types;

import com.entity.mobile.powerups.PowerUp;

public class LaserUp extends PowerUp
{
	public LaserUp(double x, double y)
	{
		super(x, y);
		setImage("laser_powerup.png");
	}

	@Override
	public String getName() {
		return "LASERUP";
	}
}
