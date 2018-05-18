package com.entities.aliens;
//© A+ Computer Science  -  www.apluscompsci.com

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.entities.aliens.types.Boss;
import com.entities.aliens.types.Extreme;
import com.entities.aliens.types.Hard;
import com.entities.aliens.types.Harder;
import com.entities.aliens.types.Mediocre;
import com.entities.aliens.types.Simple;
import com.entities.aliens.types.Tutorial;
import com.utils.Reference;

public class Horde
{
	private List<Alien>	horde;
	private Storage		storage;

	public Horde()
	{
		horde = new ArrayList<Alien>();
		storage = new Storage();
	}

	public void addBoss(float x, float y, int tag) {
		add(new Boss(x, y, 1, 1, tag));
	}

	public void addExtreme(float x, float y, int tick, int interval, int tag) {
		if (tick % interval == 0) addExtreme(x, y, tag);
	}

	public void addExtreme(float x, float y, int tag) {
		add(new Extreme(x, y, 5, 5, tag));
	}

	public void addHarder(float x, float y, int tick, int interval, int tag) {
		if (tick % interval == 0) addHarder(x, y, tag);
	}

	public void addHarder(float x, float y, int tag) {
		add(new Harder(x, y, 5, 5, tag));
	}

	public void addHard(float x, float y, int tick, int interval, int tag) {
		if (tick % interval == 0) addHard(x, y, tag);
	}

	public void addHard(float x, float y, int tag) {
		add(new Hard(x, y, 5, 5, tag));
	}

	public void addMediocre(float x, float y, int tick, int interval, int tag) {
		if (tick % interval == 0) addMediocre(x, y, tag);
	}

	public void addMediocre(float x, float y, int tag) {
		add(new Mediocre(x, y, 5, 5, tag));
	}

	public void addSimple(float x, float y, int tick, int interval, int tag) {
		if (tick % interval == 0) addSimple(x, y, tag);
	}

	public void addSimple(float x, float y, int tag) {
		add(new Simple(x, y, 5, 5, tag));
	}

	public void addTutorial(float x, float y, int tick, int interval, int tag) {
		if (tick % interval == 0) addTutorial(x, y, tag);
	}

	public void addTutorial(float x, float y, int tag) {
		add(new Tutorial(x, y, 3, 3, tag));
	}

	public void swivelHorde(int moveEndTime, int tag) {
		boolean first = true;
		for (Alien a : horde) {
			if (a.getTag() == tag) {
				if (a.getTick() <= moveEndTime && first) {
					a.swivel();
					a.accelPosY();
					if (a.getDy() > 2) a.setDy(2);
				} else {
					first = false;
					a.accelPosY();
					if (a.getDx() > 0) a.decelPosX();
					else if (a.getDx() < 0) a.decelNegX();
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
						a.accel(directionX);
						a.decel(directionY);
					} else {
						a.accel(directionX);
						a.accel(directionY);
					}
				} else {
					first = false;
					a.decel(directionX);
					a.decel(directionY);
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
						a.accel(directionX);
						a.decel(directionY);
					} else {
						a.decel(directionX);
						a.accel(directionY);
					}
				} else {
					first = false;
					a.decel(directionX);
					a.decel(directionY);
				}
			}
		}
	}

	public void moveHordeSmoothly(int moveEndTime, String directionX, String directionY, int tag) {
		boolean first = true;
		for (Alien a : horde) {
			if (a.getTag() == tag) {
				if (a.getTick() <= moveEndTime && first) {
					a.accel(directionX);
					a.accel(directionY);
				} else {
					first = false;
					a.decel(directionX);
					a.decel(directionY);
				}
			}
		}
	}

	public void slowDownHorde(String directionX, String directionY, int tag) {
		for (Alien a : horde) {
			if (a.getTag() == tag) {
				a.decel(directionX);
				a.decel(directionY);
			}
		}
	}

	public void doNothing() {
		for (Alien a : horde) {
			a.still();
		}
	}

	public void add(Alien al) {
		horde.add(al);
	}

	public boolean checkForType(String str) {
		str = str.toUpperCase();
		for (Alien alien : horde) {
			if (alien.getName().toUpperCase().equals(str)) return true;
		}
		return false;
	}

	public void update() {
		for (Iterator<Alien> iter = horde.iterator(); iter.hasNext();) {
			Alien al = iter.next();

			al.update();
			al.shoot(storage);

			if (al.isDead()) {
				al.actionOnDeath();
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

	public List<Alien> getList() {
		return horde;
	}

	public String toString() {
		return Arrays.toString(horde.toArray());
	}
}
