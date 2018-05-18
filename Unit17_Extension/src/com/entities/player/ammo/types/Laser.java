package com.entities.player.ammo.types;

import com.animations.DynamicAnimation;
import com.animations.StaticAnimations;
import com.entities.player.ammo.Ammo;
import com.utils.Reference;
import com.utils.Resource;

public class Laser extends Ammo
{
	public Laser(float x, float y)
	{
		super(x, y, 63, 63, 5, 5, 5, 5, 2, 0,
				new DynamicAnimation(1, new Resource(Reference.BULLET_LOC + "laser_body.png")));
	}
	
	@Override
	public void actionOnLanding() {
		StaticAnimations.laserHit(getX(), getY(), getWidth(), getHeight());
	}
}
