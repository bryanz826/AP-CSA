package com.state.levels;

import com.state.State;
import com.state.States;
import com.utils.Reference;
import com.utils.Resource;

public class Level05 extends LevelManager implements State
{
	@Override
	public void init() {
		bg = new Resource(Reference.LEVEL_LOC + "level05.jpg");
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
		} else if (wave == 4) {
			if (tick >= 100) {
				if (tick <= 180) {
					horde.addExtreme(Reference.WIDTH + 50, 200, tick, 20, 4626);
					horde.addExtreme(-50, 300, tick, 20, 2646);
				}

				horde.moveHordeSmoothly(186, "LEFT", 0.25, 4626); // 5
				horde.moveHordeSmoothly(185, "RIGHT", 0.25, 2646); // 5

				if (horde.checkForTypeMissing("EXTREME")) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 3) {
			if (tick >= 100) {
				if (tick <= 175) {
					horde.addExtreme(Reference.WIDTH + 50, 100, tick, 25, 7525);
					horde.addExtreme(-50, 100, tick, 25, 752752);
				}

				if (tick <= 300) {
					horde.moveHordeSmoothly(175, "LEFT", 0.25, 7525); // 5
					horde.moveHordeSmoothly(175, "RIGHT", 0.25, 752752); // 5
				} else if (tick <= 400) {
					horde.curveHordeWeirdly(100, "LEFT", "DOWN", 7525);
					horde.curveHordeWeirdly(100, "RIGHT", "DOWN", 752752);
				}

				if (horde.checkForTypeMissing("EXTREME")) {
					tick = 0;
					wave++;
				}
			}

		} else if (wave == 2) {
			if (tick >= 100) {
				if (tick <= 175) {
					horde.addExtreme(Reference.WIDTH + 50, 100, tick, 25, 7525);
					horde.addExtreme(-50, 200, tick, 25, 752752);
					horde.addExtreme(Reference.WIDTH + 50, 300, tick, 25, 7525);
					horde.addExtreme(-50, 400, tick, 25, 752752);
				}

				horde.moveHordeSmoothly(175, "LEFT", 0.25, 7525); // 5
				horde.moveHordeSmoothly(175, "RIGHT", 0.25, 752752); // 5

				if (horde.checkForTypeMissing("EXTREME")) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 5) {
			if (tick >= 100) {
				if (tick <= 180) {
					horde.addExtreme(Reference.WIDTH + 50, 250, tick, 20, 321);
					horde.addExtreme(-50, 250, tick, 20, 216);
				} else if (tick <= 260) {
					horde.addExtreme(Reference.WIDTH + 50, 420, tick, 20, 78);
					horde.addExtreme(-50, 420, tick, 20, 7789);
				}

				horde.diagonalHorde(300, "LEFT", "DOWN", 321);
				horde.diagonalHorde(300, "RIGHT", "DOWN", 216);
				horde.diagonalHorde(300, "LEFT", "UP", 78);
				horde.diagonalHorde(300, "RIGHT", "UP", 7789); // 8

				if (horde.checkForTypeMissing("EXTREME")) {
					tick = 0;
					wave++;
				}
			}

		} else if (wave == 1) {
			if (tick >= 100) {
				if (tick <= 180) {
					horde.addExtreme(Reference.WIDTH / 4, -50, tick, 20, 3243);
					horde.addExtreme(Reference.WIDTH / 2, -50, tick, 20, 3243);
					horde.addExtreme(Reference.WIDTH * 3 / 4, -50, tick, 20, 3243); // 15
				}

				horde.moveHordeSmoothly(100, "DOWN", 0.25, 3243);

				if (horde.checkForTypeMissing("EXTREME")) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 6) {
			if (++tick == 100) ship.setPass(true);
		}
		
		if (ship.getY() < 0) {
			ship.setPass(false);
			sm.setState("LEVEL06");
			ship.setY(Reference.HEIGHT);
		}

		super.update(sm);
	}
	
	@Override
	public String getName() {
		return "LEVEL05";
	}

}
