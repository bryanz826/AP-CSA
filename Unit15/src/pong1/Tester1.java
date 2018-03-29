package pong1;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong1

import javax.swing.JFrame;
//import java.awt.Component;

public class Tester1 extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Tester1()
	{
		super("Block Test");
		setSize(WIDTH,HEIGHT);
		
		getContentPane().add(new BlockTestTwo());
		
		//uncomment when you are ready to test the Ball
		//getContentPane().add(new BallTestTwo());		
		
		//PaddleTestTwo padTest = new PaddleTestTwo();
		//((Component)padTest).setFocusable(true);			
		//getContentPane().add(padTest);
				
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		Tester1 run = new Tester1();
		run.repaint();
	}
}