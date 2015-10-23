package game.events;

import java.util.ArrayList;

public class Events
{
	public static ArrayList<IEvent> events = new ArrayList<IEvent>();
	
	public static void register(IEvent newEvent)
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
	
	public static void register(IEventListener listener, Class<? extends IEvent> event)
	{
		if(hasEvent(event))
		{
			IEvent currentEvent = getEvent(event);
			currentEvent.register(listener);
		}
	}
	
	private static boolean hasEvent(Class<? extends IEvent> newEvent)
	{
		for(IEvent currentEvent : events)
		{
			if(currentEvent.getClass() == newEvent)
			{
				return true;
			}
		}
		
		return false;
	}
	
	private static IEvent getEvent(Class<? extends IEvent> newEvent)
	{
		for(IEvent currentEvent : events)
		{
			if(currentEvent.getClass() == newEvent)
			{
				return currentEvent;
			}
		}
		
		return null;
	}

	public static void activate(Object object, Class<? extends IEvent> event)
	{
		if(hasEvent(event))
		{
			getEvent(event).activate(object);
		}
	}
	
	public static void deleteEvent(Class<? extends IEvent> event)
	{
		if(hasEvent(event))
		{
			IEvent currentEvent = getEvent(event);
			events.remove(currentEvent);
		}
	}
}
