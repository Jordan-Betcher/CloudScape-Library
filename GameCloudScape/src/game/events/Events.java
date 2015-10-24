package game.events;

import java.util.ArrayList;

public class Events
{
	public static ArrayList<Event> events = new ArrayList<Event>();
	
	public static void register(Event newEvent)
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
	
	public static void register(EventListener listener, Class<? extends Event> event)
	{
		if(hasEvent(event))
		{
			Event currentEvent = getEvent(event);
			currentEvent.register(listener);
		}
	}
	
	private static boolean hasEvent(Class<? extends Event> newEvent)
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
	
	private static Event getEvent(Class<? extends Event> newEvent)
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

	public static void activate(Object object, Class<? extends Event> event)
	{
		if(hasEvent(event))
		{
			getEvent(event).activate(object);
		}
	}
	
	public static void deleteEvent(Class<? extends Event> event)
	{
		if(hasEvent(event))
		{
			Event currentEvent = getEvent(event);
			events.remove(currentEvent);
		}
	}
}
