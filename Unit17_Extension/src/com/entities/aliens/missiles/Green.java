package com.entities.aliens.missiles;

import com.animations.DynamicAnimation;
import com.animations.StaticAnimations;
import com.utils.Reference;
import com.utils.Resource;

public class Green extends Missile
{
	public Green(float x, float y, float angdeg)
	{
		super(x, y, 28, 28, 5, 5, 7, angdeg,
				new DynamicAnimation(4, new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 1, 5, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 2, 5, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 3, 5, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 4, 5, 14)));
	}

	@Override
	public void actionOnLanding() {
		StaticAnimations.greenHit(getX(), getY(), getWidth(), getHeight());
	}
}
