package game.events;

import java.util.ArrayList;

public class Event<Information>
{
	private ArrayList<EventListenerType<Information>> listeners = new ArrayList<EventListenerType<Information>>();

	public void register(EventListenerType<Information> listener)
	{
		listeners.add(listener);
	}

	public void activate(Information object)
	{
		for(EventListenerType<Information> listener : listeners)
		{
			listener.activate(object);
		}
	}
	
}
