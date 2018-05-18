package com.entities.player.ammo;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.entities.player.Player;
import com.entities.player.ammo.types.Bullet;
import com.entities.player.ammo.types.Laser;
import com.entities.player.ammo.types.Rocket;
import com.utils.Reference;

public class Magazine
{
	public final int	MAX_BULLET_LEVEL	= 7;
	public final int	MAX_ROCKET_LEVEL	= 3;
	public final int	MIN_FREQUENCY		= 5;

	private int			tick;

	private List<Ammo>	magazine;

	private boolean		legendary;
	private int			bulletLevel;
	private int			rocketLevel;
	private int			laserCount;
	private int			frequency;

	private boolean		usingLaser;

	public Magazine()
	{
		magazine = new ArrayList<Ammo>();

		legendary = false;
		bulletLevel = 0;
		rocketLevel = 0;
		laserCount = 0;
		frequency = 25;
	}

	public boolean reload(Player ship) {
		return reload(ship, 1);
	}

	public boolean reload(Player ship, float multiplier) {
		return ship.getTick() % (multiplier * frequency) == 0;
	}

	public void update(Player ship) {
		if (reload(ship)) {
			if (legendary) explodeBullet(ship);
			else if (bulletLevel == 1) monoBulletUp(ship);
			else if (bulletLevel == 2) dualBulletUp(ship);
			else if (bulletLevel == 3) triBulletUp(ship);
			else if (bulletLevel == 4) miniSpreadBulletUp(ship);
			else if (bulletLevel == 5) mediumSpreadBulletUp(ship);
			else if (bulletLevel == 6) largeSpreadBulletUp(ship);
			else if (bulletLevel == 7) hugeSpreadBulletUp(ship);
		}

		if (reload(ship, 3)) {
			if (rocketLevel == 1) monoRocketUp(ship);
			else if (rocketLevel == 2) dualRocketUp(ship);
			else if (rocketLevel == 3) triRocketUp(ship);
		}

		if (usingLaser) {
			laser(ship);
			if (++tick >= 250) {
				setUsingLaser(false);
				tick = 0;
			}
		}

		for (Iterator<Ammo> iter = magazine.iterator(); iter.hasNext();) {
			Ammo a = iter.next();

			a.update();

			if (a.isLanded()) {
				a.actionOnLanding();
				iter.remove();
			}

			// remove off-screen bullets
			else if (a.getX() + a.getWidth() < 0 || a.getX() > Reference.WIDTH || a.getY() + a.getHeight() < 0
					|| a.getY() > Reference.HEIGHT)
				iter.remove();
		}
	}

	public void render(Graphics2D g) {
		for (Ammo ammo : magazine)
			ammo.render(g);
	}

	public void monoBulletUp(Player ship) {
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14, ship.getY() + ship.getHeight() / 2.5f, 0));
	}

	public void dualBulletUp(Player ship) {
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 28, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2, ship.getY() + ship.getHeight() / 2.5f, 0));

	}

	public void triBulletUp(Player ship) {
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 32, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 + 4, ship.getY() + ship.getHeight() / 2.5f, 0));

	}

	public void miniSpreadBulletUp(Player ship) {
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 36, ship.getY() + ship.getHeight() / 2.5f, 354));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 32, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 + 4, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 + 8, ship.getY() + ship.getHeight() / 2.5f, 6));
	}

	public void mediumSpreadBulletUp(Player ship) {

		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 48, ship.getY() + ship.getHeight() / 2.5f, 354));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 30, ship.getY() + ship.getHeight() / 2.5f, 354));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 24, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 4, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 + 2, ship.getY() + ship.getHeight() / 2.5f, 6));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 + 20, ship.getY() + ship.getHeight() / 2.5f, 6));
	}

	public void largeSpreadBulletUp(Player ship) {
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 40, ship.getY() + ship.getHeight() / 2.5f, 348));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 36, ship.getY() + ship.getHeight() / 2.5f, 354));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 32, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 + 4, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 + 8, ship.getY() + ship.getHeight() / 2.5f, 6));
		add(new Bullet(ship.getX() + ship.getWidth() / 2 + 12, ship.getY() + ship.getHeight() / 2.5f, 12));
	}

	public void hugeSpreadBulletUp(Player ship) {
		for (int i = 0; i < 9; i++) {
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14 - 16 + 4 * i, ship.getY() + ship.getHeight() / 2.5f,
					344 + 4 * i));
		}
	}

	public void explodeBullet(Player ship) {
		for (int i = 0; i < 90; i++) {
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14, ship.getY() + ship.getHeight() / 2.5f, 4 * i));
		}
	}

	public void monoRocketUp(Player ship) {
		add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18, ship.getY() + ship.getHeight() / 2.5f, 0));
	}

	public void dualRocketUp(Player ship) {
		add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18 - 30, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18 + 30, ship.getY() + ship.getHeight() / 2.5f, 0));
	}

	public void triRocketUp(Player ship) {
		add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18 - 30, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18, ship.getY() + ship.getHeight() / 2.5f, 0));
		add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18 + 30, ship.getY() + ship.getHeight() / 2.5f, 0));
	}

	public void laser(Player ship) {
		add(new Laser(ship.getX() + ship.getWidth() / 2 - 32, ship.getY() - ship.getHeight() / 4));
	}

	public void add(Ammo a) {
		magazine.add(a);
	}

	public void invokeGodTier() {
		legendary = true;
	}

	public void incBulletLevel() {
		bulletLevel++;
		if (bulletLevel > MAX_BULLET_LEVEL) bulletLevel = MAX_BULLET_LEVEL;
	}

	public void incRocketLevel() {
		rocketLevel++;
		if (rocketLevel > MAX_ROCKET_LEVEL) rocketLevel = MAX_ROCKET_LEVEL;
	}

	public void incLaserCount() {
		laserCount++;
	}

	public void decLaserCount() {
		laserCount--;
	}

	public void decFrequency() {
		frequency -= 5;
		if (frequency < MIN_FREQUENCY) frequency = MIN_FREQUENCY;
	}

	public void setUsingLaser(boolean usingLaser) {
		this.usingLaser = usingLaser;
	}

	public List<Ammo> getList() {
		return magazine;
	}

	public int getBulletLevel() {
		return bulletLevel;
	}

	public int getLaserCount() {
		return laserCount;
	}

	public boolean isUsingLaser() {
		return usingLaser;
	}

	public String toString() {
		return Arrays.toString(magazine.toArray());
	}
}
