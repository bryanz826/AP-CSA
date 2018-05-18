package com.entities.player.powerups;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.entities.player.Player;
import com.entities.player.powerups.types.BulletUp;
import com.entities.player.powerups.types.HealthUp;
import com.entities.player.powerups.types.LaserUp;
import com.entities.player.powerups.types.LegendaryUp;
import com.entities.player.powerups.types.RateUp;
import com.entities.player.powerups.types.RocketUp;
import com.utils.Reference;

public class PowerUps
{
	private List<PowerUp> powerups;

	public PowerUps()
	{
		powerups = new ArrayList<PowerUp>();
	}

	public void addHealthUp(float x, float y) {
		add(new HealthUp(x, y));
	}

	public void addRateUp(float x, float y) {
		add(new RateUp(x, y));
	}

	public void addBulletUp(float x, float y) {
		add(new BulletUp(x, y));
	}

	public void addRocketUp(float x, float y) {
		add(new RocketUp(x, y));
	}

	public void addLaserUp(float x, float y) {
		add(new LaserUp(x, y));
	}

	public void addLegendaryUp(float x, float y) {
		add(new LegendaryUp(x, y));
	}

	public void add(PowerUp powerup) {
		powerups.add(powerup);
	}

	public void update(Player ship) {
		for (Iterator<PowerUp> iter = powerups.iterator(); iter.hasNext();) {
			PowerUp p = iter.next();

			p.update();

			if (p.isPickedUp()) {
				p.actionOnPickUp(ship);
				iter.remove();
			}

			// remove off-screen powerups
			else if (p.getX() + p.getWidth() < 0 || p.getX() > Reference.WIDTH || p.getY() + p.getHeight() < 0
					|| p.getY() > Reference.HEIGHT)
				iter.remove();
		}
	}

	public void render(Graphics2D g) {
		for (PowerUp p : powerups)
			p.render(g);
	}

	public List<PowerUp> getList() {
		return powerups;
	}
}
