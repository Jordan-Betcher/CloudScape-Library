package game.events;

import java.util.ArrayList;

public abstract class Event
{
	private ArrayList<IListener> listeners = new ArrayList<IListener>();
	
	protected abstract void activated();
	
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
	
	protected void activiate()
	{
		for(IListener listener : listeners)
		{
			listener.activate();
		}
	}
}
