package com.state.levels;

import com.state.State;
import com.state.States;

import coc.utils.Reference;
import coc.utils.Resource;

public class Level02 extends LevelManager implements State
{
	@Override
	public void init() {
		bg = new Resource(Reference.LEVEL_LOC + "level02.jpg");
	}
	
	@Override
	public void update(States sm) {
		
		if (wave == 0) {
			if (tick <= 30) ship.ddy(-0.5);
			else if (tick <= 40) ship.slowPosY(0.25);
			else {
				tick = 0;
				wave++;
			}
		} else if (wave == 1) {
			if (tick >= 100) {
				if (tick <= 180) {
					horde.addMediocre(Reference.WIDTH + 50, 200, tick, 20, 4626);
					horde.addMediocre(-50, 300, tick, 20, 2646);
				}

				horde.moveHordeSmoothly(186, "LEFT", 0.25, 4626); // 5
				horde.moveHordeSmoothly(185, "RIGHT", 0.25, 2646); // 5

				if (horde.checkForTypeMissing("MEDIOCRE")) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 2) {
			if (tick >= 100) {
				if (tick <= 175) {
					horde.addMediocre(Reference.WIDTH + 50, 100, tick, 25, 7525);
					horde.addMediocre(-50, 100, tick, 25, 752752);
				}

				if (tick <= 300) {
					horde.moveHordeSmoothly(175, "LEFT", 0.25, 7525); // 5
					horde.moveHordeSmoothly(175, "RIGHT", 0.25, 752752); // 5
				} else if (tick <= 400) {
					horde.curveHordeWeirdly(100, "LEFT", "DOWN", 7525);
					horde.curveHordeWeirdly(100, "RIGHT", "DOWN", 752752);
				}

				if (horde.checkForTypeMissing("MEDIOCRE")) {
					tick = 0;
					wave++;
				}
			}

		} else if (wave == 3) {
			if (tick >= 100) {
				if (tick <= 175) {
					horde.addMediocre(Reference.WIDTH + 50, 100, tick, 25, 7525);
					horde.addMediocre(-50, 200, tick, 25, 752752);
					horde.addMediocre(Reference.WIDTH + 50, 300, tick, 25, 7525);
					horde.addMediocre(-50, 400, tick, 25, 752752);
				}

				horde.moveHordeSmoothly(175, "LEFT", 0.25, 7525); // 5
				horde.moveHordeSmoothly(175, "RIGHT", 0.25, 752752); // 5

				if (horde.checkForTypeMissing("MEDIOCRE")) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 4) {
			if (tick >= 100) {
				if (tick <= 180) {
					horde.addMediocre(Reference.WIDTH + 50, 250, tick, 20, 321);
					horde.addMediocre(-50, 250, tick, 20, 216);
				} else if (tick <= 260) {
					horde.addMediocre(Reference.WIDTH + 50, 420, tick, 20, 78);
					horde.addMediocre(-50, 420, tick, 20, 7789);
				}

				horde.diagonalHorde(300, "LEFT", "DOWN", 321);
				horde.diagonalHorde(300, "RIGHT", "DOWN", 216);
				horde.diagonalHorde(300, "LEFT", "UP", 78);
				horde.diagonalHorde(300, "RIGHT", "UP", 7789); // 8

				if (horde.checkForTypeMissing("MEDIOCRE")) {
					tick = 0;
					wave++;
				}
			}

		} else if (wave == 5) {
			if (tick >= 100) {
				if (tick <= 180) {
					horde.addMediocre(Reference.WIDTH / 4, -50, tick, 20, 3243);
					horde.addMediocre(Reference.WIDTH / 2, -50, tick, 20, 3243);
					horde.addMediocre(Reference.WIDTH * 3 / 4, -50, tick, 20, 3243); // 15
				}

				horde.moveHordeSmoothly(100, "DOWN", 0.25, 3243);

				if (horde.checkForTypeMissing("MEDIOCRE")) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 6) {
			if (++tick == 100) ship.setPass(true);
		}
		
		if (ship.getY() < 0) {
			ship.setPass(false);
			sm.setState("LEVEL03");
			ship.setY(Reference.HEIGHT);
		}

		super.update(sm);
	}

	@Override
	public String getName() {
		return "LEVEL02";
	}
}
