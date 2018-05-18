package com.state.levels;

import com.state.Play;
import com.state.State;
import com.state.States;
import com.utils.Reference;
import com.utils.Resource;

public class Level01 extends Play implements State
{
	@Override
	public void init() {
		bg = new Resource(Reference.LEVEL_LOC + "level01.jpg");
	}

	@Override
	public void exit() {}

	@Override
	public void update() {
		if (getWave() == 0) {
			if (getTick() <= 30) em.getShip().accelNegY();
			else if (getTick() <= 40) em.getShip().decelNegY();
			else {
				setTick(0);
				incWave();
			}
		} else if (getWave() == 1) {
			if (getTick() >= 100) {
				if (getTick() <= 180) {
					em.getHorde().addSimple(Reference.WIDTH + 50, 200, getTick(), 20, 4626);
					em.getHorde().addSimple(-50, 300, getTick(), 20, 2646);
				}

				em.getHorde().moveHordeSmoothly(186, "LEFT", null, 4626); // 5
				em.getHorde().moveHordeSmoothly(185, "RIGHT", null, 2646); // 5

				if (em.getHorde().checkForType("SIMPLE")) {
					setTick(0);
					incWave();
				}
			}
		} else if (getWave() == 2) {
			if (getTick() >= 100) {
				if (getTick() == 105) em.getHorde().addSimple(300, -50, 1);
				if (getTick() == 110) em.getHorde().addSimple(254, -50, 1);
				if (getTick() == 118) em.getHorde().addSimple(1000, -50, 1);
				if (getTick() == 116) em.getHorde().addSimple(800, -50, 1);
				if (getTick() == 118) em.getHorde().addSimple(100, -50, 1);
				if (getTick() == 120) em.getHorde().addSimple(670, -50, 1);
				if (getTick() == 120) em.getHorde().addSimple(570, -50, 1);
				if (getTick() == 108) em.getHorde().addSimple(820, -50, 1);
				if (getTick() == 130) em.getHorde().addSimple(438, -50, 1);
				if (getTick() == 131) em.getHorde().addSimple(1220, -50, 1); // 10

				em.getHorde().swivelHorde(200, 1);

				if (em.getHorde().checkForType("SIMPLE") && getTick() >= 131) {
					setTick(0);
					incWave();
				}
			}

		} else if (getWave() == 3) {
			if (getTick() >= 100) {
				if (getTick() <= 175) {
					em.getHorde().addSimple(Reference.WIDTH + 50, 100, getTick(), 25, 7525);
					em.getHorde().addSimple(-50, 200, getTick(), 25, 752752);
					em.getHorde().addSimple(Reference.WIDTH + 50, 300, getTick(), 25, 7525);
					em.getHorde().addSimple(-50, 400, getTick(), 25, 752752);
				}

				if (getTick() <= 300) {
					em.getHorde().moveHordeSmoothly(175, "LEFT", null, 7525); // 5
					em.getHorde().moveHordeSmoothly(175, "RIGHT", null, 752752); // 5
				}

				if (em.getHorde().checkForType("SIMPLE")) {
					setTick(0);
					incWave();
				}
			}
		} else if (getWave() == 4) {
			if (getTick() >= 100) {
				if (getTick() <= 180) {
					em.getHorde().addSimple(Reference.WIDTH + 50, 250, getTick(), 20, 321);
					em.getHorde().addSimple(-50, 250, getTick(), 20, 216);
				} else if (getTick() <= 260) {
					em.getHorde().addSimple(Reference.WIDTH + 50, 420, getTick(), 20, 78);
					em.getHorde().addSimple(-50, 420, getTick(), 20, 7789);
				}

				em.getHorde().diagonalHorde(300, "LEFT", "DOWN", 321);
				em.getHorde().diagonalHorde(300, "RIGHT", "DOWN", 216);
				em.getHorde().diagonalHorde(300, "LEFT", "UP", 78);
				em.getHorde().diagonalHorde(300, "RIGHT", "UP", 7789); // 8

				if (em.getHorde().checkForType("SIMPLE")) {
					setTick(0);
					incWave();
				}
			}

		} else if (getWave() == 5) {
			if (getTick() >= 100) {
				if (getTick() <= 180) {
					em.getHorde().addSimple(Reference.WIDTH / 4, -50, getTick(), 20, 3243);
					em.getHorde().addSimple(Reference.WIDTH / 2, -50, getTick(), 20, 3243);
					em.getHorde().addSimple(Reference.WIDTH * 3 / 4, -50, getTick(), 20, 3243); // 15
				}

				em.getHorde().moveHordeSmoothly(100, null, "DOWN", 3243);

				if (!em.getHorde().checkForType("SIMPLE")) {
					setTick(0);
					incWave();
				}
			}
		} else if (getWave() == 6) {
			incTick();
			if (getTick() == 100) em.getShip().setAllowedToPass(true);
		}

		if (em.getShip().getY() < 0) {
			em.getShip().setAllowedToPass(false);
			States.setState("LEVEL02");
			em.getShip().setY(Reference.HEIGHT);
		}

		super.update();

	}

	@Override
	public String getName() {
		return "LEVEL01";
	}
}
