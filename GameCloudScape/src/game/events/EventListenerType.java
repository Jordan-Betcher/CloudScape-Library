package game.events;

public abstract class EventListenerType<Information>
{	
	public abstract void activate(Information object);
}
