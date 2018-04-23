
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bullets {
	private List<Ammo> ammo;

	public Bullets() {
		ammo = new ArrayList<Ammo>();
	}

	public void add(Ammo a) {
		ammo.add(a);
	}

	public void moveEmAll() {
		for (Ammo a : ammo)
			a.move("UP");
	}

	public void drawEmAll(Graphics window) {
		for (Ammo a : ammo)
			a.draw(window);
	}

	public void cleanEmUp() {
		for (int i = 0; i < ammo.size(); i++)
			if (ammo.get(i).getY() < 0)
				ammo.remove(i);
	}

	public List<Ammo> getAmmo() {
		return ammo;
	}

	public String toString() {
		return Arrays.toString(ammo.toArray());
	}
}
