package com.state;

import com.utils.Playable;

public interface State extends Playable
{
	public void init();

	public void enter();

	public void exit();

	public String getName();
}
