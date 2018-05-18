package com.entities.aliens;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.entities.aliens.missiles.Blue;
import com.entities.aliens.missiles.Green;
import com.entities.aliens.missiles.Missile;
import com.entities.aliens.missiles.Orange;
import com.entities.aliens.missiles.Red;
import com.entities.aliens.missiles.Yellow;
import com.utils.Reference;

public class Storage
{
	private List<Missile> storage;

	public Storage()
	{
		storage = new ArrayList<Missile>();
	}

	public boolean reArm(Alien alien) {
		return alien.getTick() % (alien.getFrequency()) == 0;
	}

	public void redMissile(Alien a, int timer) {
		if (reArm(a)) {
			int rand = (int) (Math.random() * 360);
			add(new Red(a.getX() + a.getWidth() / 2, a.getY() + a.getHeight() / 2, rand));
		}
	}

	public void orangeMissile(Alien a, int timer) {
		if (reArm(a)) {
			int rand = (int) (Math.random() * 360);
			add(new Orange(a.getX() + a.getWidth() / 2, a.getY() + a.getHeight() / 2, rand));
		}
	}

	public void yellowMissile(Alien a, int timer) {
		if (reArm(a)) {
			int rand = (int) (Math.random() * 360);
			add(new Yellow(a.getX() + a.getWidth() / 2, a.getY() + a.getHeight() / 2, rand));
		}
	}

	public void blueMissile(Alien a, int timer) {
		if (reArm(a)) {
			int rand = (int) (Math.random() * 360);
			add(new Blue(a.getX() + a.getWidth() / 2, a.getY() + a.getHeight() / 2, rand));
		}
	}

	public void greenMissile(Alien a, int timer) {
		if (reArm(a)) {
			int rand = (int) (Math.random() * 360);
			add(new Green(a.getX() + a.getWidth() / 2, a.getY() + a.getHeight() / 2, rand));
		}
	}

	public void add(Missile m) {
		storage.add(m);
	}

	public void update() {
		for (Iterator<Missile> iter = storage.iterator(); iter.hasNext();) {
			Missile m = iter.next();

			m.update();

			if (m.isLanded()) {
				m.actionOnLanding();
				iter.remove();
			}

			// remove off-screen missiles
			else if (m.getX() + m.getWidth() < 0 || m.getX() > Reference.WIDTH || m.getY() + m.getHeight() < 0
					|| m.getY() > Reference.HEIGHT)
				iter.remove();
		}
	}

	public void render(Graphics2D g) {
		for (Missile m : storage)
			m.render(g);
	}

	public List<Missile> getList() {
		return storage;
	}

	public String toString() {
		return Arrays.toString(storage.toArray());
	}
}
