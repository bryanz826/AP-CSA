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
public class StarFighter
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
	protected static JFrame	frame;

	/**
	 * Default constructor that builds the JFrame instance and the game instance.
	 * 
	 * @see OuterSpace
	 */
	public StarFighter()
	{
		final OuterSpace theGame = new OuterSpace();
		frame = new JFrame("STARFIGHTER");
		frame.setSize(WIDTH, HEIGHT);
		((Component) theGame).setFocusable(true);
		frame.getContentPane().add(theGame);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getSize().width / 2, d.height / 2 - frame.getSize().height / 2);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Reference.RESOURCE_LOC + "icon.png"));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		theGame.start();
	}

	/**
	 * Main method that runs the SplashScreen then the game itself through this
	 * class's default constructor.
	 * 
	 * @param args
	 * @see SplashScreen
	 * @see OuterSpace
	 */
	public static void main(String args[]) {
		new SplashScreen();
		new StarFighter();
	}
}
