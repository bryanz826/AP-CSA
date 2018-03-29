package the_pong_game;

import javax.swing.JFrame;

import the_pong_game.Pong;

import java.awt.Component;

public class TheGame extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 650;

	public TheGame()
	{
		super("PONG");
		setSize(WIDTH,HEIGHT);
		
		Pong game = new Pong();
		
		((Component)game).setFocusable(true);			
		getContentPane().add(game);
						
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		TheGame run = new TheGame();
		run.repaint();
	}
}