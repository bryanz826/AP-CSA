package com.state;

import java.awt.Graphics2D;

import com.main.GamePanel;
import com.text.Text;
import com.utils.Keys;
import com.utils.Reference;
import com.utils.Resource;

public class Menu implements State
{
	private Resource	bg;
	private Resource	title;
	private Resource	selectLeft;
	private Resource	selectRight;

//	private ModelShip	ship; // 35 53
//	private ModelAlien	alien;

	private int			currentOption	= 0;
	private String[]	options			= { "START", "QUIT", "TOGGLE FPS" };

	private boolean		anim1;
	private boolean		anim2;
	private boolean		anim3;
	private boolean		anim4;

	private boolean		alienBullet;
	private float		bulletX;
	private float		bulletY;

	@Override
	public void init() {
		bg = new Resource(Reference.STATE_LOC + "space_menu.jpg");
		title = new Resource(Reference.FONT_LOC + "starfighter.png");
		selectLeft = new Resource(Reference.STATE_LOC + "selection_left.png");
		selectRight = new Resource(Reference.STATE_LOC + "selection_right.png");
	}

	@Override
	public void enter() {
//		ship = new ModelShip(Reference.CENTER_X, Reference.HEIGHT, -10, -3);

		anim1 = true;
		anim2 = false;
		anim3 = false;
		anim4 = false;
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processInput() {
		if (Keys.wasPressed(Keys.UP)) {
			if (--currentOption < 0) currentOption = options.length - 1;
		}
		if (Keys.wasPressed(Keys.DOWN)) {
			if (++currentOption >= options.length) currentOption = 0;
		}

		if (Keys.wasPressed(Keys.ENTER)) {
			selectOption();
		}
	}

	@Override
	public void update() {
		updateBackground();
	}

	@Override
	public void render(Graphics2D g) {
		renderBackground(g);

		title.render(g, Reference.CENTER_X - 385, 240);

		// draw buttons
		new Text(options[0], Reference.CENTER_X - 110, Reference.CENTER_Y + 50, 0.85f).drawString(g);
		new Text(options[1], Reference.CENTER_X - 93, Reference.CENTER_Y + 150, 0.85f).drawString(g);
		new Text(options[2], Reference.WIDTH - 350, Reference.HEIGHT - 100, 0.53f).drawString(g);

		// draw selection
		if (currentOption == 0) {
			selectLeft.render(g, Reference.CENTER_X - 180, Reference.CENTER_Y + 48, 50, 50);
			selectRight.render(g, Reference.CENTER_X + 117, Reference.CENTER_Y + 48, 50, 50);
		} else if (currentOption == 1) {
			selectLeft.render(g, Reference.CENTER_X - 160, Reference.CENTER_Y + 148, 50, 50);
			selectRight.render(g, Reference.CENTER_X + 97, Reference.CENTER_Y + 148, 50, 50);
		} else if (currentOption == 2) {
			selectLeft.render(g, Reference.WIDTH - 400, Reference.HEIGHT - 102, 30, 30);
			selectRight.render(g, Reference.WIDTH - 65, Reference.HEIGHT - 102, 30, 30);
		}
	}

	private void updateBackground() {
//		// background animation
//		if (anim1) {
//			// handle ship
//			if (ship.getX() + 16 <= Reference.CENTER_X) {
//				ship.ddx(0.14);
//			} else if (ship.getX() > Reference.CENTER_X) {
//				ship.ddx(-0.09);
//			}
//
//			ship.update();
//
//			// check offscreen
//			if (ship.getY() < -160) {
//				anim1 = false;
//
//				ship.setX(450);
//				ship.setY(Reference.HEIGHT);
//				ship.setDx(0);
//				ship.setDy(-2.5);
//
//				alien = new ModelAlien(0, 0, 3, 3);
//
//				anim2 = true;
//			}
//		} else if (anim2) {
//			// handle ship
//			if (ship.getY() <= Reference.CENTER_Y) {
//				ship.ddx(-0.05);
//			}
//
//			// handle alien
//			alien.ddx(-0.035);
//			alien.ddy(-0.035);
//
//			ship.update();
//			alien.update();
//
//			// check offscreen
//			if (ship.getX() < -100) {
//				anim2 = false;
//
//				ship.setX(50);
//				ship.setY(Reference.HEIGHT);
//				ship.setDx(0);
//				ship.setDy(-1.7);
//
//				alien.setX(20);
//				alien.setY(-90);
//				alien.setWidth(85);
//				alien.setHeight(85);
//				alien.setDx(0);
//				alien.setDy(0);
//
//				anim3 = true;
//			}
//		} else if (anim3) {
//
//			// handle ship
//			if (ship.getY() < 510 && ship.getY() > 420) {// slow down
//				ship.ddx(0.02);
//				ship.ddy(0.009);
//				if (ship.getX() > 74 && ship.getX() <= 76) {
//					alien.setDx(1);
//					alien.setDy(3.5);
//				} else if (ship.getX() > 90 && ship.getX() < 91) {
//					bulletX = alien.getX() + alien.getWidth() / 2;
//					bulletY = alien.getY() + alien.getHeight() / 1.4;
//					alienBullet = true;
//				}
//			} else if (alien.getY() >= 92) { // run away
//				ship.setImage(Reference.ENTITY_LOC + "runaway_ship.png");
//				ship.ddx(0.5);
//				ship.ddy(5);
//			} else if (ship.getY() <= 420) { // move slowly
//				ship.setDx(0.05);
//				ship.setDy(-0.01);
//			}
//
//			// handle alien
//			if (ship.getX() > 80) {
//				alien.ddx(-0.01);
//				alien.ddy(0.01);
//				if (alien.getY() > 170) {
//					alien.ddy(0.5);
//				}
//			}
//
//			ship.update();
//			alien.update();
//
//			if (alien.getY() > Reference.HEIGHT + 1000) {
//				anim3 = false;
//
//				ship.setX(1077);
//				ship.setY(-20);
//				ship.setDx(0);
//				ship.setDy(10);
//
//				alien.setX(1077);
//				alien.setY(-90);
//				alien.setDx(0);
//				alien.setDy(0);
//
//				anim4 = true;
//			}
//		} else if (anim4) {
//
//			// handle ship
//			if (ship.getY() <= 322) {
//				ship.ddy(-0.135);
//			} else if (ship.getY() > 322 && ship.getY() <= 345) {
//				ship.setDy(0.3);
//			} else if (ship.getY() > 345 && ship.getY() <= 355) {
//				ship.setImage(Reference.ENTITY_LOC + "ship.png");
//				ship.setDy(0.15);
//				ship.setDx(0.15);
//			} else if (ship.getY() > 355) {
//				ship.ddy(4);
//			} else if (ship.getY() > 8000) {
//				ship.setDy(0);
//			}
//
//			// handle alien
//			if (ship.getY() > 320 && ship.getY() <= Reference.HEIGHT + 500) {
//				alien.setDy(1);
//				if (alien.getX() + alien.getWidth() / 2 > ship.getX() + ship.getWidth() / 2) {
//					alien.ddx(-0.2);
//				} else {
//					alien.ddx(0.2);
//				}
//			} else if (ship.getY() > Reference.HEIGHT + 3000 && ship.getY() < Reference.HEIGHT + 5000) {
//				alien.setDx(0);
//				alien.setDy(0.1);
//			} else if (alien.getY() > 83) {
//				alien.setImage(Reference.ENTITY_LOC + "walkaway_alien.png");
//				alien.ddy(-0.1);
//			}
//
//			ship.update();
//			alien.update();
//
//			if (alien.getY() < -250) {
//				anim4 = false;
//
//				ship.setImage(Reference.ENTITY_LOC + "ship.png");
//				ship.setX(Reference.CENTER_X);
//				ship.setY(Reference.HEIGHT);
//				ship.setDx(-5);
//				ship.setDy(-3);
//				alien = null;
//
//				anim1 = true;
//			}
//		}
	}

	private void renderBackground(Graphics2D g) {
		bg.render(g, 0, 0, Reference.WIDTH, Reference.HEIGHT);

//		if (anim2 || anim3 || anim4) alien.render(g);
//		if (anim3 && alienBullet) {
//			g.setColor(Color.YELLOW);
//			g.fillOval((int) (bulletX), (int) (bulletY += 8), 5, 15);
//			if (bulletY > Reference.HEIGHT) alienBullet = false;
//		}
//		ship.render(g);
	}

	private void selectOption() {
		if (currentOption == 0) {
			Play.start();
			States.setState("LEVEL00");
		}
		if (currentOption == 1) {
			GamePanel.setRunning(false);
		}
		if (currentOption == 2) {
			if (GamePanel.getShowFPS()) GamePanel.setShowFPS(false);
			else GamePanel.setShowFPS(true);
		}
	}

	@Override
	public String getName() {
		return "MENU";
	}
}
