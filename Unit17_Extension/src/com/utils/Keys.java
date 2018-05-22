package com.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keys extends KeyAdapter
{
	public static final int	NUM_KEYS		= 11;

	public static boolean	keyState[]		= new boolean[NUM_KEYS];
	public static boolean	prevKeyState[]	= new boolean[NUM_KEYS];

	public static int		LEFT			= 0;
	public static int		RIGHT			= 1;
	public static int		UP				= 2;
	public static int		DOWN			= 3;
	public static int		W				= 4;
	public static int		A				= 5;
	public static int		S				= 6;
	public static int		D				= 7;
	public static int		R				= 8;
	public static int		ENTER			= 9;
	public static int		ESCAPE			= 10;

	public static void keySet(int code, boolean b) {
		if (KeyEvent.VK_LEFT == code) keyState[LEFT] = b;
		else if (KeyEvent.VK_RIGHT == code) keyState[RIGHT] = b;
		else if (KeyEvent.VK_UP == code) keyState[UP] = b;
		else if (KeyEvent.VK_DOWN == code) keyState[DOWN] = b;
		else if (KeyEvent.VK_W == code) keyState[W] = b;
		else if (KeyEvent.VK_A == code) keyState[A] = b;
		else if (KeyEvent.VK_S == code) keyState[S] = b;
		else if (KeyEvent.VK_D == code) keyState[D] = b;
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
		
		if (Keys.isDown(Keys.LEFT) || Keys.isDown(Keys.A)) hcount++;
		if (Keys.isDown(Keys.RIGHT) || Keys.isDown(Keys.D)) hcount++;

		if (Keys.isDown(Keys.UP) || Keys.isDown(Keys.W)) vcount++;
		if (Keys.isDown(Keys.DOWN) || Keys.isDown(Keys.S)) vcount++;
		
		return hcount == 1 && vcount == 1;
	}

	// key events
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) System.exit(0);
		Keys.keySet(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		Keys.keySet(e.getKeyCode(), false);
	}
}
