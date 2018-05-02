package com.state;

import java.awt.Graphics2D;

public interface State
{
	public void init();

	public void enter();
	
	public void processInput(States sm);

	public void update(States sm);

	public void render(Graphics2D g);

	public String getName();
}
