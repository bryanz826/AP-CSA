package com.animations;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.animations.types.Animation;
import com.animations.types.MovingAnimation;
import com.entities.Ship;
import com.utils.Reference;
import com.utils.Resource;

public class REFERENCEPOINT
{
	private List<Animation> animations;

	public REFERENCEPOINT()
	{
		animations = new ArrayList<Animation>();
	}

	// auto-create animations here for convenience	
	public void pickUpRate() {
		add(new MovingAnimation(2, new Resource(new Resource(Reference.POWERUP_LOC + "rate_up.png"), 1, 1, 192),
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

	public void pickUpHP() {
		add(new MovingAnimation(2, new Resource(new Resource(Reference.POWERUP_LOC + "heal.png"), 1, 1, 192),
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

	public void pickUp() {
		add(new MovingAnimation(2, new Resource(new Resource(Reference.POWERUP_LOC + "upgrade.png"), 1, 1, 192),
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

	public void explode(double x, double y, double width, double height) {
		add(new StillAnimation(x - width / 2, y - width / 2, 2 * width, height + width, 1,
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 1, 1, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 2, 1, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 3, 1, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 4, 1, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 5, 1, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 6, 1, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 7, 1, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 8, 1, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 1, 2, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 2, 2, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 3, 2, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 4, 2, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 5, 2, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 6, 2, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 7, 2, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 8, 2, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 1, 3, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 2, 3, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 3, 3, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 4, 3, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 5, 3, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 6, 3, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 7, 3, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 8, 3, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 1, 4, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 2, 4, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 3, 4, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 4, 4, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 5, 4, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 6, 4, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 7, 4, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 8, 4, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 1, 5, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 2, 5, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 3, 5, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 4, 5, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 5, 5, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 6, 5, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 7, 5, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 8, 5, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 1, 6, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 2, 6, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 3, 6, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 4, 6, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 5, 6, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 6, 6, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 7, 6, 256),
				new Resource(new Resource(Reference.ENTITY_LOC + "explosion.png"), 8, 6, 256)));
	}

	public void pinkHit(double x, double y, double width, double height) {
		add(new StillAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 7, 1, 31)));
	}

	public void redHit(double x, double y, double width, double height) {
		add(new StillAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 7, 1, 31)));
	}

	public void orangeHit(double x, double y, double width, double height) {
		add(new StillAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 7, 1, 31)));
	}

	public void yellowHit(double x, double y, double width, double height) {
		add(new StillAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 7, 1, 31)));
	}

	public void blueHit(double x, double y, double width, double height) {
		add(new StillAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 7, 1, 31)));
	}

	public void greenHit(double x, double y, double width, double height) {
		add(new StillAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 7, 1, 31)));
	}

	public void laserHit(double x, double y, double width, double height) {
		add(new StillAnimation(x, y, width, height, 4,
				new Resource(new Resource(Reference.BULLET_LOC + "laser_hit.png"), 1, 1, 13),
				new Resource(new Resource(Reference.BULLET_LOC + "laser_hit.png"), 2, 1, 13)));
	}

	public void add(Animation an) {
		animations.add(an);
	}

	public void update() {
		for (Iterator<Animation> iter = animations.iterator(); iter.hasNext();) {
			Animation an = iter.next();
			if (an.update()) iter.remove();
		}
	}

	public void render(Graphics2D g, Ship ship) {
		for (Animation an : animations) {
			if (an instanceof MovingAnimation)
				an.render(g, ship.getX(), ship.getY(), ship.getWidth(), ship.getHeight());
			else an.render(g);
		}
	}
}
