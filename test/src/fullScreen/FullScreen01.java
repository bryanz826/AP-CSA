package fullScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FullScreen01 extends JFrame implements ActionListener
{
	private GraphicsDevice graphicsDevice;
	private DisplayMode origDisplayMode;
	private JButton exitButton;
	
	public FullScreen01(GraphicsDevice graphicsDevice) {
		this.graphicsDevice = graphicsDevice;
		exitButton = new JButton("Exit Full-Screen Mode");
		
		setTitle("This title will be hidden (undecorated)");
		origDisplayMode = graphicsDevice.getDisplayMode();
		
		exitButton.addActionListener(this);
	    
	    getContentPane().add(exitButton, BorderLayout.NORTH);

	    JLabel eastLabel = new JLabel("     East     ");
	    eastLabel.setOpaque(true);
	    eastLabel.setBackground(Color.RED);
	    getContentPane().add(eastLabel, BorderLayout.EAST);
	    
	    JLabel southLabel = new JLabel("South", SwingConstants.CENTER);
	    southLabel.setOpaque(true);
	    southLabel.setBackground(Color.GREEN);
	    getContentPane().add(southLabel, BorderLayout.SOUTH);
	    
	    JLabel westLabel = new JLabel("     West     ");
	    westLabel.setOpaque(true);
	    westLabel.setBackground(Color.RED);
	    getContentPane().add(westLabel, BorderLayout.WEST);
	    
	    JLabel centerLabel = new JLabel("Center", SwingConstants.CENTER);
	    centerLabel.setOpaque(true);
	    centerLabel.setBackground(Color.WHITE);
	    getContentPane().add(centerLabel, BorderLayout.CENTER);
		System.out.println(origDisplayMode);
		
		if (graphicsDevice.isFullScreenSupported()){
		      setUndecorated(true);
		      setResizable(false);
		      graphicsDevice.setFullScreenWindow(this);
		      validate();
		} else {
		      System.out.println("Full-screen mode not supported");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	    graphicsDevice.setDisplayMode(origDisplayMode);
	    System.exit(0);
	}

	public static void main(String[] args){

		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
	    GraphicsDevice[] devices =  graphicsEnvironment.getScreenDevices();

		for(int c = 0; c < 1; c++){
		  	System.out.println(devices[c]);
		}
		new FullScreen01(devices[0]);
	}
}