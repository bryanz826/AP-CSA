
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab   -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde {
	private List<Alien> aliens;
	private int size;
	private int tick;

	public AlienHorde(int size) {
		aliens = new ArrayList<Alien>();
		this.size = size;
	}

	public void add(Alien al) {
		aliens.add(al);
	}

	public void moveEmAll() {
		tick++;
		for (Alien al : aliens) {
			if (tick <= 120)
				al.move("RIGHT");
			else if (tick <= 320)
				al.move("DOWN");
			else if (tick <= 440)
				al.move("LEFT");
			else if (tick <= 640)
				al.move("UP");
			else if (tick <= 1000)
				tick = 0;
		}
	}

	public void drawEmAll(Graphics window) {
		for (Alien al : aliens)
			al.draw(window);
	}

	public List<Alien> getAliens() {
		return aliens;
	}

	public int getSize() {
		return size;
	}

	public String toString() {
		return "";
	}
}
