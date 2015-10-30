package game.events;

import java.util.ArrayList;

public class Events
{
	public static ArrayList<Event> events = new ArrayList<Event>();
	
	public void add(Event newEvent)
	{
		if(hasEvent(newEvent.getClass()))
		{
			return;
		}
		else
		{
			events.add(newEvent);
		}
	}
	
	public void add(EventListenerType listener, Class<? extends Event> event)
	{
		if(hasEvent(event))
		{
			Event currentEvent = getEvent(event);
			currentEvent.register(listener);
		}
	}
	
	private boolean hasEvent(Class<? extends Event> newEvent)
	{
		for(Event currentEvent : events)
		{
			if(currentEvent.getClass() == newEvent)
			{
				return true;
			}
		}
		
		return false;
	}
	
	private Event getEvent(Class<? extends Event> newEvent)
	{
		for(Event currentEvent : events)
		{
			if(currentEvent.getClass() == newEvent)
			{
				return currentEvent;
			}
		}
		
		return null;
	}

	public void activate(Object object, Class<? extends Event> event)
	{
		if(hasEvent(event))
		{
			getEvent(event).activate(object);
		}
	}
	
	public void deleteEvent(Class<? extends Event> event)
	{
		if(hasEvent(event))
		{
			Event currentEvent = getEvent(event);
			events.remove(currentEvent);
		}
	}
}
