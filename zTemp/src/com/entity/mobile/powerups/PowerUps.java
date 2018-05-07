package com.entity.mobile.powerups;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.entity.mobile.live.player.Ship;
import com.entity.mobile.powerups.types.BulletUp;
import com.entity.mobile.powerups.types.HealthUp;
import com.entity.mobile.powerups.types.LaserUp;
import com.entity.mobile.powerups.types.LegendaryUp;
import com.entity.mobile.powerups.types.RateUp;
import com.entity.mobile.powerups.types.RocketUp;
import com.state.levels.LevelManager;

import coc.utils.Reference;

public class PowerUps
{
	private List<PowerUp> powerups;

	public PowerUps()
	{
		powerups = new ArrayList<PowerUp>();
	}

	public void addHealthUp(double x, double y) {
		add(new HealthUp(x, y));
	}
	
	public void addRateUp(double x, double y) {
		add(new RateUp(x, y));
	}
	
	public void addBulletUp(double x, double y) {
		add(new BulletUp(x, y));
	}
	
	public void addRocketUp(double x, double y) {
		add(new RocketUp(x, y));
	}
	
	public void addLaserUp(double x, double y) {
		add(new LaserUp(x, y));
	}
	
	public void addLegendaryUp(double x, double y) {
		add(new LegendaryUp(x, y));
	}

	public void add(PowerUp powerup) {
		powerups.add(powerup);
	}

	public void update(LevelManager lm, Ship ship) {
		for (Iterator<PowerUp> iter = powerups.iterator(); iter.hasNext();) {
			PowerUp p = iter.next();

			p.update();

			if (p.isPickedUp()) {
				if (p instanceof HealthUp) {
					ship.incHp(5);
					ship.triggerPickUpHP();
				} else if (p instanceof RateUp) {
					lm.decFrequency();
					ship.triggerPickUpRate();
				} else {
					if (p instanceof BulletUp) lm.incBulletLevel();
					else if (p instanceof RocketUp) lm.incRocketLevel();
					else if (p instanceof LaserUp) lm.incLaserCount();
					else if (p instanceof LegendaryUp) lm.invokeGodTier();
					ship.triggerPickUp();
				}
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

	public List<PowerUp> getPowerups() {
		return powerups;
	}
}
