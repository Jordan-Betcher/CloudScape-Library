package game.screen;

import game.events.Event;
import game.events.IListener;

import java.awt.event.KeyEvent;

public class KeyPressed extends Event
{

	@Override
	public void activate(Object obj)
	{
		try
		{
			KeyEvent keyEvent = (KeyEvent)obj;
			
			for(IListener listener : super.listeners)
			{
				listener.activate(keyEvent);
			}
		}
		catch(Exception e)
		{
			//TODO change to catch specific exception
			System.out.println("KeyPressed: the object passed in was not of key Event. There is a activator that is passing in the wrong object");
		}
	}
}
