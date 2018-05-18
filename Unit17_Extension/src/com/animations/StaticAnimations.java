package com.animations;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.animations.types.StaticAnimation;
import com.utils.Reference;
import com.utils.Resource;

public class StaticAnimations
{
	private static List<StaticAnimation> animations;

	public StaticAnimations()
	{
		animations = new ArrayList<StaticAnimation>();
	}

	public void update() {
		for (Iterator<StaticAnimation> iter = animations.iterator(); iter.hasNext();) {
			StaticAnimation an = iter.next();
			if (an.update()) iter.remove();
		}
	}

	public void render(Graphics2D g) {
		for (StaticAnimation an : animations) {
			an.render(g);
		}
	}
	public static void explode(float x, float y, float width, float height) {
		add(new StaticAnimation(x - width / 2, y - width / 2, 2 * width, height + width, 1,
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

	public static void pinkHit(float x, float y, float width, float height) {
		add(new StaticAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "pink_hit.png"), 7, 1, 31)));
	}

	public static void redHit(float x, float y, float width, float height) {
		add(new StaticAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "red_hit.png"), 7, 1, 31)));
	}

	public static void orangeHit(float x, float y, float width, float height) {
		add(new StaticAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "orange_hit.png"), 7, 1, 31)));
	}

	public static void yellowHit(float x, float y, float width, float height) {
		add(new StaticAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "yellow_hit.png"), 7, 1, 31)));
	}

	public static void blueHit(float x, float y, float width, float height) {
		add(new StaticAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "blue_hit.png"), 7, 1, 31)));
	}

	public static void greenHit(float x, float y, float width, float height) {
		add(new StaticAnimation(x, y, width, height, 2,
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 1, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 2, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 3, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 4, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 5, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 6, 1, 31),
				new Resource(new Resource(Reference.BULLET_LOC + "green_hit.png"), 7, 1, 31)));
	}

	public static void laserHit(float x, float y, float width, float height) {
		add(new StaticAnimation(x, y, width, height, 4,
				new Resource(new Resource(Reference.BULLET_LOC + "laser_hit.png"), 1, 1, 13),
				new Resource(new Resource(Reference.BULLET_LOC + "laser_hit.png"), 2, 1, 13)));
	}

	public static void add(StaticAnimation an) {
		animations.add(an);
	}
}
