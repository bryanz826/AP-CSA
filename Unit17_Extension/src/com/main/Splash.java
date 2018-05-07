package com.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

import com.state.GameOver;
import com.state.Menu;
import com.state.States;
import com.state.TestState;
import com.utils.Reference;
import com.utils.Resource;

/**
 * Loads all of the resources for the game
 * @author bryan
 */
public class Splash
{
	/**
	 * A Screen instance with the appropriate layout
	 */
	private Screen	screen;
	
	/**
	 * Counting variable for setting the bar's progress
	 */
	private int		count;

	public Splash()
	{
		screen = new Screen(new Resource(Reference.STATE_LOC + "space_splash.jpg"));
		screen.setLocationRelativeTo(null);
		screen.setMaxProgress(50);
		screen.setVisible(true);

		add(Reference.BULLET_LOC + "blue_hit.png");
		add(Reference.BULLET_LOC + "bullet.png");
		add(Reference.BULLET_LOC + "laser_body.png");
		add(Reference.BULLET_LOC + "laser_hit.png");
		add(Reference.BULLET_LOC + "missile.png");
		add(Reference.BULLET_LOC + "orange_hit.png");
		add(Reference.BULLET_LOC + "pink_hit.png");
		add(Reference.BULLET_LOC + "red_hit.png");
		add(Reference.BULLET_LOC + "rocket.png");

		add(Reference.ENTITY_LOC + "alien.png");
		add(Reference.ENTITY_LOC + "explosion.png");
		add(Reference.ENTITY_LOC + "ship.png");
		add(Reference.ENTITY_LOC + "runaway_ship.png");
		add(Reference.ENTITY_LOC + "walkaway_alien.png");

		add(Reference.FONT_LOC + "live_retro_gray_50x61.png");
		add(Reference.FONT_LOC + "starfighter.png");

		add(Reference.HUD_LOC + "bg_hud.png");
		add(Reference.HUD_LOC + "boss_hud.png");
		add(Reference.HUD_LOC + "FPS_area.png");
		add(Reference.HUD_LOC + "skill_hud.png");

		add(Reference.LEVEL_LOC + "level00.jpg");
		add(Reference.LEVEL_LOC + "level00_blurred.png");
		add(Reference.LEVEL_LOC + "level01.jpg");
		add(Reference.LEVEL_LOC + "level02.jpg");
		add(Reference.LEVEL_LOC + "level03.jpg");
		add(Reference.LEVEL_LOC + "level04.jpg");
		add(Reference.LEVEL_LOC + "level05.jpg");
		add(Reference.LEVEL_LOC + "level05_blurred.png");
		add(Reference.LEVEL_LOC + "level06.jpg");
		add(Reference.LEVEL_LOC + "flat_earth.jpg");

		add(Reference.POWERUP_LOC + "bullet_powerup.png");
		add(Reference.POWERUP_LOC + "hp_powerup.png");
		add(Reference.POWERUP_LOC + "laser_powerup.png");
		add(Reference.POWERUP_LOC + "legendary_powerup.png");
		add(Reference.POWERUP_LOC + "rate_powerup.png");
		add(Reference.POWERUP_LOC + "rocket_powerup.png");
		add(Reference.POWERUP_LOC + "powerup.png");

		add(Reference.STATE_LOC + "gradient.png");
		add(Reference.STATE_LOC + "selection_left.png");
		add(Reference.STATE_LOC + "selection_right.png");
		add(Reference.STATE_LOC + "space_gameover.jpg");
		add(Reference.STATE_LOC + "space_menu.jpg");

		add("icon.png");

		States.addState(new Menu());
//		States.addState(new Level00());
//		States.addState(new Level01());
//		States.addState(new Level02());
//		States.addState(new Level03());
//		States.addState(new Level04());
//		States.addState(new Level05());
//		States.addState(new Level06());
		States.addState(new GameOver());
		
		States.addState(new TestState());

		screen.setVisible(false);
	}

	private void add(String fileName) {
		new Resource(fileName);
		screen.setProgress(count++);
	}
}

/**
 * 
 * @author bryan
 */
@SuppressWarnings("serial")
class Screen extends JWindow
{
	/**
	 * Main layout for the JWindow
	 */
	private BorderLayout	borderLayout;
	
	/**
	 * Label for the splash image
	 */
	private JLabel			imageLabel;
	private JPanel			southPanel;
	private FlowLayout		southFlow;
	private JProgressBar	progressBar;
	private ImageIcon		imageIcon;

	public Screen(Resource res)
	{
		imageIcon = new ImageIcon(res.getImage());
		borderLayout = new BorderLayout();
		imageLabel = new JLabel();
		southPanel = new JPanel();
		southFlow = new FlowLayout();
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);

		init();
	}

	private void init() {
		imageLabel.setIcon(imageIcon);
		getContentPane().setLayout(borderLayout);
		southPanel.setLayout(southFlow);
		southPanel.setBackground(Color.BLACK);
		getContentPane().add(imageLabel, BorderLayout.CENTER);
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		southPanel.add(progressBar, null);
		pack();
	}

	public void setMaxProgress(int maxProgress) {
		progressBar.setMaximum(maxProgress);
	}

	public void setProgress(int progress) {
		float percentage = ((float) progress / (float) progressBar.getMaximum()) * 100;

		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				progressBar.setValue(progress);
				progressBar.setString("Loading: " + (int) percentage + "%");
			}
		});
	}
}
