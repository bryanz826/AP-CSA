package com.entities.player.ammo.types;

import com.animations.DynamicAnimation;
import com.animations.StaticAnimations;
import com.entities.player.ammo.Ammo;
import com.utils.Reference;
import com.utils.Resource;

public class Bullet extends Ammo
{
	public Bullet(float x, float y, float angdeg)
	{
		super(x, y, 27, 27, 40, 40, 40, 40, 2, angdeg, new DynamicAnimation((float) Math.toRadians(angdeg), 1,
				new Resource(Reference.BULLET_LOC + "bullet.png")));
	}

	@Override
	public void actionOnLanding() {
		StaticAnimations.pinkHit(getX() + getWidth() / 2 - getWidth() / 4, getY() + getWidth() / 2 - getWidth() / 4,
				getWidth() / 2, getHeight() / 2);
	}
}
