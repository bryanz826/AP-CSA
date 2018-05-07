package com.entity.mobile.ammo.alien;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.animations.Animations;
import com.entity.mobile.ammo.alien.types.Blue;
import com.entity.mobile.ammo.alien.types.Green;
import com.entity.mobile.ammo.alien.types.Orange;
import com.entity.mobile.ammo.alien.types.Red;
import com.entity.mobile.ammo.alien.types.Yellow;
import com.entity.mobile.live.alien.Alien;

import coc.utils.Reference;

public class Storage
{
	private List<Missile> storage;

	public Storage()
	{
		storage = new ArrayList<Missile>();
	}

	public void redMissile(Alien a, int timer) {
		if (timer % a.getFrequency() == 0) {
			int rand = (int) (Math.random() * 360);
			add(new Red(a.getX() + a.getWidth() / 2, a.getY() + a.getHeight() / 2, rand));
		}
	}

	public void orangeMissile(Alien a, int timer) {
		if (timer % a.getFrequency() == 0) {
			int rand = (int) (Math.random() * 360);
			add(new Orange(a.getX() + a.getWidth() / 2, a.getY() + a.getHeight() / 2, rand));
		}
	}

	public void yellowMissile(Alien a, int timer) {
		if (timer % a.getFrequency() == 0) {
			int rand = (int) (Math.random() * 360);
			add(new Yellow(a.getX() + a.getWidth() / 2, a.getY() + a.getHeight() / 2, rand));
		}
	}

	public void blueMissile(Alien a, int timer) {
		if (timer % a.getFrequency() == 0) {
			int rand = (int) (Math.random() * 360);
			add(new Blue(a.getX() + a.getWidth() / 2, a.getY() + a.getHeight() / 2, rand));
		}
	}

	public void greenMissile(Alien a, int timer) {
		if (timer % a.getFrequency() == 0) {
			int rand = (int) (Math.random() * 360);
			add(new Green(a.getX() + a.getWidth() / 2, a.getY() + a.getHeight() / 2, rand));
		}
	}

	public void add(Missile m) {
		storage.add(m);
	}

	public void update(Animations animations) {
		for (Iterator<Missile> iter = storage.iterator(); iter.hasNext();) {
			Missile m = iter.next();

			m.update();

			if (m.isLanded()) {
				if (m instanceof Red) animations.redHit(m.getX(), m.getY(), m.getWidth(), m.getHeight());
				else if (m instanceof Orange) animations.orangeHit(m.getX(), m.getY(), m.getWidth(), m.getHeight());
				else if (m instanceof Yellow) animations.yellowHit(m.getX(), m.getY(), m.getWidth(), m.getHeight());
				else if (m instanceof Blue) animations.blueHit(m.getX(), m.getY(), m.getWidth(), m.getHeight());
				else if (m instanceof Green) animations.greenHit(m.getX(), m.getY(), m.getWidth(), m.getHeight());
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

	public List<Missile> getStorage() {
		return storage;
	}

	public String toString() {
		return Arrays.toString(storage.toArray());
	}
}
