package com.entity.mobile.live.alien;
//© A+ Computer Science  -  www.apluscompsci.com

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.animations.Animations;
import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.live.alien.types.Boss;
import com.entity.mobile.live.alien.types.Extreme;
import com.entity.mobile.live.alien.types.Hard;
import com.entity.mobile.live.alien.types.Harder;
import com.entity.mobile.live.alien.types.Mediocre;
import com.entity.mobile.live.alien.types.Simple;
import com.entity.mobile.live.alien.types.Tutorial;
import com.entity.mobile.powerups.PowerUps;
import com.state.levels.LevelManager;
import com.utils.Reference;

public class AlienHorde
{
	private List<Alien> horde;

	public AlienHorde()
	{
		horde = new ArrayList<Alien>();
	}

	public void addBoss(double x, double y, int tag) {
		add(new Boss(x, y, 1, 1, tag));
	}

	public void addExtreme(double x, double y, int tick, int interval, int tag) {
		if (tick % interval == 0) addExtreme(x, y, tag);
	}

	public void addExtreme(double x, double y, int tag) {
		add(new Extreme(x, y, 5, 5, tag));
	}

	public void addHarder(double x, double y, int tick, int interval, int tag) {
		if (tick % interval == 0) addHarder(x, y, tag);
	}

	public void addHarder(double x, double y, int tag) {
		add(new Harder(x, y, 5, 5, tag));
	}

	public void addHard(double x, double y, int tick, int interval, int tag) {
		if (tick % interval == 0) addHard(x, y, tag);
	}

	public void addHard(double x, double y, int tag) {
		add(new Hard(x, y, 5, 5, tag));
	}

	public void addMediocre(double x, double y, int tick, int interval, int tag) {
		if (tick % interval == 0) addMediocre(x, y, tag);
	}

	public void addMediocre(double x, double y, int tag) {
		add(new Mediocre(x, y, 5, 5, tag));
	}

	public void addSimple(double x, double y, int tick, int interval, int tag) {
		if (tick % interval == 0) addSimple(x, y, tag);
	}

	public void addSimple(double x, double y, int tag) {
		add(new Simple(x, y, 5, 5, tag));
	}

	public void addTutorial(double x, double y, int tick, int interval, int tag) {
		if (tick % interval == 0) addTutorial(x, y, tag);
	}

	public void addTutorial(double x, double y, int tag) {
		add(new Tutorial(x, y, 3, 3, tag));
	}
	
	public void swivelHorde(int moveEndTime, double accel, int tag) {
		boolean first = true;
		for (Alien a : horde) {
			if (a.getTag() == tag) {
				if (a.getTick() <= moveEndTime && first) {
					a.swivel(accel);
					a.speedUp("DOWN", 0.05);
					if (a.getDy() > 2) a.setDy(2);
				} else {
					first = false;
					a.slowDown("DOWN", 0.25);
					if (a.getDx() > 0) a.slowDown("RIGHT", 0.25);
					else if (a.getDx() < 0) a.slowDown("LEFT", 0.25);
				}
			}
		}
	}
	
	public void diagonalHorde(int moveEndTime, String directionX, String directionY, int tag) {
		boolean first = true;
		for (Alien a : horde) {
			if (a.getTag() == tag) {
				if (a.getTick() <= moveEndTime && first) {
					if (a.getTick() <= moveEndTime / 2) {
						a.speedUp(directionX, 0.05);
						a.slowDown(directionY, 0.05);
					}
					else {
						a.speedUp(directionX, 0.05);
						a.speedUp(directionY, 0.2);
					}
				} else {
					first = false;
					a.slowDown(directionX, 0.25);
					a.slowDown(directionY, 0.25);
				}
			}
		}
	}
	
	public void curveHordeWeirdly(int moveEndTime, String directionX, String directionY, int tag) {
		boolean first = true;
		for (Alien a : horde) {
			if (a.getTag() == tag) {
				if (a.getTick() <= moveEndTime && first) {
					if (a.getTick() <= moveEndTime / 2) {
						a.speedUp(directionX, 0.05);
						a.slowDown(directionY, 0.05);
					}
					else {
						a.slowDown(directionX, 0.05);
						a.speedUp(directionY, 0.05);
					}
				} else {
					first = false;
					a.slowDown(directionX, 0.25);
					a.slowDown(directionY, 0.25);
				}
			}
		}
	}

	public void moveHordeAbruptly(int moveEndTime, String direction, int tag) {
		boolean first = true;
		for (Alien a : horde) {
			if (a.getTag() == tag) {
				if (a.getTick() <= moveEndTime && first) {
					a.start(direction, 1);
				} else {
					first = false;
					a.endX();
					a.endY();
				}
			}
		}
	}

	public void moveHordeSmoothly(int moveEndTime, String direction, double accel, int tag) {
		boolean first = true;
		for (Alien a : horde) {
			if (a.getTag() == tag) {
				if (a.getTick() <= moveEndTime && first) {
					a.speedUp(direction, accel);
				} else {
					first = false;
					a.slowDown(direction, accel);
				}
			}
		}
	}
	
	public void slowDownHorde(String directionX, String directionY, int tag) {
		for (Alien a : horde) {
			if (a.getTag() == tag) {
				a.slowDown(directionX, 0.2);
				a.slowDown(directionY, 0.2);
			}
		}
	}

	public void add(Alien al) {
		horde.add(al);
	}

	public boolean checkForTypeMissing(String str) {
		str = str.toUpperCase();
		for (Alien alien : horde) {
			if (alien.getName().toUpperCase().equals(str)) return false;
		}
		return true;
	}

	public void update(LevelManager lm, Animations animations, PowerUps powerups, Storage storage, int timer) {
		for (Iterator<Alien> iter = horde.iterator(); iter.hasNext();) {
			Alien al = iter.next();

			al.update();
			al.shoot(storage, timer);

			if (al.checkDeath() && !(al instanceof Tutorial && al instanceof Boss)) {
				double rand = Math.random();
				if (rand <= 0.015) powerups.addHealthUp(al.getX() + al.getWidth() / 2, al.getY() + al.getHeight() / 2);
				else if (rand <= 0.030)
					powerups.addRateUp(al.getX() + al.getWidth() / 2, al.getY() + al.getHeight() / 2);
				else if (rand <= 0.040)
					powerups.addRocketUp(al.getX() + al.getWidth() / 2, al.getY() + al.getHeight() / 2);
				else if (rand <= 0.050)
					powerups.addLaserUp(al.getX() + al.getWidth() / 2, al.getY() + al.getHeight() / 2);
				else if (rand <= 0.075)
					powerups.addBulletUp(al.getX() + al.getWidth() / 2, al.getY() + al.getHeight() / 2);
				else if (rand <= 0.078 && lm.getBulletLevel() == 7)
					powerups.addLegendaryUp(al.getX() + al.getWidth() / 2, al.getY() + al.getHeight() / 2);

				if (!lm.isShipDead()) {
					lm.incScore(al.getPoints());
				}

				animations.explode(al.getX(), al.getY(), al.getWidth(), al.getHeight());

				iter.remove();
			}

			// remove off-screen aliens
			else if (al.getX() + al.getWidth() < -250 || al.getX() > Reference.WIDTH + 250
					|| al.getY() + al.getHeight() < -250 || al.getY() > Reference.HEIGHT + 250)
				iter.remove();
		}

	}

	public void render(Graphics2D g) {
		for (Alien al : horde)
			al.render(g);
	}

	public List<Alien> getHorde() {
		return horde;
	}

	public String toString() {
		return Arrays.toString(horde.toArray());
	}
}
