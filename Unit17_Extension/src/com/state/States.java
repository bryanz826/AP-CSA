package com.state;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

public class States
{
	private static final Map<String, State>	map	= new HashMap<String, State>();
	private static State					currentState;

	public void addState(State state) {
		map.put(state.getName().toUpperCase(), state);
		state.init();
		if (currentState == null) {
			currentState = state;
			state.init();
			state.enter();
		}
	}

	public void setState(String name) {
		State state = map.get(name.toUpperCase());
		if (state == null) {
			System.err.printf("State <%s> does not exist!\n", name);
			return;
		}
		currentState = state;
		currentState.enter();
	}

	public void processInput() {
		currentState.processInput(this);
	}

	public void update() {
		currentState.update(this);
	}

	public void render(Graphics2D g) {
		currentState.render(g);
	}
	
	public static State getCurrentState() {
		return currentState;
	}
}
