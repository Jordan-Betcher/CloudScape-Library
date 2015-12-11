package game.events;

public interface EventListenerType<Information>
{	
	/*
	 * Unfortunately you won't be able to implement several listeners in the same class
	 * (i.e. MouseEventListener (EventListenerType<MouseEvent>) and a KeyEventListener (EventListenerType<ArrayList<Character>))
	 * Since Java doesn't deem it fit
	 * 
	 * So to have multiple listener (like if you are doing for a person mouse and keyboard events
	 * and wanted to be able to access both in the same class) You will have to create to objects 
	 * and when they are activated to tell the class you wanted (i.e. the player class)
	 */
	public void activate(Information object);
}
