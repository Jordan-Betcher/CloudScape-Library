package game.events;

public abstract class EventListenerType<Information>
{
	public EventListenerType(Events events)
	{
		events.add(new Event<Information>());
	}
	
	public abstract void activate(Information object);
}
