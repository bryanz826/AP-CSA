package pong3;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong3

import javax.swing.JFrame;
import java.awt.Component;

public class Tester3 extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Tester3()
	{
		super("Paddle Test");
		setSize(WIDTH,HEIGHT);
		
		PaddleTestTwo padTest = new PaddleTestTwo();
		((Component)padTest).setFocusable(true);
		getContentPane().add(padTest);
		
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		Tester3 run = new Tester3();
		run.repaint();
	}
}