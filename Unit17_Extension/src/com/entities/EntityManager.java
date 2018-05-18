package com.entities;

import java.awt.Graphics2D;

import com.animations.StaticAnimations;
import com.entities.aliens.Horde;
import com.entities.aliens.Storage;
import com.entities.player.Player;
import com.utils.Playable;
import com.utils.Reference;
import com.utils.Resource;

public class EntityManager implements Playable
{
	private StaticAnimations	animations;
	private Resource			portal;

	private Player				ship;
	private Horde				horde;
	private Storage				storage;

	public void init() {
		animations = new StaticAnimations();
		ship = new Player(Reference.CENTER_X, Reference.CENTER_Y * 1.5f, 7, 7);
		horde = new Horde();
		storage = new Storage();
		portal = new Resource(Reference.STATE_LOC + "gradient.png");
	}
	
	public void clearBullets() {
		ship.getMagazine().getList().clear();
		storage.getList().clear();
	}

	@Override
	public void processInput() {
		ship.processInput();
	}

	@Override
	public void update() {
		Collisions.update(ship, horde, storage);

		ship.update();
		horde.update();
		storage.update();
		animations.update();
	}

	@Override
	public void render(Graphics2D g) {
		horde.render(g);
		if (ship.isAllowedToPass()) portal.render(g, 0, 0);
		ship.render(g);
		animations.render(g);
		storage.render(g);
	}
	
	public Player getShip() {
		return ship;
	}
	
	public Horde getHorde() {
		return horde;
	}
}
