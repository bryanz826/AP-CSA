package pong4;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong4

import javax.swing.JFrame;

import pong4.Pong4;

import java.awt.Component;

public class TheGame4 extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 650;

	public TheGame4()
	{
		super("PONG");
		setSize(WIDTH,HEIGHT);
		
		Pong4 game = new Pong4();
		
		((Component)game).setFocusable(true);			
		getContentPane().add(game);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		TheGame4 run = new TheGame4();
		run.repaint();
	}
}