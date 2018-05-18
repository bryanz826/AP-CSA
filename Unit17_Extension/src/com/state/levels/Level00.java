package com.state.levels;

import java.awt.Graphics2D;

import com.state.Play;
import com.state.State;
import com.state.States;
import com.text.Text;
import com.utils.Reference;

public class Level00 extends Play implements State
{
	private boolean	pickItUp;
	private boolean	goThru;

	@Override
	public void init() {
		setBg("level00.jpg");
	}

	@Override
	public void enter() {
		super.enter();
		pickItUp = false;
		goThru = false;
	}

	@Override
	public void exit() {}

	@Override
	public void update() {
		if (getWave() == 0) {
			if (getTick() == 50) {
				em.getShip().getPowerups().addBulletUp(Reference.CENTER_X, Reference.CENTER_Y - 100);
			} else if (getTick() > 50) {
				if (em.getShip().getPowerups().getList().size() == 0) {
					if (em.getShip().getMagazine().getBulletLevel() == 1) {
						setTick(0);
						incWave();
					} else {
						em.getShip().getPowerups().addBulletUp(Reference.CENTER_X, Reference.CENTER_Y - 100);
						pickItUp = true;
					}
				}
			}
		} else if (getWave() == 1) {
			if (getTick() <= 120) {
				pickItUp = false;
				em.getHorde().addTutorial(Reference.WIDTH + 50, 100, getTick(), 30, 1654);
				em.getHorde().addTutorial(-50, 100, getTick(), 30, 14894);
			}

			if (getTick() <= 350) {
				em.getHorde().curveHordeWeirdly(800, "LEFT", "DOWN", 1654);
				em.getHorde().curveHordeWeirdly(800, "RIGHT", "DOWN", 14894);
			} else if (getTick() <= 600) {
				em.getHorde().slowDownHorde("LEFT", "DOWN", 1654);
				em.getHorde().slowDownHorde("RIGHT", "DOWN", 14894);
			} else {
				em.getHorde().doNothing();
			}

			if (getTick() >= 40) {
				if (!em.getHorde().checkForType("TUTORIAL")) {
					setTick(0);
					incWave();
				}
			}
		} else if (getWave() == 2) {
			incTick();
			if (getTick() == 100) {
				em.getShip().setAllowedToPass(true);
				goThru = true;
			}
		}

		if (em.getShip().getY() < 0) {
			em.getShip().setAllowedToPass(false);
			States.setState("LEVEL01");
			em.getShip().setY(Reference.HEIGHT);
		}

		super.update();
	}

	@Override
	public void render(Graphics2D g) {
		bg.render(g, 0, 0, Reference.WIDTH, Reference.HEIGHT);
		if (pickItUp) new Text("PICK IT UP", Reference.CENTER_X - 250, Reference.CENTER_Y - 200).drawString(g);
		if (goThru) new Text("ENTER THE PORTAL TO THE NEXT LEVEL", 80, Reference.CENTER_Y - 175, 0.7f).drawString(g);
		em.render(g);
	}

	@Override
	public String getName() {
		return "LEVEL00";
	}
}
