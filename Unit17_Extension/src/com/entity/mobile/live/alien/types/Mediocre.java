package com.entity.mobile.live.alien.types;

import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.live.alien.Alien;

public class Mediocre extends Alien
{
	public Mediocre(double x, double y, double terminal_dx, double terminal_dy, int tag)
	{
		this(x, y, 32.5, 32.5, terminal_dx, terminal_dy, tag);
	}

	public Mediocre(double x, double y, double w, double h, double terminal_dx, double terminal_dy, int tag)
	{
		super(x, y, w, h, terminal_dx, terminal_dy, 5, 2, 500, tag);
		setImage("alien.png");
		setFrequency(75);
	}

	@Override
	public void shoot(Storage storage, int timer) {
		storage.orangeMissile(this, timer);
	}

	@Override
	public String getName() {
		return "MEDIOCRE";
	}
}
