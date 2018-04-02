import javax.swing.JFrame;

import java.awt.Component;

@SuppressWarnings("serial")
public class TheGame extends JFrame
{
	private static final int WIDTH = 1536;
	private static final int HEIGHT = 862;

	public TheGame()
	{
		super("PONG");
		setSize(WIDTH,HEIGHT);
		
		Pong game = new Pong();
		
		((Component)game).setFocusable(true);			
		getContentPane().add(game);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		TheGame run = new TheGame();
		run.repaint();
	}
}