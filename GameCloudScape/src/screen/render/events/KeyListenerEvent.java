package screen.render.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.events.Event;

public class KeyListenerEvent extends Event<KeyEvent> implements KeyListener
{

	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		this.activate(keyEvent);
	}

	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		this.activate(keyEvent);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
	
}
