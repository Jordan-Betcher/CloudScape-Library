package game.screen;

import game.events.EventListener;

import java.awt.event.KeyEvent;

public interface KeyPressedListener extends EventListener
{
	public void activate(KeyEvent keyEvent);
}
