package com.entities.aliens.types;

import com.animations.DynamicAnimation;
import com.entities.aliens.Alien;
import com.entities.aliens.Storage;
import com.utils.Reference;
import com.utils.Resource;

public class Simple extends Alien
{
	public Simple(float x, float y, float terminalDx, float terminalDy, int tag)
	{
		this(x, y, 25, 25, terminalDx, terminalDy, tag);
	}

	public Simple(float x, float y, float width, float height, float terminalDx, float terminalDy, int tag)
	{
		super(x, y, width, height, terminalDx, terminalDy, 1, 1, 100, 100, tag,
				new DynamicAnimation(1, new Resource(Reference.ENTITY_LOC + "alien.png")));
	}

	@Override
	public void shoot(Storage storage) {
		storage.redMissile(this, getTick());
	}

	@Override
	public String getName() {
		return "SIMPLE";
	}
}
