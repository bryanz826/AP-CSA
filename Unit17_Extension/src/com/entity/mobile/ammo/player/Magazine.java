package com.entity.mobile.ammo.player;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.animations.Animations;
import com.entity.mobile.ammo.player.types.Bullet;
import com.entity.mobile.ammo.player.types.Laser;
import com.entity.mobile.ammo.player.types.Rocket;
import com.entity.mobile.live.player.Ship;
import com.manager.HUD;
import com.utils.Reference;

public class Magazine
{
	private List<Ammo> magazine;

	public Magazine()
	{
		magazine = new ArrayList<Ammo>();
	}

	/**
	 * A utility method that activates <code>bulletLevel</code> 1.
	 * <p>
	 * The specified number of bullets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Bullet
	 * @see LevelManager
	 * @see LevelManager#bulletLevel
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void monoBulletUp(Ship ship, int timer, int frequency) {
		if (timer % frequency == 0) {
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14, ship.getY() + ship.getHeight() / 2.5, 0));
		}
	}

	/**
	 * A utility method that activates <code>bulletLevel</code> 2.
	 * <p>
	 * The specified number of bullets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Bullet
	 * @see LevelManager
	 * @see LevelManager#bulletLevel
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void dualBulletUp(Ship ship, int timer, int frequency) {
		if (timer % (frequency) == 0) {
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 28, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2, ship.getY() + ship.getHeight() / 2.5, 0));
		}
	}

	/**
	 * A utility method that activates <code>bulletLevel</code> 3.
	 * <p>
	 * The specified number of bullets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Bullet
	 * @see LevelManager
	 * @see LevelManager#bulletLevel
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void triBulletUp(Ship ship, int timer, int frequency) {
		if (timer % (frequency) == 0) {
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 32, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 + 4, ship.getY() + ship.getHeight() / 2.5, 0));
		}
	}

	/**
	 * A utility method that activates <code>bulletLevel</code> 4.
	 * <p>
	 * The specified number of bullets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Bullet
	 * @see LevelManager
	 * @see LevelManager#bulletLevel
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void miniSpreadBulletUp(Ship ship, int timer, int frequency) {
		if (timer % (frequency) == 0) {
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 36, ship.getY() + ship.getHeight() / 2.5, 354));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 32, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 + 4, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 + 8, ship.getY() + ship.getHeight() / 2.5, 6));
		}
	}

	/**
	 * A utility method that activates <code>bulletLevel</code> 5.
	 * <p>
	 * The specified number of bullets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Bullet
	 * @see LevelManager
	 * @see LevelManager#bulletLevel
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void mediumSpreadBulletUp(Ship ship, int timer, int frequency) {
		if (timer % (frequency) == 0) {
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 48, ship.getY() + ship.getHeight() / 2.5, 354));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 30, ship.getY() + ship.getHeight() / 2.5, 354));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 24, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 4, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 + 2, ship.getY() + ship.getHeight() / 2.5, 6));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 + 20, ship.getY() + ship.getHeight() / 2.5, 6));
		}
	}

	/**
	 * A utility method that activates <code>bulletLevel</code> 6.
	 * <p>
	 * The specified number of bullets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Bullet
	 * @see LevelManager
	 * @see LevelManager#bulletLevel
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void largeSpreadBulletUp(Ship ship, int timer, int frequency) {
		if (timer % (frequency) == 0) {
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 40, ship.getY() + ship.getHeight() / 2.5, 348));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 36, ship.getY() + ship.getHeight() / 2.5, 354));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 32, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 + 4, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 + 8, ship.getY() + ship.getHeight() / 2.5, 6));
			add(new Bullet(ship.getX() + ship.getWidth() / 2 + 12, ship.getY() + ship.getHeight() / 2.5, 12));
		}
	}

	/**
	 * A utility method that activates <code>bulletLevel</code> 7.
	 * <p>
	 * The specified number of bullets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Bullet
	 * @see LevelManager
	 * @see LevelManager#bulletLevel
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void hugeSpreadBulletUp(Ship ship, int timer, int frequency) {
		if (timer % frequency == 0) {
			for (int i = 0; i < 9; i++) {
				add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14 - 16 + 4 * i,
						ship.getY() + ship.getHeight() / 2.5, 344 + 4 * i));
			}
		}
	}

	/**
	 * A utility method that activates a legendary latent ability.
	 * <p>
	 * The specified number of bullets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Bullet
	 * @see LevelManager
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void explodeBullet(Ship ship, int timer, int frequency) {
		if (timer % frequency == 0) {
			for (int i = 0; i < 90; i++) {
				add(new Bullet(ship.getX() + ship.getWidth() / 2 - 14, ship.getY() + ship.getHeight() / 2.5, 4 * i));
			}
		}
	}

	/**
	 * A utility method that activates <code>rocketLevel</code> 1.
	 * <p>
	 * The specified number of rockets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Rocket
	 * @see LevelManager
	 * @see LevelManager#rocketLevel
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void monoRocketUp(Ship ship, int timer, int frequency) {
		if (timer % (3 * frequency) == 0) {
			add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18, ship.getY() + ship.getHeight() / 2.5, 0));
		}
	}

	/**
	 * A utility method that activates <code>rocketLevel</code> 2.
	 * <p>
	 * The specified number of rockets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Rocket
	 * @see LevelManager
	 * @see LevelManager#rocketLevel
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void dualRocketUp(Ship ship, int timer, int frequency) {
		if (timer % (3 * frequency) == 0) {
			add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18 - 30, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18 + 30, ship.getY() + ship.getHeight() / 2.5, 0));
		}
	}

	/**
	 * A utility method that activates <code>rocketLevel</code> 3.
	 * <p>
	 * The specified number of rockets are shot from the <code>ship</code>'s
	 * location based on the <code>frequency</code> registered using a
	 * <code>timer</code> in the <code>LevelManager</code> class.
	 * 
	 * @param ship
	 * @param timer
	 * @param frequency
	 * @see Rocket
	 * @see LevelManager
	 * @see LevelManager#rocketLevel
	 * @see LevelManager#timer
	 * @see LevelManager#frequency
	 * @see Ship
	 */
	public void triRocketUp(Ship ship, int timer, int frequency) {
		if (timer % (3 * frequency) == 0) {
			add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18 - 30, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18, ship.getY() + ship.getHeight() / 2.5, 0));
			add(new Rocket(ship.getX() + ship.getWidth() / 2 - 18 + 30, ship.getY() + ship.getHeight() / 2.5, 0));
		}
	}

	public void laser(Ship ship) {
		add(new Laser(ship.getX() + ship.getWidth() / 2 - 32, ship.getY() - ship.getHeight() / 4, 0));
	}

	public void add(Ammo a) {
		magazine.add(a);
	}

	public void update(Animations animations, Ship ship, HUD skills) {
		for (Iterator<Ammo> iter = magazine.iterator(); iter.hasNext();) {
			Ammo a = iter.next();
			if (a instanceof Laser && skills.isUsingSkill()) a.update(ship);
			else a.update();

			if (a.isLanded()) {
				if (a instanceof Bullet) animations.pinkHit(a.getX(), a.getY(), a.getWidth(), a.getHeight());
				else if (a instanceof Rocket) animations.orangeHit(a.getX(), a.getY(), a.getWidth(), a.getHeight());
				else if (a instanceof Laser) animations.laserHit(a.getX(), a.getY(), a.getWidth(), a.getHeight());
				iter.remove();
			}

			// remove off-screen bullets
			else if (a.getX() + a.getWidth() < 0 || a.getX() > Reference.WIDTH || a.getY() + a.getHeight() < 0
					|| a.getY() > Reference.HEIGHT)
				iter.remove();
		}
	}

	public void render(Graphics2D g) {
		for (Ammo a : magazine)
			a.render(g);
	}

	public List<Ammo> getMagazine() {
		return magazine;
	}

	public String toString() {
		return Arrays.toString(magazine.toArray());
	}
}
