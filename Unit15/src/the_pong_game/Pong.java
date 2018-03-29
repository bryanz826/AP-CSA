package the_pong_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
//import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.Font;

import the_pong_game.Ball;
import the_pong_game.Paddle;

//import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private static final long serialVersionUID = 1L;
	private int timer = 0;
	
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private Wall wall;
	private BufferedImage back;
	
	private boolean[] keys;

	private Font startFont;
	private Font scoreFont;
	private Font roundFont;
	private Font endFont;
	
	private int leftScore;
	private int rightScore;
	private boolean leftWins;
	private boolean rightWins;
	
	private boolean startAnim;
	private boolean roundAnim;
	private int round;
	private boolean endAnim;
	
	private static final int BALL_Xi = 380;
	private static final int BALL_Yi = 265;
	
	public Pong()
	{
		//set up variables
		wall = new Wall(0, 770, 8, 550);
		keys = new boolean[4];

		startFont = new Font(Font.SANS_SERIF, Font.BOLD, 60);
		scoreFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		roundFont = new Font(Font.SANS_SERIF, Font.BOLD, 40);
		endFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
		
		leftScore = 0;
		rightScore = 0;
		leftWins = false;
		rightWins = false;
		
		startAnim = true;
		roundAnim = true;
		round = 0;
		endAnim = false;
		
		//Graphics
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
	public void createBall() {
		ball = new Ball(BALL_Xi, BALL_Yi, 10, 10, Color.BLUE, 3, 1);
	}
	
	public void update(Graphics window){
		paint(window);
	}

   	public void paint(Graphics window)
   	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		//take a snap shop of the current screen and save it as an image
		//that is the exact same width and height as the current screen
		if(back == null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

	/**
	 *  START ANIMATION
	 */
		if(startAnim) {
			timer++;
			graphToBack.setFont(startFont);
			if(timer == 1) {
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("PONG!", 290, 270);
			} else if(timer == 50) {
				graphToBack.setColor(Color.ORANGE);
				graphToBack.drawString("PONG!", 290, 270);
			} else if(timer == 100) {
				graphToBack.setColor(Color.YELLOW);
				graphToBack.drawString("PONG!", 290, 270);
			} else if(timer == 150) {
				graphToBack.setColor(Color.GREEN);
				graphToBack.drawString("PONG!", 290, 270);
			} else if(timer == 200) {
				graphToBack.setColor(Color.BLUE);
				graphToBack.drawString("PONG!", 290, 270);
			} else if(timer == 250) {
				graphToBack.setColor(Color.MAGENTA);
				graphToBack.drawString("PONG!", 290, 270);
			} else if(timer == 300) {
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("PONG!", 290, 270);
				
				startAnim = false;
				timer = 0;
			}
		}
		
	/**
	 * ROUND ANIMATION
	 */
		else if(roundAnim) {
			timer++;
			graphToBack.setFont(roundFont);
			if(timer == 1) {
				//new round
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("ROUND "+ ++round, 300, 200);
				
				//new paddles
				leftPaddle = new Paddle(10, 244, 10, 70, Color.YELLOW, 4);
				rightPaddle = new Paddle(760, 244, 10, 70, Color.YELLOW, 4);
			} else if(timer < 150) {
				
			//SET UP MOST OF GAME
				//draw boundary lines
				graphToBack.setColor(Color.BLACK);
				graphToBack.drawLine(0, wall.getBottom(), 800, wall.getBottom());
				graphToBack.drawLine(0, wall.getTop(), 800, wall.getTop());
				
				//draw scoring
				graphToBack.setFont(scoreFont);
				
				graphToBack.clearRect(1, 556, 798, 248);
					
				graphToBack.setColor(Color.BLACK);
				graphToBack.drawString("Player 1 Score: "+ leftScore + 
						"                                       " + 
						"Player 2 Score: "+ rightScore, 120, 590);
				
			//PADDLE STUFF
				leftPaddle.draw(graphToBack);
				rightPaddle.draw(graphToBack);
				
				if(leftPaddle.didCollideTop(wall) || leftPaddle.didCollideBottom(wall))
				{
					leftPaddle.setY(leftPaddle.getY()-leftPaddle.getcSpeed());
				}

				if(rightPaddle.didCollideTop(wall) || rightPaddle.didCollideBottom(wall))
				{
					rightPaddle.setY(rightPaddle.getY()-rightPaddle.getcSpeed());
				}
				
				if(keys[0] == true)
					leftPaddle.moveUpAndDraw(graphToBack);
				if(keys[1] == true)
					leftPaddle.moveDownAndDraw(graphToBack);
				if(keys[2] == true)
					rightPaddle.moveUpAndDraw(graphToBack);
				if(keys[3] == true)
					rightPaddle.moveDownAndDraw(graphToBack);
								
			} else if(timer == 150) {
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("ROUND "+ round, 300, 200);
				
				roundAnim = false;
				timer = 0;
				
			//FINISH SETUP
				//create ball
				createBall();
			}
		}
	/**
	 * END ANIMATION
	 */
		else if(endAnim) {
			
			if(leftWins) {
				timer++;
				if(timer == 1) {
					graphToBack.setFont(endFont);
				}
			}
			else if(rightWins) {
				
			}
		}

	/**
	 * GAME ANIMATION
	 */
		else {
			ball.moveAndDraw(graphToBack);
			leftPaddle.draw(graphToBack);
			rightPaddle.draw(graphToBack);

			//draw boundary lines
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawLine(0, wall.getBottom(), 800, wall.getBottom());
			graphToBack.drawLine(0, wall.getTop(), 800, wall.getTop());
			
		//BALL STUFF
			if(ball.didCollideLeft(wall)) {
				roundAnim = true;
				rightScore++;
				
				ball.setXSpeed(0);
				ball.setYSpeed(0);
				ball.draw(graphToBack, Color.WHITE);
				ball.setPos(BALL_Xi, BALL_Yi);
				ball.setColor(Color.WHITE);
				
				leftPaddle.draw(graphToBack, Color.WHITE);
				leftPaddle.setColor(Color.WHITE);
				rightPaddle.draw(graphToBack, Color.WHITE);
				rightPaddle.setColor(Color.WHITE);
				
				if(rightScore == 5) {
					System.out.println("wow right won");
				}
			}
			

			if(ball.didCollideRight(wall)) {
				roundAnim = true;
				leftScore++;
				
				ball.setXSpeed(0);
				ball.setYSpeed(0);
				ball.draw(graphToBack, Color.WHITE);
				ball.setPos(BALL_Xi, BALL_Yi);
				ball.setColor(Color.WHITE);
				
				leftPaddle.draw(graphToBack, Color.WHITE);
				leftPaddle.setColor(Color.WHITE);
				rightPaddle.draw(graphToBack, Color.WHITE);
				rightPaddle.setColor(Color.WHITE);
				
				if(leftScore == 5) {
					System.out.println("wow left won");
				}
			}
			

			if(ball.didCollideTop(wall) || ball.didCollideBottom(wall))
				ball.setYSpeed(-ball.getYSpeed());
	

			if(/**ball*/didCollideLeftPaddle())
			{
				//?
				if(ball.getX() <= leftPaddle.getX()+leftPaddle.getWidth()-Math.abs(ball.getXSpeed()))
					ball.setYSpeed(-ball.getYSpeed());
				
				else if(leftPaddle.getcSpeed() == 0 && ball.getYSpeed() < 0)
					ball.setXSpeed(-ball.getXSpeed());
				
				else if(leftPaddle.getcSpeed() < 0 /*up*/ && ball.getYSpeed() > 0 /*down*/
						|| leftPaddle.getcSpeed() > 0 /*down*/ && ball.getYSpeed() < 0 /*up*/) 
				{
					ball.setYSpeed(-ball.getYSpeed());
					ball.setXSpeed(-ball.getXSpeed());
				}
				
				else
					ball.setXSpeed(-ball.getXSpeed());
			}
			
			
			if(/**ball*/didCollideRightPaddle())
			{
				//?
				if(ball.getX() >= rightPaddle.getX()-rightPaddle.getWidth()+Math.abs(ball.getXSpeed()))
					ball.setYSpeed(-ball.getYSpeed());
				
				else if(rightPaddle.getcSpeed() < 0 && ball.getYSpeed() < 0
						|| rightPaddle.getcSpeed() > 0 && ball.getYSpeed() > 0)
					ball.setXSpeed(-ball.getXSpeed());
				
				else if(rightPaddle.getcSpeed() < 0 /*up*/ && ball.getYSpeed() > 0 /*down*/
						|| rightPaddle.getcSpeed() > 0 /*down*/ && ball.getYSpeed() < 0 /*up*/) 
				{
					ball.setYSpeed(-ball.getYSpeed());
					ball.setXSpeed(-ball.getXSpeed());
				}
				
				else
					ball.setXSpeed(-ball.getXSpeed());
			}
			
		//PADDLE STUFF
			if(leftPaddle.didCollideTop(wall) || leftPaddle.didCollideBottom(wall))
			{
				leftPaddle.setY(leftPaddle.getY()-leftPaddle.getcSpeed());
			}

			if(rightPaddle.didCollideTop(wall) || rightPaddle.didCollideBottom(wall))
			{
				rightPaddle.setY(rightPaddle.getY()-rightPaddle.getcSpeed());
			}
			
			//left player
			if(keys[0] == true) {
				leftPaddle.moveUpAndDraw(graphToBack);
			} else if(keys[1] == true) {
				leftPaddle.moveDownAndDraw(graphToBack);
			} else leftPaddle.moveNothing(graphToBack);
			
			//right player
			if(keys[2] == true) {
				rightPaddle.moveUpAndDraw(graphToBack);
			} else if(keys[3] == true) {
				rightPaddle.moveDownAndDraw(graphToBack);
			} else rightPaddle.moveNothing(graphToBack);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
  	
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
   	
   	//PROGRAM RUNNER
  	public void run()
  	{
  		while(true)
  		{
  			wait(8);
  			repaint();
  		}
    }
	
/**
 * REFACTORING CODE
 */
	public void wait(int ms) {
		try {
			Thread.currentThread();
			Thread.sleep(ms);
		} catch(Exception e) {
			System.out.println("Error with \"wait\"");
		}
	}
	
	public boolean didCollideLeftPaddle() {
		return ball.getX() <= leftPaddle.getX()+leftPaddle.getWidth()
				&& ball.getY() >= leftPaddle.getY()
				&& (ball.getY() <= leftPaddle.getY()+leftPaddle.getHeight()
				|| ball.getY()+ball.getHeight() >= leftPaddle.getY()
				&& ball.getY()+ball.getHeight() < leftPaddle.getY()+leftPaddle.getHeight());
	}
	
	public boolean didCollideRightPaddle() {
		return ball.getX() >= rightPaddle.getX()-rightPaddle.getWidth()
				&& ball.getY() >= rightPaddle.getY()
				&& (ball.getY() <= rightPaddle.getY()+rightPaddle.getHeight()
				|| ball.getY()+ball.getHeight() >= rightPaddle.getY()
				&& ball.getY()+ball.getHeight() < rightPaddle.getY()+rightPaddle.getHeight());
	}
	
}