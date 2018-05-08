package states;

import utils.Playable;

public interface State extends Playable
{
	public void init();

	public String getName();
}
