import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameRunner
{
	private static final int	WIDTH	= 1366;
	private static final int	HEIGHT	= 768;

	private static Frame		frame;

	public GameRunner()
	{
		final GamePanel game = new GamePanel();
		frame = new Frame("Make America Great Again");
		frame.setSize(WIDTH, HEIGHT);
		frame.add(game);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getSize().width / 2, d.height / 2 - frame.getSize().height / 2);
		frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Reference.RESOURCE_LOC
		// + "icon.png"));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
	}

	public static void main(String[] args) {
		new GameRunner();
	}
}
