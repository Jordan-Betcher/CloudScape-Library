package game.events;

public class EventListenerHolder<Information> implements EventListenerType<Information>
{

	private Information object;
	
	@Override
	public void activate(Information object)
	{
		this.object = object;
	}
	
	public Information get()
	{
		return object;
	}
	
}
