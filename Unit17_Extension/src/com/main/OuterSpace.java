package com.main;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import com.manager.Keys;
import com.manager.Text;
import com.state.States;
import com.state.levels.LevelManager;
import com.utils.Reference;

/**
 * 
 * @author bryan
 *
 */
@SuppressWarnings("serial")
public class OuterSpace extends Canvas implements Runnable
{
	public static final boolean	DEBUGGING	= false;

	private static final int	FRAME_CAP	= 60;
	private static final int	TARGET_UPS	= 60;
	private int					FPS			= FRAME_CAP;	// initialized frame cap

	private States				sm;

	private static boolean		showFPS;
	private static boolean		running;
	private static boolean		pause;

	public OuterSpace()
	{
		addKeyListener(new Keys());
		setVisible(true);
	}

	private void init() {
		sm = new States();

		showFPS = true;
		running = true;
		pause = false;
	}

	private void processInput() {
		sm.processInput();
		Keys.update();
	}

	private void update() {
		if (!StarFighter.frame.isFocused() && States.getCurrentState() instanceof LevelManager) setPause(true);
		if (!pause) {
			sm.update();
		}
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

					sm.render(g);
					if (showFPS) new Text("FPS: " + FPS, Reference.WIDTH - 157, 114, 0.35).drawString(g);
					if (pause) {
						new Text("PAUSED", Reference.CENTER_X - 282, Reference.CENTER_Y - 150, 2).drawString(g);
						new Text("PRESS 'ESC' TO CONTINUE", 250, Reference.CENTER_Y + 50, 0.77).drawString(g);
					}

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
		OuterSpace.showFPS = showFPS;
	}

	public static void setRunning(boolean running) {
		OuterSpace.running = running;
	}

	public static void setPause(boolean pause) {
		OuterSpace.pause = pause;
	}

	public static boolean getShowFPS() {
		return showFPS;
	}

	public static boolean getPause() {
		return pause;
	}
}
