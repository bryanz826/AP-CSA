package com.entities.aliens.types;

import com.animations.DynamicAnimation;
import com.entities.aliens.Alien;
import com.entities.aliens.Storage;
import com.utils.Reference;
import com.utils.Resource;

public class Harder extends Alien
{
	public Harder(float x, float y, float terminal_dx, float terminal_dy, int tag)
	{
		this(x, y, 47.5f, 47.5f, terminal_dx, terminal_dy, tag);
	}

	public Harder(float x, float y, float width, float height, float terminalDx, float terminalDy, int tag)
	{
		super(x, y, width, height, terminalDx, terminalDy, 20, 5, 2000, 50, tag,
				new DynamicAnimation(1, new Resource(Reference.ENTITY_LOC + "alien.png")));
	}

	@Override
	public void shoot(Storage storage) {
		storage.blueMissile(this, getTick());
	}

	@Override
	public String getName() {
		return "HARDER";
	}
}
