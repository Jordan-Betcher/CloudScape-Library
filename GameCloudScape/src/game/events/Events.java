package game.events;

import java.awt.event.KeyEvent;
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
	
	public static void register(IListener listener, Class<? extends Event> event)
	{
		if(hasEvent(event))
		{
			Event oldEvent = getEvent(event);
			oldEvent.register(listener);
		}
	}
	
	private static boolean hasEvent(Class<? extends Event> newEvent)
	{
		for(Event oldEvent : events)
		{
			if(oldEvent.getClass() == newEvent)
			{
				return true;
			}
		}
		
		return false;
	}
	
	private static Event getEvent(Class<? extends Event> newEvent)
	{
		for(Event oldEvent : events)
		{
			if(oldEvent.getClass() == newEvent)
			{
				return oldEvent;
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
}
