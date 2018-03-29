package pong5;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;

import pong5.Pong5;

import java.awt.Component;

public class TheGame5 extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 650;

	public TheGame5()
	{
		super("PONG");
		setSize(WIDTH,HEIGHT);
		
		Pong5 game = new Pong5();
		
		((Component)game).setFocusable(true);			
		getContentPane().add(game);
						
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		TheGame5 run = new TheGame5();
		run.repaint();
	}
}