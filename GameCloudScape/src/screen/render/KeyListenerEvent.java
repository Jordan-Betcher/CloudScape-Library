package screen.render;

import java.awt.event.KeyListener;
import java.util.ArrayList;

import game.events.Event;

public class KeyListenerEvent extends Event<ArrayList<Character>> implements KeyListener
{
	private ArrayList<Character> chars = new ArrayList<Character>();

	@Override
	public void keyPressed(java.awt.event.KeyEvent e)
	{
		addChar(e.getKeyChar());
	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent e)
	{
		removeChar(e.getKeyChar());
	}

	@Override
	public void keyTyped(java.awt.event.KeyEvent e)
	{
		
	}
	
	private void addChar(char input)
	{
		if( ! chars.contains(input))
		{
			chars.add(input);
			this.activate(chars);
		}
	}
	
	private void removeChar(char input)
	{
		if(chars.contains(input))
		{
			chars.remove(input);
			this.activate(chars);
		}
	}
	
}
