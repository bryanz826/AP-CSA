import java.awt.Graphics2D;
import java.awt.Color;

public class TestState implements State
{
	@Override
	public void init() {

	}

	@Override
	public void processInput() {

	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(new Color(128, 128, 128));
		g.fillRect(1366 - 50 - 15, 768 - 50 - 37, 50, 50);
	}

	@Override
	public void enter() {

	}

	@Override
	public void exit() {

	}

	@Override
	public String getName() {
		return "teststate";
	}
}
