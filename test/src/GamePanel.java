import java.awt.*;
import java.awt.image.BufferStrategy;

@SuppressWarnings("serial")
public class GamePanel extends Canvas implements Runnable
{
	private static final int	FRAME_CAP	= 60;
	private static final int	TARGET_UPS	= 60;
	private int					FPS			= FRAME_CAP;	// initialized frame cap

	private static boolean		running;

	public GamePanel()
	{
		setVisible(true);
		setFocusable(true);
		requestFocus();
		setBackground(Color.BLACK);
		States.addState(new TestState());
	}

	private void init() {

	}

	private void processInput() {
		States.processInput();
	}

	private void update() {
		States.update();
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
					States.render(g);
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
}
