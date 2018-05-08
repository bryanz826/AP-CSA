package main;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameRunner
{
	public static final int	WIDTH	= 800;
	public static final int	HEIGHT	= 800;
	private static JFrame	frame;

	public GameRunner()
	{
		final GamePanel game = new GamePanel();
		frame = new JFrame("Space Venture");
		frame.setSize(WIDTH, HEIGHT);
		((Component) game).setFocusable(true);
		frame.getContentPane().add(game);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getSize().width / 2, d.height / 2 - frame.getSize().height / 2);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setVisible(true);

		game.start();
	}

	public static void main(String args[]) {
		new GameRunner();
	}

	protected static JFrame getFrame() {
		return frame;
	}
}
