package com.entities.player.ammo.types;

import com.animations.DynamicAnimation;
import com.animations.StaticAnimations;
import com.entities.player.ammo.Ammo;
import com.utils.Reference;
import com.utils.Resource;

public class Rocket extends Ammo
{
	public Rocket(float x, float y, float angdeg)
	{
		super(x, y, 36, 36, 0, 20, 0.4f, 0.4f, 15, angdeg, new DynamicAnimation((float) Math.toRadians(angdeg), 1,
				new Resource(Reference.BULLET_LOC + "rocket.png")));
		setDy(-3);
	}

	@Override
	public void actionOnLanding() {
		StaticAnimations.orangeHit(getX(), getY(), getWidth(), getHeight());
	}
}
