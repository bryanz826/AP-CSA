package com.entities.player.ammo;

import com.animations.DynamicAnimation;
import com.entities.Projectile;

public abstract class Ammo extends Projectile
{
	public Ammo(float x, float y, float width, float height, float terminalDx, float terminalDy, float d2x, float d2y, int damage,
			float angdeg, DynamicAnimation anim)
	{
		super(x, y, width, height, terminalDx, terminalDy, d2x, d2y, damage, angdeg, anim);
	}
}
