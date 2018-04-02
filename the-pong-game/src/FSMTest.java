import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class FSMTest {

static JFrame frame;

   public static void main(String[] args) {
      frame = new JFrame("Test");

      pressKey();
      GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();



      if (graphicsDevice.isFullScreenSupported()) {
         System.out.println("FS Exclusive Mode supported");
      } else {
         System.out.println("FS Exclusive Mode non supported");
      }
      frame.setUndecorated(true);
      graphicsDevice.setFullScreenWindow(frame);
      
      if (graphicsDevice.isDisplayChangeSupported()) {
         System.out.println("Display change supported");
      } else {
         System.out.println("Display change non supported");
      }
      
      System.out.println("JVM version : "+ System.getProperty("java.version"));
      
   }

   public static void pressKey() {
      final int _KEY = KeyEvent.VK_ESCAPE;
      frame.addKeyListener(new KeyListener() {

         public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == _KEY) {
               System.exit(0);
            }
         }

         public void keyTyped(KeyEvent e) {
         }

         public void keyReleased(KeyEvent e) {
         }

      });
   }
}