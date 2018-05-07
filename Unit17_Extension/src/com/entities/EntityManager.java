package com.entities;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.animations.types.Animation;
import com.utils.Playable;

public class EntityManager implements Playable
{
	private static final List<Animation>	ANIMATIONS = new ArrayList<Animation>();
	private static final List<Alien>		ALIENS = new ArrayList<Alien>();
	private static final List<Missile>		MISSILE = new ArrayList<Missile>();
	private static final List<PowerUp>		POWERUPS = new ArrayList<PowerUp>();
	
	@Override
	public void processInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub

	}
}
