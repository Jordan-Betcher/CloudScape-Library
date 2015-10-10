package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NormalKeyListener implements KeyListener
{
	//TODO create a eventBus so stuff can register to events
	public void keyPressed(KeyEvent e)
	{
		String key = convertKeyToString(e);
		
	}
	
	public void keyReleased(KeyEvent e)
	{
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
