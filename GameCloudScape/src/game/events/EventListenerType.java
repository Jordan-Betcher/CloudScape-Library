package game.events;

public interface EventListenerType<Information>
{	
	/**
	 * Unfortunately you won't be able to implement several listeners in the same class
	 * (i.e. MouseEventListener (EventListenerType<MouseEvent>) and a KeyEventListener (EventListenerType<ArrayList<Character>))
	 * Since Java doesn't deem it fit
	 * 
	 * So to have multiple listener (like if you are doing for a person mouse and keyboard events
	 * and wanted to be able to access both in the same class) 
	 * public void activate( Object obj)
	 *	{
	 *		if(obj instanceof Character)
	 *		{
	 *			this.chars.add((Character) obj);
	 *		}
	 *		else if(obj instanceof MouseEvent)
	 *		{
	 *			this.mouseEvent = (MouseEvent) obj;
	 *		}
	 *		else
	 *		{
	 *			//Do nothing
	 *		}
	 *	} 
	 *
	 * OR 
	 * 
	 * create two classes that each use one of the interfaces and then when ever that is activated modify the player class
	 **/
	public void activate(Information object);
}
