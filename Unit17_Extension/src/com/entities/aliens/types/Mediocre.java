package com.entities.aliens.types;

import com.animations.DynamicAnimation;
import com.entities.aliens.Alien;
import com.entities.aliens.Storage;
import com.utils.Reference;
import com.utils.Resource;

public class Mediocre extends Alien
{
	public Mediocre(float x, float y, float terminal_dx, float terminal_dy, int tag)
	{
		this(x, y, 32.5f, 32.5f, terminal_dx, terminal_dy, tag);
	}

	public Mediocre(float x, float y, float width, float height, float terminalDx, float terminalDy, int tag)
	{
		super(x, y, width, height, terminalDx, terminalDy, 5, 2, 500, 75, tag,
				new DynamicAnimation(1, new Resource(Reference.ENTITY_LOC + "alien.png")));
	}

	@Override
	public void shoot(Storage storage) {
		storage.orangeMissile(this, getTick());
	}

	@Override
	public String getName() {
		return "MEDIOCRE";
	}
}
