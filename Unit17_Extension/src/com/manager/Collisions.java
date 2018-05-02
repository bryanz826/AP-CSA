package com.manager;

import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.ammo.player.Magazine;
import com.entity.mobile.live.alien.AlienHorde;
import com.entity.mobile.live.player.Ship;
import com.entity.mobile.powerups.PowerUps;
import com.utils.Reference;

/**
 * a class specific for handling collisions between specific objects
 */
public class Collisions
{
	private void handleCollisionWall(Ship ship) {
		int space = 7;
		if (ship.getX() < space) ship.setX(space);
		else if (ship.getX() + ship.getWidth() > Reference.WIDTH - 13 - space)
			ship.setX(Reference.WIDTH - 13 - space - ship.getWidth());
		if (ship.getY() < space && !ship.isPass()) ship.setY(space);
		else if (ship.getY() + ship.getHeight() > Reference.HEIGHT - 38 - space)
			ship.setY(Reference.HEIGHT - 38 - space - ship.getHeight());
	}

	private void handleCollision(Ship ship, AlienHorde horde) {
		for (int i = 0; i < horde.getHorde().size(); i++)
			if (ship.getBounds().collides(horde.getHorde().get(i).getBounds())
					|| ship.getBounds2().collides(horde.getHorde().get(i).getBounds()))
			{
				ship.decHp(horde.getHorde().get(i).getDamage());
				horde.getHorde().get(i).setHp(0); // remove alien
			}
	}
	
	private void handleCollision(Ship ship, PowerUps powerups) {
		for (int i = 0; i < powerups.getPowerups().size(); i++)
			if (ship.getBounds().collides(powerups.getPowerups().get(i).getBounds())
				|| ship.getBounds2().collides(powerups.getPowerups().get(i).getBounds()))
			{
				powerups.getPowerups().get(i).setPickedUp(true);
			}
	}
	
	private void handleCollision(Ship ship, Storage storage) {
		for (int i = 0; i < storage.getStorage().size(); i++)
			if (ship.getBounds().collides(storage.getStorage().get(i).getBounds())
				|| ship.getBounds2().collides(storage.getStorage().get(i).getBounds()))
			{
				ship.decHp(storage.getStorage().get(i).getDamage());
				storage.getStorage().get(i).setLanded(true);
			}
	}

	private void handleCollision(Magazine magazine, AlienHorde horde) {
		for (int i = 0; i < magazine.getMagazine().size(); i++)
			for (int j = 0; j < horde.getHorde().size(); j++)
				if (magazine.getMagazine().get(i).getBounds().collides((horde.getHorde().get(j).getBounds()))) {
					horde.getHorde().get(j).decHp(magazine.getMagazine().get(i).getDamage());
					magazine.getMagazine().get(i).setLanded(true);
				}
	}
	
	public void update(Ship ship, Magazine magazine, PowerUps powerups, AlienHorde horde, Storage storage) {
		handleCollisionWall(ship);
		handleCollision(ship, horde);
		handleCollision(ship, powerups);
		handleCollision(ship, storage);
		handleCollision(magazine, horde);
	}
}
