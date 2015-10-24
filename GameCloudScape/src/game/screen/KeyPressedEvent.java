package game.screen;

import game.events.Event;
import game.events.EventListener;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyPressedEvent implements Event
{
	private ArrayList<KeyPressedListener> listeners = new ArrayList<KeyPressedListener>();
	
	public void activate(Object obj)
	{
		try
		{
			KeyEvent keyEvent = (KeyEvent)obj;
			
			for(KeyPressedListener listener : listeners)
			{
				listener.activate(keyEvent);
			}
		}
		catch(Exception e)
		{
			//TODO change to catch specific exception
			System.out.println("KeyPressed: the object passed in was not of KeyEvent. There is a activator that is passing in the wrong object");
		}
	}

	@Override
	public void register(EventListener listener)
	{
		try
		{
			listeners.add((KeyPressedListener)listener);
		}
		catch(Exception e)
		{
			//TODO change to catch specific exception
			System.out.println("KeyPressed: the listener passed in was not of IKeyPressedListener. The wrong listener is trying to get registered");
		}
		
	}
}
