package com.entities.aliens.missiles;

import com.animations.DynamicAnimation;
import com.animations.StaticAnimations;
import com.utils.Reference;
import com.utils.Resource;

public class Yellow extends Missile
{
	public Yellow(float x, float y, float angdeg)
	{
		super(x, y, 21, 21, 5, 5, 3, angdeg,
				new DynamicAnimation(4, new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 1, 3, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 2, 3, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 3, 3, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 4, 3, 14)));
	}
	
	@Override
	public void actionOnLanding() {
		StaticAnimations.yellowHit(getX(), getY(), getWidth(), getHeight());
	}
}
