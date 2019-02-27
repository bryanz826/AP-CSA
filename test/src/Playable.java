import java.awt.Graphics2D;

public interface Playable
{
  void processInput();
  void update();
  void render(Graphics2D g);
}
