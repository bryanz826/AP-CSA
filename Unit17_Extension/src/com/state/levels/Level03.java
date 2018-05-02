package com.state.levels;

import com.state.State;
import com.state.States;
import com.utils.Reference;
import com.utils.Resource;

public class Level03 extends LevelManager implements State
{
	@Override
	public void init() {
		bg = new Resource(Reference.LEVEL_LOC + "level03.jpg");
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
		} else if (wave == 2) {
			if (tick >= 100) {
				if (tick <= 180) {
					horde.addHard(Reference.WIDTH + 50, 200, tick, 20, 4626);
					horde.addHard(-50, 300, tick, 20, 2646);
				}

				horde.moveHordeSmoothly(186, "LEFT", 0.25, 4626); // 5
				horde.moveHordeSmoothly(185, "RIGHT", 0.25, 2646); // 5

				if (horde.checkForTypeMissing("HARD")) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 4) {
			if (tick >= 100) {
				if (tick <= 175) {
					horde.addHard(Reference.WIDTH + 50, 100, tick, 25, 7525);
					horde.addHard(-50, 100, tick, 25, 752752);
				}

				if (tick <= 300) {
					horde.moveHordeSmoothly(175, "LEFT", 0.25, 7525); // 5
					horde.moveHordeSmoothly(175, "RIGHT", 0.25, 752752); // 5
				} else if (tick <= 400) {
					horde.curveHordeWeirdly(100, "LEFT", "DOWN", 7525);
					horde.curveHordeWeirdly(100, "RIGHT", "DOWN", 752752);
				}

				if (horde.checkForTypeMissing("HARD")) {
					tick = 0;
					wave++;
				}
			}

		} else if (wave == 5) {
			if (tick >= 100) {
				if (tick <= 180) {
					horde.addHard(Reference.WIDTH + 50, 250, tick, 20, 321);
					horde.addHard(-50, 250, tick, 20, 216);
				} else if (tick <= 260) {
					horde.addHard(Reference.WIDTH + 50, 420, tick, 20, 78);
					horde.addHard(-50, 420, tick, 20, 7789);
				}

				horde.diagonalHorde(300, "LEFT", "DOWN", 321);
				horde.diagonalHorde(300, "RIGHT", "DOWN", 216);
				horde.diagonalHorde(300, "LEFT", "UP", 78);
				horde.diagonalHorde(300, "RIGHT", "UP", 7789); // 8

				if (horde.checkForTypeMissing("HARD")) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 1) {

			if (tick >= 100) {
				if (tick == 105) horde.addHard(300, -50, 1);
				if (tick == 110) horde.addHard(254, -50, 1);
				if (tick == 118) horde.addHard(1000, -50, 1);
				if (tick == 116) horde.addHard(800, -50, 1);
				if (tick == 118) horde.addHard(100, -50, 1);
				if (tick == 120) horde.addHard(670, -50, 1);
				if (tick == 120) horde.addHard(570, -50, 1);
				if (tick == 108) horde.addHard(820, -50, 1);
				if (tick == 130) horde.addHard(438, -50, 1);
				if (tick == 131) horde.addHard(1220, -50, 1); // 10

				horde.swivelHorde(200, 0.25, 1);

				if (horde.checkForTypeMissing("HARD") && tick >= 131) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 3) {
			if (tick >= 100) {
				if (tick <= 180) {
					horde.addHard(Reference.WIDTH / 4, -50, tick, 20, 3243);
					horde.addHard(Reference.WIDTH / 2, -50, tick, 20, 3243);
					horde.addHard(Reference.WIDTH * 3 / 4, -50, tick, 20, 3243); // 15
				}

				horde.moveHordeSmoothly(100, "DOWN", 0.25, 3243);

				if (horde.checkForTypeMissing("HARD")) {
					tick = 0;
					wave++;
				}
			}
		} else if (wave == 6) {
			if (++tick == 100) ship.setPass(true);
		}
		
		if (ship.getY() < 0) {
			ship.setPass(false);
			sm.setState("LEVEL04");
			ship.setY(Reference.HEIGHT);
		}

		super.update(sm);
	}
	
	@Override
	public String getName() {
		return "LEVEL03";
	}

}
