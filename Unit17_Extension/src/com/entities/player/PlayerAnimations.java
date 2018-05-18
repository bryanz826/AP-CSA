package com.entities.player;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.animations.DynamicAnimation;
import com.animations.types.BriefDynamicAnimation;
import com.utils.Reference;
import com.utils.Resource;

public class PlayerAnimations
{
	private List<DynamicAnimation> animations;

	public PlayerAnimations()
	{
		animations = new ArrayList<DynamicAnimation>();
	}

	public void skySpread() {
		animations.add(new BriefDynamicAnimation(2,
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 1, 1, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 2, 1, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 3, 1, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 4, 1, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 5, 1, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 1, 2, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 2, 2, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 3, 2, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 4, 2, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 5, 2, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 1, 3, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 2, 3, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 3, 3, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 4, 3, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 5, 3, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 1, 4, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 2, 4, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 3, 4, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 4, 4, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 5, 4, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 1, 5, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 2, 5, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 3, 5, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 4, 5, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 5, 5, 192)));
	}

	public void mixedShine() {
		animations.add(
				new BriefDynamicAnimation(2, new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 1, 1, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 2, 1, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 3, 1, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 4, 1, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 5, 1, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 1, 2, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 2, 2, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 3, 2, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 4, 2, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 5, 2, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 1, 3, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 2, 3, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 3, 3, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 4, 3, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 5, 3, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 1, 4, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 2, 4, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 3, 4, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 4, 4, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 5, 4, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 1, 5, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 2, 5, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 3, 5, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 4, 5, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 5, 5, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 1, 6, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 2, 6, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 3, 6, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 4, 6, 192),
						new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 5, 6, 192)));
	}

	public void purpleSlash() {
		animations.add(new BriefDynamicAnimation(2,
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 1, 1, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 2, 1, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 3, 1, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 4, 1, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 5, 1, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 1, 2, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 2, 2, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 3, 2, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 4, 2, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 5, 2, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 1, 3, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 2, 3, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 3, 3, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 4, 3, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 5, 3, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 1, 4, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 2, 4, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 3, 4, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 4, 4, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 5, 4, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 1, 5, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 2, 5, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 3, 5, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 4, 5, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 5, 5, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 1, 6, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 2, 6, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 3, 6, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 4, 6, 192),
				new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 5, 6, 192)));
	}

	public void update() {
		for (Iterator<DynamicAnimation> iter = animations.iterator(); iter.hasNext();) {
			DynamicAnimation an = iter.next();
			if (an.update()) iter.remove();
		}
	}

	public void render(Graphics2D g, Player ship) {
		for (DynamicAnimation an : animations) {
			an.render(g, ship.getX(), ship.getY(), ship.getWidth(), ship.getHeight());
		}
	}
}
