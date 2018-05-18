package com.entities;

import com.entities.aliens.Alien;
import com.entities.aliens.Horde;
import com.entities.aliens.Storage;
import com.entities.aliens.missiles.Missile;
import com.entities.player.Player;
import com.entities.player.ammo.Ammo;
import com.entities.player.powerups.PowerUp;
import com.utils.Reference;

/**
 * a class for handling collisions between specific objects
 */
public class Collisions
{
	private static void handleCollisionWall(Player ship) {
		int space = 7;
		if (ship.getX() < space) ship.setX(space);
		else if (ship.getX() + ship.getWidth() > Reference.WIDTH - 13 - space)
			ship.setX(Reference.WIDTH - 13 - space - ship.getWidth());
		if (ship.getY() < space && !ship.isAllowedToPass()) ship.setY(space);
		else if (ship.getY() + ship.getHeight() > Reference.HEIGHT - 38 - space)
			ship.setY(Reference.HEIGHT - 38 - space - ship.getHeight());
	}

	private static void handleCollision(Player ship, Horde horde) {
		for (Alien alien : horde.getList())
			for (Ammo ammo : ship.getMagazine().getList())
				for (Bounds alienBounds : alien.getBounds()) {
					for (Bounds shipBounds : ship.getBounds())
						if (shipBounds.collides(alienBounds)) {
							ship.decHp(alien.getCollisionDamage());
							alien.setHp(0); // remove alien
						}

					for (Bounds ammoBounds : ammo.getBounds())
						if (alienBounds.collides(ammoBounds)) {
							alien.decHp(ammo.getDamage());
							ammo.setLanded(true);
						}
				}
	}

	private static void handleCollision(Player ship) {
		for (PowerUp powerup : ship.getPowerups().getList())
			for (Bounds shipBounds : ship.getBounds())
				for (Bounds powerupBounds : powerup.getBounds())
					if (shipBounds.collides(powerupBounds)) {
						powerup.setPickedUp(true);
					}
	}

	private static void handleCollision(Player ship, Storage storage) {
		for (Missile missile : storage.getList())
			for (Bounds shipBounds : ship.getBounds())
				for (Bounds missileBounds : missile.getBounds())
					if (shipBounds.collides(missileBounds)) {
						ship.decHp(missile.getDamage());
						missile.setLanded(true);
					}
	}

	public static void update(Player ship, Horde horde, Storage storage) {
		handleCollisionWall(ship);
		handleCollision(ship, horde);
		handleCollision(ship);
		handleCollision(ship, storage);
	}
}
