package game.events;

import game.screen.IKeyPressedListener;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * 
 * @author pplluumm
 *
 *Example:
    public void activate(Object obj)
	{
		try
		{
			YourObject yourObject = (YourObject)obj;
			
			for(YourListener listener : listeners)
			{
				listener.activate(yourObject);
			}
		}
		catch(Exception e)
		{
			System.out.println("YourClass: the object passed in was not of YourObject. There is a activator that is passing in the wrong object");
		}
	}

	@Override
	public void register(YourListener listener)
	{
		try
		{
			listeners.add((YourListener)listener);
		}
		catch(Exception e)
		{
			System.out.println("YourClass: the listener passed in was not of YourListener. The wrong listener is trying to get registered");
		}
		
	}
 */
public interface IEvent
{
	public void register(IEventListener listener);
	public abstract void activate(Object obj);
}
