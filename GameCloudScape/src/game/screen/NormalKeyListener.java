package game.screen;

import game.events.Events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NormalKeyListener implements KeyListener
{
	public NormalKeyListener()
	{
		Events.register(new KeyPressedEvent());
	}
	
	public void keyPressed(KeyEvent e)
	{
		String key = convertKeyToString(e);
		Events.activate(e, KeyPressedEvent.class);
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		//TODO add a key released to events
		String key = convertKeyToString(e);
	}
	
	public void keyTyped(KeyEvent e)
	{
		
	}
	
	public String convertKeyToString(KeyEvent e)
	{
		return KeyEvent.getKeyText(e.getKeyCode());
	}
	
}
