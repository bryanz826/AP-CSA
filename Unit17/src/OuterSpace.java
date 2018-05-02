
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * 
 * CROP alien.JPG and ship.jpg AS SMALL AS YOU CAN WITHOUT DAMAGING PICTURE FOR
 * OPTIMAL COLLISIONS
 *
 */

@SuppressWarnings("serial")
public class OuterSpace extends Canvas implements KeyListener, Runnable
{

	private Ship			ship;
	private Bullets			shots;

	private int				tick;

	private AlienHorde		horde;
	private boolean[]		keys;
	private BufferedImage	back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		ship = new Ship(400, 500, 35, 35, 2);

		int hordeWidth = 7;
		int hordeHeight = 4;
		int hordeSize = hordeWidth * hordeHeight;

		horde = new AlienHorde(hordeSize);
		shots = new Bullets();

		for (int x = 8; x < StarFighter.WIDTH - 100; x += (StarFighter.WIDTH) / 8)
			for (int y = 22; y < StarFighter.HEIGHT / 1.5; y += (StarFighter.HEIGHT / 1.5) / 4)
				horde.add(new Alien(x + 20, y, 25, 25, 1));

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		Graphics2D twoDGraph = (Graphics2D) window;
		if (back == null) back = (BufferedImage) (createImage(getWidth(), getHeight()));
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50);
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0, 0, 800, 600);

		tick++;

		// processInput
		if (keys[0] == true) {
			ship.move("LEFT");
		}
		if (keys[1] == true) {
			ship.move("RIGHT");
		}
		if (keys[2] == true) {
			ship.move("UP");
		}
		if (keys[3] == true) {
			ship.move("DOWN");
		}
		if (keys[4] == true) {
			if (tick >= 70) {
				shots.add(new Ammo(ship.getX() + ship.getWidth() / 2 - 2, ship.getY(), 5));
				tick = 0;
			}
		}

		// update

		// check collision between ammo and alienhorde
		for (int i = 0; i < shots.getAmmo().size(); i++)
			for (int j = 0; j < horde.getAliens().size(); j++)
				try {
					if (shots.getAmmo().get(i).isColliding(horde.getAliens().get(j))) {
						shots.getAmmo().remove(i--);
						horde.getAliens().remove(j--);
					}
				} catch (Exception e) {}

		// check collision between ship and alienhorde
		for (int i = 0; i < horde.getAliens().size(); i++)
			if (ship.isColliding(horde.getAliens().get(i))) {
				System.out.println("You lose.");
				System.exit(0);
			}

		horde.moveEmAll();
		shots.moveEmAll();
		shots.cleanEmUp();

		if (horde.getSize() == 0) {
			System.out.println("You win!");
			System.exit(0);
		}

		// render
		graphToBack.setColor(Color.WHITE);
		ship.draw(graphToBack);
		shots.drawEmAll(graphToBack);
		horde.drawEmAll(graphToBack);

		// draw back image
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) { // I used 'a' because space is buggy for no reason
			keys[4] = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) { // I used 'a' because space is buggy (try it)
			keys[4] = false;
		}
	}

	public void keyTyped(KeyEvent e) {}

	public void run() {
		try {
			while (true) {
				Thread.currentThread();
				Thread.sleep(5);
				repaint();
			}
		} catch (Exception e) {}
	}
}
