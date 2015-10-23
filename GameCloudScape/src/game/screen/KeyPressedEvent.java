package game.screen;

import game.events.IEvent;
import game.events.IEventListener;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyPressedEvent implements IEvent
{
	private ArrayList<IKeyPressedListener> listeners = new ArrayList<IKeyPressedListener>();
	
	public void activate(Object obj)
	{
		try
		{
			KeyEvent keyEvent = (KeyEvent)obj;
			
			for(IKeyPressedListener listener : listeners)
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
	public void register(IEventListener listener)
	{
		try
		{
			listeners.add((IKeyPressedListener)listener);
		}
		catch(Exception e)
		{
			//TODO change to catch specific exception
			System.out.println("KeyPressed: the listener passed in was not of IKeyPressedListener. The wrong listener is trying to get registered");
		}
		
	}
}
