package utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keys extends KeyAdapter
{
	public static final int	NUM_KEYS		= 7;

	public static boolean	keyState[]		= new boolean[NUM_KEYS];
	public static boolean	prevKeyState[]	= new boolean[NUM_KEYS];

	public static int		LEFT			= 0;
	public static int		RIGHT			= 1;
	public static int		UP				= 2;
	public static int		DOWN			= 3;
	public static int		ENTER			= 4;
	public static int		ESCAPE			= 5;
	public static int		R				= 6;

	public static void keySet(int code, boolean b) {
		if (KeyEvent.VK_LEFT == code) keyState[LEFT] = b;
		else if (KeyEvent.VK_RIGHT == code) keyState[RIGHT] = b;
		else if (KeyEvent.VK_UP == code) keyState[UP] = b;
		else if (KeyEvent.VK_DOWN == code) keyState[DOWN] = b;
		else if (KeyEvent.VK_ENTER == code) keyState[ENTER] = b;
		else if (KeyEvent.VK_ESCAPE == code) keyState[ESCAPE] = b;
		else if (KeyEvent.VK_R == code) keyState[R] = b;
	}

	public static void update() {
		for (int i = 0; i < NUM_KEYS; i++) {
			prevKeyState[i] = keyState[i];
		}
	}

	public static boolean isDown(int i) {
		return keyState[i];
	}

	public static boolean isUp(int i) {
		return !keyState[i];
	}

	public static boolean wasPressed(int i) {
		return isDown(i) && !prevKeyState[i];
	}

	public static boolean wasReleased(int i) {
		return !isDown(i) && prevKeyState[i];
	}

	public static boolean anyKeyPress() {
		for (int i = 0; i < NUM_KEYS; i++) {
			if (keyState[i] && !prevKeyState[i]) return true;
		}
		return false;
	}

	public static boolean anyKeyDown() {
		for (int i = 0; i < NUM_KEYS; i++) {
			if (keyState[i]) return true;
		}
		return false;
	}

	public static boolean checkMultiDirectionalMovement() {
		int hcount = 0;
		int vcount = 0;
		
		if (Keys.isDown(Keys.LEFT)) hcount++;
		if (Keys.isDown(Keys.RIGHT)) hcount++;

		if (Keys.isDown(Keys.UP)) vcount++;
		if (Keys.isDown(Keys.DOWN)) vcount++;
		
		return hcount == 1 && vcount == 1;
	}

	// key events
	public void keyPressed(KeyEvent e) {
		Keys.keySet(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		Keys.keySet(e.getKeyCode(), false);
	}
}
