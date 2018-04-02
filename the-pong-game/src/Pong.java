import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
//import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;

import collidable_objects.Wall;
import collidable_objects.Ball;
import collidable_objects.Paddle;

import java.awt.Font;

//import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Pong extends Canvas implements KeyListener, Runnable
{
	private int timer = 0;

	private BufferedImage back;
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private Wall wall;
	
	private boolean[] menuSelection;
	private boolean[] controls;

	private Font startFont;
	private Font scoreFont;
	private Font endFont;

	private int leftScore;
	private int rightScore;
	private boolean leftWins;
	private boolean rightWins;

	private boolean loadAnim;
	private boolean menuAnim;
	private boolean roundAnim;
	private boolean gameAnim;
	private boolean endAnim;
	
	private static final int WIDTH = 1536;
	private static final int HEIGHT = 862;
	
	private static final int MIDDLE_X = WIDTH/2;
	private static final int MIDDLE_Y = HEIGHT/2;
	
	public Pong()
	{
		//set up variables
		wall = new Wall(-10, 0, WIDTH, HEIGHT);
		
		menuSelection = new boolean[3];
		controls = new boolean[4];
		
		startFont = new Font(Font.SANS_SERIF, Font.BOLD, 60);
		scoreFont = new Font(Font.SANS_SERIF, Font.PLAIN, 80);
		endFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
		
		leftScore = 0;
		rightScore = 0;
		leftWins = false;
		rightWins = false;
		
		loadAnim = true;
//		loadAnim = false;
//		menuAnim = false;
//		roundAnim = false;
//		gameAnim = false;
//		endAnim = false;
		
		//Graphics
    	setBackground(Color.BLACK);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
	public void update(Graphics window){
		paint(window);
	}

   	public void paint(Graphics window)
   	{
		Graphics2D twoDGraph = (Graphics2D) window; //set up the double buffering to make the game animation nice and smooth

		
		if(back == null)//take snap shot of current screen & save as an image that is exact same width and height as current screen
		   back = (BufferedImage)(createImage(getWidth(), getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


	/**
	 *  LOAD ANIMATION
	 */
		if(loadAnim) 
		{
			int x = MIDDLE_X-110, y = MIDDLE_Y-20;
			
			timer++;
			graphToBack.setFont(startFont);
			
			if(timer == 1) {
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("PONG!", x, y);
			} else if(timer == 50) {
				graphToBack.setColor(Color.ORANGE);
				graphToBack.drawString("PONG!", x, y);
			} else if(timer == 100) {
				graphToBack.setColor(Color.YELLOW);
				graphToBack.drawString("PONG!", x, y);
			} else if(timer == 150) {
				graphToBack.setColor(Color.GREEN);
				graphToBack.drawString("PONG!", x, y);
			} else if(timer == 200) {
				graphToBack.setColor(Color.BLUE);
				graphToBack.drawString("PONG!", x, y);
			} else if(timer == 250) {
				graphToBack.setColor(Color.MAGENTA);
				graphToBack.drawString("PONG!", x, y);
			} else if(timer == 300) {
				graphToBack.setColor(getBackground());
				graphToBack.drawString("PONG!", x, y);
				
				loadAnim = false;
				menuAnim = true;
				timer = 0;
			}
		}
		
	/**
	 *  MENU ANIMATION
	 */
		else if(menuAnim) 
		{
			menuAnim = false;
			roundAnim = true;
		}
		
	/**
	 *  ROUND ANIMATION
	 */
		else if(roundAnim) 
		{
			timer++;
			
			if(timer == 1) {
				
				//new objects
				ball = new Ball(MIDDLE_X-10, MIDDLE_Y-9, 16, 16, Color.BLUE, 0, 0);
				leftPaddle = new Paddle(20, MIDDLE_Y-55, 17, 110, Color.YELLOW, 6);
				rightPaddle = new Paddle(WIDTH-50, MIDDLE_Y-55, 17, 110, Color.YELLOW, 6);
				
			} else if(timer < 150) {
				graphToBack.clearRect(0, 0, WIDTH, HEIGHT);
				
			//SET UP MOST OF GAME
				drawBoardParts(graphToBack);
				
			//BALL STUFF
				ball.moveAndDraw(graphToBack);
				
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
				
				//left player
				if(controls[0] == true) {
					leftPaddle.moveUpAndDraw(graphToBack);
				} else if(controls[1] == true) {
					leftPaddle.moveDownAndDraw(graphToBack);
				} else leftPaddle.moveNothing(graphToBack);
				
				//right player
				if(controls[2] == true) {
					rightPaddle.moveUpAndDraw(graphToBack);
				} else if(controls[3] == true) {
					rightPaddle.moveDownAndDraw(graphToBack);
				} else rightPaddle.moveNothing(graphToBack);
								
			} else if(timer == 150) {
				roundAnim = false;
				gameAnim = true;
				timer = 0;
				
			//FINISH SETUP
				createBall();
			}
		}

	/**
	 * GAME ANIMATION
	 */
		else if(gameAnim)
		{
			graphToBack.clearRect(0, 0, WIDTH, HEIGHT);
			
			//draw objects
			drawBoardParts(graphToBack);
			ball.moveAndDraw(graphToBack);
			leftPaddle.draw(graphToBack);
			rightPaddle.draw(graphToBack);
			
		//BALL STUFF
			if(ball.didCollideLeft(wall)) {
				roundAnim = true;
				rightScore++;
				
				//clear ball and paddle
				ball.setXSpeed(0);
				ball.setYSpeed(0);
				ball.draw(graphToBack, getBackground());
				ball.setPos(MIDDLE_X-8, MIDDLE_Y-8);
				ball.setColor(getBackground());
				
				leftPaddle.draw(graphToBack, getBackground());
				leftPaddle.setColor(getBackground());
				rightPaddle.draw(graphToBack, getBackground());
				rightPaddle.setColor(getBackground());
				
				if(rightScore >= 5) {
					gameAnim = false;
					endAnim = true;
					rightWins = true;
					graphToBack.clearRect(0, 0, WIDTH, HEIGHT);
				}
			}
			
			if(ball.didCollideRight(wall)) {
				roundAnim = true;
				leftScore++;
				
				//clear ball and paddle
				ball.setXSpeed(0);
				ball.setYSpeed(0);
				ball.draw(graphToBack, getBackground());
				ball.setPos(MIDDLE_X-8, MIDDLE_Y-8);
				ball.setColor(getBackground());
				
				leftPaddle.draw(graphToBack, getBackground());
				leftPaddle.setColor(getBackground());
				rightPaddle.draw(graphToBack, getBackground());
				rightPaddle.setColor(getBackground());
				
				if(leftScore >= 5) {
					gameAnim = false;
					endAnim = true;
					leftWins = true;
					graphToBack.clearRect(0, 0, WIDTH, HEIGHT);
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
			if(controls[0] == true) {
				leftPaddle.moveUpAndDraw(graphToBack);
			} else if(controls[1] == true) {
				leftPaddle.moveDownAndDraw(graphToBack);
			} else leftPaddle.moveNothing(graphToBack);
			
			//right player
			if(controls[2] == true) {
				rightPaddle.moveUpAndDraw(graphToBack);
			} else if(controls[3] == true) {
				rightPaddle.moveDownAndDraw(graphToBack);
			} else rightPaddle.moveNothing(graphToBack);
		}
		
	/**
	 * END ANIMATION
	 */
		else if(endAnim) 
		{	
			graphToBack.setFont(endFont);
			graphToBack.setColor(Color.RED);
			
			if(leftWins) {
				endAnimation();
				System.out.println("lol");
				System.exit(0);
			} 
			else if(rightWins) {
				endAnimation();
				System.exit(0);
			}
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
  	
	public void keyPressed(KeyEvent e)
	{
		if(menuAnim)
			switch(e.getKeyCode()) 
			{
				case KeyEvent.VK_UP: 
					break;
				case KeyEvent.VK_DOWN:
					break;
			}
		else if(roundAnim || gameAnim)
			switch(toUpperCase(e.getKeyChar()))
			{
				case 'W' : controls[0] = true; break;
				case 'Z' : controls[1] = true; break;
				case 'I' : controls[2] = true; break;
				case 'M' : controls[3] = true; break;
			}
		
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : controls[0] = false; break;
			case 'Z' : controls[1] = false; break;
			case 'I' : controls[2] = false; break;
			case 'M' : controls[3] = false; break;
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
	
	public void createBall() {
		int xSpd = 7, ySpd = 3;
		int randInt = (int) (Math.random()*4);
		
		if(randInt == 0) xSpd*=-1;
		else if(randInt == 1) ySpd*=-1;
		else if(randInt == 2) {xSpd*=-1; ySpd*=-1;}
		
		ball = new Ball(MIDDLE_X-10, MIDDLE_Y-9, 16, 16, Color.WHITE, xSpd, ySpd);
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
	
	public void drawBoardParts(Graphics window) {
		window.setColor(Color.WHITE);
		
		//draw midline
		int x = MIDDLE_X-9, wid = 16, ht = 40;
		for(int y = -15; y < HEIGHT; y+=60) {
			window.fillRect(x, y, wid, ht);
		}
		
		//draw center circle
		window.fillOval(MIDDLE_X-52, MIDDLE_Y-51, 100, 100);
		window.setColor(getBackground());
		window.fillOval(MIDDLE_X-40, MIDDLE_Y-39, 76, 76);

		//draw scoring
		window.setFont(scoreFont);
		window.setColor(Color.WHITE);
		window.drawString(""+leftScore, MIDDLE_X-300, 125);
		window.drawString(""+rightScore, MIDDLE_X+250, 125);
		
	}
	
	public void endAnimation() {
		
		timer++;
		
		
		
		
		
		
	}
}