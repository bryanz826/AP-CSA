package com.entities.aliens.missiles;

import com.animations.DynamicAnimation;
import com.animations.StaticAnimations;
import com.utils.Reference;
import com.utils.Resource;

public class Red extends Missile
{
	public Red(float x, float y, float angdeg)
	{
		super(x, y, 14, 14, 5, 5, 1, angdeg,
				new DynamicAnimation(4, new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 1, 1, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 2, 1, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 3, 1, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 4, 1, 14)));
	}

	@Override
	public void actionOnLanding() {
		StaticAnimations.redHit(getX(), getY(), getWidth(), getHeight());
	}
}
