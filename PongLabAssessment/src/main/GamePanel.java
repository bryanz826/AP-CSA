package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import managers.StateManager;
import states.GameOver;
import states.Play;
import utils.Keys;

@SuppressWarnings("serial")
public class GamePanel extends Canvas implements Runnable
{
	public static final boolean	DEBUGGING	= false;

	private static final int	FRAME_CAP	= 60;
	private static final int	TARGET_UPS	= 60;
	private static int			FPS			= FRAME_CAP;
	private static boolean		showFPS;
	private static boolean		running;
	private static boolean		pause;

	public GamePanel()
	{
		addKeyListener(new Keys());
		setBackground(Color.BLACK);
		setVisible(true);
		
		StateManager.addState(new Play());
		StateManager.addState(new GameOver());
	}

	private void init() {
		showFPS = true;
		running = true;
		pause = false;
	}

	private void processInput() {
		StateManager.processInput();
		if (Keys.wasPressed(Keys.ESCAPE)) System.exit(0);
		Keys.update();
	}

	private void update() {
		StateManager.update();
	}

	private void render() {
		Graphics2D g = null;
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		do {
			do {
				try {
					g = (Graphics2D) bs.getDrawGraphics();

					StateManager.render(g);

				} finally {
					g.dispose();
				}
				bs.show();
			} while (bs.contentsRestored());
		} while (bs.contentsLost());
	}

	private void gameLoop() {
		final long OPTIMAL_TIME = 1000000000 / TARGET_UPS;
		final double FRAME_CAPPER = (double) TARGET_UPS / FRAME_CAP;

		long timer = System.currentTimeMillis();
		int frameCount = 0;

		long previous = System.nanoTime();
		double dt = 0;
		double frameDuration = 0;

		while (running) {
			long current = System.nanoTime();
			long elapsed = current - previous;
			previous = current;

			dt += elapsed / (double) OPTIMAL_TIME;
			frameDuration += elapsed / (double) OPTIMAL_TIME;

			if (dt >= 1.0) {
				processInput();
				update();
				dt--;
			}

			if (frameDuration >= FRAME_CAPPER) {
				render();
				frameCount++;
				frameDuration = 0;
			}
			if (System.currentTimeMillis() - 1000 > timer) {
				timer += 1000;
				FPS = frameCount;
				frameCount = 0;
			}

		}
		System.exit(0);
	}

	@Override
	public void run() {
		init();
		gameLoop();
	}

	protected void start() {
		if (running) return;
		running = true;
		new Thread(this).start();
	}

	public static void setShowFPS(boolean showFPS) {
		GamePanel.showFPS = showFPS;
	}

	public static void setRunning(boolean running) {
		GamePanel.running = running;
	}

	public static void setPause(boolean pause) {
		GamePanel.pause = pause;
	}

	public static boolean getShowFPS() {
		return showFPS;
	}

	public static boolean getPause() {
		return pause;
	}

	public static int getFPS() {
		return FPS;
	}
}
