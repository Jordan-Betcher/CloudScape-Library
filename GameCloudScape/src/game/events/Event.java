package game.events;

import java.util.ArrayList;

public abstract class Event
{
	protected ArrayList<IListener> listeners = new ArrayList<IListener>();
	
	public void register(IListener listener)
	{
		if(listeners.contains(listener))
		{
			return;
		}
		else
		{
			listeners.add(listener);
		}
	}
	
	public abstract void activate(Object obj);
}
