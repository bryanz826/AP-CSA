package com.entities.aliens.missiles;

import java.util.ArrayList;

import com.animations.DynamicAnimation;
import com.entities.Bounds;
import com.entities.Projectile;

public abstract class Missile extends Projectile
{
	public Missile(float x, float y, float width, float height, float terminalDx, float terminalDy, int damage,
			float angdeg, DynamicAnimation anim)
	{
		super(x, y, width, height, terminalDx, terminalDy, 0.35f, 0.35f, damage, angdeg, anim);
	}

	@Override
	public ArrayList<Bounds> getBounds() {
		ArrayList<Bounds> list = new ArrayList<Bounds>(1);
		list.add(new Bounds(getX(), getY(), getWidth()));
		return list;
	}
}
