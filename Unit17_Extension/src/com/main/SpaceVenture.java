package com.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.utils.Reference;

/**
 * Game runner that contains a JFrame instance.
 * 
 * @author bryan
 *
 */
public class SpaceVenture
{
	/**
	 * JFrame width.
	 */
	public static final int	WIDTH	= 1366;

	/**
	 * JFrame height.
	 */
	public static final int	HEIGHT	= 768;

	/**
	 * JFrame instance.
	 */
	private static JFrame	frame;

	/**
	 * Default constructor that builds the JFrame instance and the game instance.
	 * 
	 * @see GamePanel
	 */
	public SpaceVenture()
	{
		final GamePanel game = new GamePanel();
		frame = new JFrame("Space Venture");
		frame.setSize(WIDTH, HEIGHT);
		((Component) game).setFocusable(true);
		frame.getContentPane().add(game);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getSize().width / 2, d.height / 2 - frame.getSize().height / 2);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Reference.RESOURCE_LOC + "icon.png"));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
	}

	/**
	 * Main method that first runs the splash screen and then runs the game.
	 * 
	 * @param args
	 * @see Splash
	 * @see GamePanel
	 */
	public static void main(String args[]) {
		new Splash();
		new SpaceVenture();
	}
	
	/**
	 * Returns frame instance.
	 */
	protected static JFrame getFrame() {
		return frame;
	}
}
