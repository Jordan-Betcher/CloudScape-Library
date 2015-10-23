package game.screen;

import game.events.IEventListener;

import java.awt.event.KeyEvent;

public interface IKeyPressedListener extends IEventListener
{
	public void activate(KeyEvent keyEvent);
}
