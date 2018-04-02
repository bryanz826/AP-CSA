import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class FullWindow extends JFrame 
{
	private boolean isFullScreen = false;
    private GraphicsDevice device;

    public FullWindow(GraphicsDevice device) {
        this.device = device;
        initFullScreen();
    }

    private void initFullScreen() {
        isFullScreen = device.isFullScreenSupported();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(isFullScreen);
        setUndecorated(isFullScreen);
        setResizable(!isFullScreen);
        if (isFullScreen) {
            // Full-screen mode
            device.setFullScreenWindow(this);
            validate();
        } else {
            System.out.println("L");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice device = env.getDefaultScreenDevice();
                new FullWindow(device);
            }
        });
    }
}