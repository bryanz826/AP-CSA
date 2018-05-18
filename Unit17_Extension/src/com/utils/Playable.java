package com.utils;

import java.awt.Graphics2D;

public interface Playable extends Loopable
{
	void processInput();

	void update();

	void render(Graphics2D g);
}
