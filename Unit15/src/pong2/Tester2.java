package pong2;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong2

import javax.swing.JFrame;
//import java.awt.Component;

public class Tester2 extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Tester2()
	{
		super("Block Test");
		setSize(WIDTH,HEIGHT);
		
		getContentPane().add(new BallTestTwo());		
		
		//PaddleTestTwo padTest = new PaddleTestTwo();
		//((Component)padTest).setFocusable(true);			
		//getContentPane().add(padTest);
				
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		Tester2 run = new Tester2();
		run.repaint();
	}
}