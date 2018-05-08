package managers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.Ball;
import entities.Block;
import entities.Paddle;
import entities.Wall;
import utils.Keys;
import utils.Playable;
import utils.Reference;

public class EntityManager implements Playable
{
	private static final List<Wall>		WALLS	= new ArrayList<Wall>(4);
	private static final List<Block>	BLOCKS	= new ArrayList<Block>();

	private Ball						ball;
	private Paddle						paddle;
	private Wall						leftWall;
	private Wall						rightWall;
	private Wall						topWall;
	private Wall						bottomWall;

	public EntityManager()
	{
		WALLS.add(leftWall = new Wall(11, Reference.CENTER_Y, 20, Reference.HEIGHT - 42));
		WALLS.add(rightWall = new Wall(Reference.WIDTH - 11, Reference.CENTER_Y, 20, Reference.HEIGHT - 42));
		WALLS.add(topWall = new Wall(Reference.CENTER_X, 11, Reference.WIDTH - 42, 20));
		WALLS.add(bottomWall = new Wall(Reference.CENTER_X, Reference.HEIGHT - 11, Reference.WIDTH - 42, 20));
		restart();
	}

	public void addBlocks(int hp) {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				if (x < 2 || x > 7 || y < 2 || y > 7)
					BLOCKS.add(new Block(75.8 * x + 59.8, 75.8 * y + 59.8, 73.8, 73.8, hp));
			}
		}
	}

	public void restart() {
		ball = new Ball(Reference.CENTER_X + 20, Reference.CENTER_Y - 50, 5, 5);
		paddle = new Paddle(Reference.CENTER_X, Reference.CENTER_Y + 50, 4.5, 4.5);
		BLOCKS.clear();
	}

	@Override
	public void processInput() {
		if (Keys.wasPressed(Keys.R)) ball = new Ball(Reference.CENTER_X + 20, Reference.CENTER_Y - 50, 5, 5);
		paddle.processInput();
	}

	@Override
	public void update() {
		// paddle and blocks collision
		for (Block block : BLOCKS) {
			if (paddle.getBounds().intersects(block.getBounds())) {
				for (int i = 0; i < block.getFullBounds().size(); i++) {
					if (paddle.getBounds().intersects(block.getFullBounds().get(i))) {
						if (i == block.LEFT_MIDDLE) paddle.setX(block.getX() - paddle.getWidth());
						else if (i == block.RIGHT_MIDDLE) paddle.setX(block.getX() + block.getWidth());
						else if (i == block.TOP_MIDDLE) paddle.setY(block.getY() - paddle.getHeight());
						else if (i == block.BOTTOM_MIDDLE) paddle.setY(block.getY() + block.getHeight());
						else if (i == block.TOP_LEFT) ;
						else if (i == block.TOP_RIGHT) ;
						else if (i == block.BOTTOM_LEFT) ;
						else if (i == block.BOTTOM_RIGHT) ;
					}
				}
			}
		}

		// ball and blocks collision also remove when necessary
		for (Iterator<Block> iter = BLOCKS.iterator(); iter.hasNext();) {
			Block block = iter.next();
			if (ball.getBounds().intersects(block.getBounds())) {
				block.damage(ball.getDamage());
				for (int i = 0; i < block.getFullBounds().size(); i++) {
					if (ball.getBounds().intersects(block.getFullBounds().get(i))) {
						if (i == block.LEFT_MIDDLE) ball.accelNegX();
						else if (i == block.RIGHT_MIDDLE) ball.accelPosX();
						else if (i == block.TOP_MIDDLE) ball.accelNegY();
						else if (i == block.BOTTOM_MIDDLE) ball.accelPosY();
						else if (i == block.TOP_LEFT) {
							ball.accelNegX();
							ball.accelNegY();
						} else if (i == block.TOP_RIGHT) {
							ball.accelPosX();
							ball.accelNegY();
						} else if (i == block.BOTTOM_LEFT) {
							ball.accelNegX();
							ball.accelPosY();
						} else if (i == block.BOTTOM_RIGHT) {
							ball.accelPosX();
							ball.accelPosY();
						}
					}
				}
				if (block.isDead()) iter.remove();
			}
		}

		// paddle and wall collision
		for (Wall wall : WALLS) {
			if (paddle.getBounds().intersects(wall.getBounds())) {
				if (wall.equals(leftWall)) paddle.setX(leftWall.getX() + leftWall.getWidth());
				if (wall.equals(rightWall)) paddle.setX(rightWall.getX() - paddle.getWidth());
				if (wall.equals(topWall)) paddle.setY(topWall.getY() + topWall.getHeight());
				if (wall.equals(bottomWall)) paddle.setY(bottomWall.getY() - paddle.getHeight());
			}
		}

		// ball and wall collision
		for (Wall wall : WALLS) {
			if (ball.getBounds().intersects(wall.getBounds())) {
				if (wall.equals(leftWall)) ball.accelPosX();
				else if (wall.equals(rightWall)) ball.accelNegX();
				else if (wall.equals(topWall)) ball.accelPosY();
				else if (wall.equals(bottomWall)) ball.accelNegY();
			}
		}

		// ball and paddle collision
		if (ball.getBounds().intersects(paddle.getBounds())) {
			for (int i = 0; i < paddle.getFullBounds().size(); i++) {
				if (ball.getBounds().intersects(paddle.getFullBounds().get(i))) {
					if (i == paddle.TOP_LEFT) {
						ball.accelNegX();
						ball.accelNegY();
					} else if (i == paddle.TOP_MIDDLE) ball.accelNegY();
					else if (i == paddle.TOP_RIGHT) {
						ball.accelPosX();
						ball.accelNegY();
					} else if (i == paddle.LEFT_MIDDLE) ball.accelNegX();
					else if (i == paddle.RIGHT_MIDDLE) ball.accelPosX();
					else if (i == paddle.BOTTOM_LEFT) {
						ball.accelNegX();
						ball.accelPosY();
					} else if (i == paddle.BOTTOM_MIDDLE) ball.accelPosY();
					else if (i == paddle.BOTTOM_RIGHT) {
						ball.accelPosX();
						ball.accelPosY();
					}
				}
			}
		}

		ball.update();
		paddle.update();
		for (Wall wall : WALLS)
			wall.update();
	}

	@Override
	public void render(Graphics2D g) {
		ball.render(g);
		paddle.render(g);
		for (Block blocks : BLOCKS)
			blocks.render(g);
		for (Wall wall : WALLS)
			wall.render(g);
	}
	
	public static List<Block> getBlocks() {
		return BLOCKS;
	}
}
