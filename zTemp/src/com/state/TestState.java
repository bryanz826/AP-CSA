package com.state;

import java.awt.Color;
import java.awt.Graphics2D;

import com.text.Dialogue;

import coc.utils.Reference;

public class TestState implements State
{
	private Dialogue dialogue;
	private int tick;
	
	@Override
	public void init() {
		dialogue = new Dialogue();
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processInput(States sm) {
		dialogue.processInput();
	}

	@Override
	public void update(States sm) {
		tick++;
		dialogue.update();
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Reference.WIDTH, Reference.HEIGHT);
		
		dialogue.render(g);
	}

	@Override
	public String getName() {
		return "TESTSTATE";
	}

}
