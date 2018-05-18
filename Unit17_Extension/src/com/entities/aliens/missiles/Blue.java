package com.entities.aliens.missiles;

import com.animations.DynamicAnimation;
import com.animations.StaticAnimations;
import com.utils.Reference;
import com.utils.Resource;

public class Blue extends Missile
{
	public Blue(float x, float y, float angdeg)
	{
		super(x, y, 24, 24, 5, 5, 5, angdeg,
				new DynamicAnimation(4, new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 1, 4, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 2, 4, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 3, 4, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 4, 4, 14)));
	}

	@Override
	public void actionOnLanding() {
		StaticAnimations.blueHit(getX(), getY(), getWidth(), getHeight());
	}
}
