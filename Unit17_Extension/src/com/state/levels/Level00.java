package com.state.levels;

import java.awt.Graphics2D;

import com.manager.Text;
import com.state.State;
import com.state.States;
import com.utils.Reference;
import com.utils.Resource;

public class Level00 extends LevelManager implements State
{
	private boolean	pickItUp;
	private boolean	goThru;

	@Override
	public void init() {
		bg = new Resource(Reference.LEVEL_LOC + "level00.jpg");
	}

	@Override
	public void enter() {
		super.enter();
		pickItUp = false;
		goThru = false;
	}

	@Override
	public void processInput(States sm) {
		super.processInput(sm);
	}

	@Override
	public void update(States sm) {
		if (wave == 0) {
			if (tick == 50) {
				powerups.addBulletUp(Reference.CENTER_X, Reference.CENTER_Y - 100);
			} else if (tick > 50) {
				if (powerups.getPowerups().size() == 0) {
					if (bulletLevel == 1) {
						tick = 0;
						wave++;
					} else {
						powerups.addBulletUp(Reference.CENTER_X, Reference.CENTER_Y - 100);
						pickItUp = true;
					}
				}
			}
		} else if (wave == 1) {
			pickItUp = false;
			if (tick <= 120) {
				horde.addTutorial(Reference.WIDTH + 50, 100, tick, 30, 1654);
				horde.addTutorial(-50, 100, tick, 30, 14894);
			}

			if (tick <= 350) {
				horde.curveHordeWeirdly(800, "LEFT", "DOWN", 1654);
				horde.curveHordeWeirdly(800, "RIGHT", "DOWN", 14894);
			} else if (tick <= 600) {
				horde.slowDownHorde("LEFT", "DOWN", 1654);
				horde.slowDownHorde("RIGHT", "DOWN", 14894);
			}

			if (tick >= 40) {
				if (horde.checkForTypeMissing("TUTORIAL")) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 2) {
			if (++tick == 100) {
				ship.setPass(true);
				goThru = true;
			}
		}

		if (ship.getY() < 0) {
			ship.setPass(false);
			sm.setState("LEVEL01");
			ship.setY(Reference.HEIGHT);
		}

		super.update(sm);
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		if (pickItUp) new Text("PICK IT UP", Reference.CENTER_X - 250, Reference.CENTER_Y - 200).drawString(g);
		if (goThru) new Text("ENTER THE PORTAL TO THE NEXT LEVEL", 80, Reference.CENTER_Y - 175, 0.7).drawString(g);
	}

	@Override
	public String getName() {
		return "LEVEL00";
	}

}
