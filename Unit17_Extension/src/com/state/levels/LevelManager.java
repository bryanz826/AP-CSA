package com.state.levels;

import java.awt.Graphics2D;

import com.animations.Animations;
import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.ammo.player.Magazine;
import com.entity.mobile.live.alien.AlienHorde;
import com.entity.mobile.live.player.Ship;
import com.entity.mobile.powerups.PowerUps;
import com.manager.Collisions;
import com.manager.HUD;
import com.state.States;
import com.utils.Reference;
import com.utils.Resource;

public abstract class LevelManager
{
	public static final int		MAX_BULLET_LEVEL	= 7;
	public static final int		MAX_ROCKET_LEVEL	= 3;
	public static final int		MIN_FREQUENCY		= 5;

	protected static Animations	animations;
	protected static Collisions	collisions;
	protected static Ship		ship;
	protected static AlienHorde	horde;
	protected static PowerUps	powerups;
	protected static Magazine	magazine;
	protected static Storage	storage;
	protected static HUD		hud;
	protected static Resource	portal;

	protected static int		timer;
	protected static int		score;

	protected static boolean	legendary;
	protected static int		bulletLevel;
	protected static int		rocketLevel;
	protected static int		laserCount;
	protected static int		frequency;

	protected static boolean	shipDead;

	protected int				wave;
	protected int				tick;
	protected Resource			bg;

	public abstract void init();	
	
	public static void start() {
		animations = new Animations();
		collisions = new Collisions();
		ship = new Ship(Reference.CENTER_X, Reference.CENTER_Y * 1.5, 7, 7, 20);
		horde = new AlienHorde();
		powerups = new PowerUps();
		magazine = new Magazine();
		storage = new Storage();
		hud = new HUD(ship);
		portal = new Resource(Reference.STATE_LOC + "gradient.png");

		timer = 0;
		score = 0;
		
		legendary = false;
		bulletLevel = 0;
		rocketLevel = 0;
		laserCount = 0;
		frequency = 25;
			
		shipDead = false;
	}

	public void enter() {
		wave = 0;
		tick = 0;
		powerups.getPowerups().clear();
		storage.getStorage().clear();
	}

	public void processInput(States sm) {
		if (!shipDead) ship.processInput(this);
		hud.processInput(this);
	}

	public void update(States sm) {
		timer++;
		tick++;
		
		// player
		if (legendary) magazine.explodeBullet(ship, timer, frequency);
		else if (bulletLevel == 1) magazine.monoBulletUp(ship, timer, frequency);
		else if (bulletLevel == 2) magazine.dualBulletUp(ship, timer, frequency);
		else if (bulletLevel == 3) magazine.triBulletUp(ship, timer, frequency);
		else if (bulletLevel == 4) magazine.miniSpreadBulletUp(ship, timer, frequency);
		else if (bulletLevel == 5) magazine.mediumSpreadBulletUp(ship, timer, frequency);
		else if (bulletLevel == 6) magazine.largeSpreadBulletUp(ship, timer, frequency);
		else if (bulletLevel == 7) magazine.hugeSpreadBulletUp(ship, timer, frequency);

		if (rocketLevel == 1) magazine.monoRocketUp(ship, timer, frequency);
		else if (rocketLevel == 2) magazine.dualRocketUp(ship, timer, frequency);
		else if (rocketLevel == 3) magazine.triRocketUp(ship, timer, frequency);
		
//		if (laserLevel == 1) magazine.laser(ship);
//		else if (laserLevel == 2) magazine.laser(ship);
//		else if (laserLevel == 3) magazine.laser(ship);
	
		
		collisions.update(ship, magazine, powerups, horde, storage);

		if (!shipDead) {
			ship.update(sm, this, animations);
			hud.update(magazine, ship);
			magazine.update(animations, ship, hud);
		} else if (shipDead) {
			if (++tick == 250) {
				sm.setState("GAMEOVER");
			}
		}
		
		powerups.update(this, ship);
		horde.update(this, animations, powerups, storage, timer);
		storage.update(animations);
		animations.update();
		
	}

	public void render(Graphics2D g) {
		bg.render(g, 0, 0, Reference.WIDTH, Reference.HEIGHT);
		horde.render(g);
		powerups.render(g);
		if (!shipDead) {
			magazine.render(g);
			ship.render(g);
		}
		storage.render(g);
		animations.render(g, ship);
		if (ship.isPass()) portal.render(g, 0, 0);
		hud.render(g, ship, this);
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

	public void decFrequency() {
		frequency -= 5;
		if (frequency < MIN_FREQUENCY) frequency = MIN_FREQUENCY;
	}

	public void killShip() {
		shipDead = true;
		tick = 0;
	}

	public void incScore(int score) {
		LevelManager.score += score;
	}
	
	public void decLaserCount() {
		laserCount--;
	}

	public boolean isShipDead() {
		return shipDead;
	}

	public static int getScore() {
		return score;
	}
	
	public static int getTimer() {
		return timer;
	}

	public int getBulletLevel() {
		return bulletLevel;
	}
	
	public int getLaserCount() {
		return laserCount;
	}
}
