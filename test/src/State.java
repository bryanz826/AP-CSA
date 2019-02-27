public interface State extends Playable
{
  void init();
  void enter();
  void exit();
  String getName();
}
