package com.entities.aliens.types;

import com.animations.DynamicAnimation;
import com.entities.aliens.Alien;
import com.entities.aliens.Storage;
import com.utils.Reference;
import com.utils.Resource;

public class Tutorial extends Alien
{
	public Tutorial(float x, float y, float terminal_dx, float terminal_dy, int tag)
	{
		this(x, y, 25, 25, terminal_dx, terminal_dy, tag);
	}

	public Tutorial(float x, float y, float width, float height, float terminalDx, float terminalDy, int tag)
	{
		super(x, y, width, height, terminalDx, terminalDy, 1, 0, 100, 0, tag,
				new DynamicAnimation(1, new Resource(Reference.ENTITY_LOC + "alien.png")));
	}

	@Override
	public void shoot(Storage storage) {}

	@Override
	public String getName() {
		return "TUTORIAL";
	}
}
