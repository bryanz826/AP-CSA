package com.entity.mobile.live.alien.types;

import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.live.alien.Alien;

public class Harder extends Alien
{
	public Harder(double x, double y, double terminal_dx, double terminal_dy, int tag)
	{
		this(x, y, 47.5, 47.5, terminal_dx, terminal_dy, tag);
	}

	public Harder(double x, double y, double w, double h, double terminal_dx, double terminal_dy, int tag)
	{
		super(x, y, w, h, terminal_dx, terminal_dy, 20, 5, 2000, tag);
		setImage("alien.png");
		setFrequency(50);
	}

	@Override
	public void shoot(Storage storage, int timer) {
		storage.blueMissile(this, timer);
	}

	@Override
	public String getName() {
		return "HARDER";
	}
}
