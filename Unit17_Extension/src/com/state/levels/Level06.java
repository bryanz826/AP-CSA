package com.state.levels;

import com.state.GameOver;
import com.state.State;
import com.state.States;
import com.utils.Reference;
import com.utils.Resource;

public class Level06 extends LevelManager implements State
{
	@Override
	public void init() {
		bg = new Resource(Reference.LEVEL_LOC + "level06.jpg");
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
			if (tick == 100) {
				horde.addBoss(Reference.WIDTH / 2, -200, 6942069);
			}
			horde.moveHordeSmoothly(400, "DOWN", 0.25, 6942069);

			if (horde.checkForTypeMissing("BOSS") && tick >= 101) {
				tick = 0;
				wave++;
			}
		} else if (wave == 2) {
			if (++tick == 100) ship.setPass(true);
		}
		
		if (ship.getY() < 0) {
			ship.setPass(false);
			sm.setState("GAMEOVER");
			GameOver.setWin(true);
		}
		
		super.update(sm);
	}

	@Override
	public String getName() {
		return "LEVEL06";
	}

}
