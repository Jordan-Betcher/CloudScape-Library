package game.events;

/**
 * Extending this signifies that this is an Event listener.
 * 
 * @author pplluumm
 * 
 * Example:
 * You create a IKeyPressedListener that extends this, you have it have a method:
 * 		public void activate(KeyEvent keyEvent);
 * You have a KeyPressed Event that when activated sends a KeyEvent to all IKeyPressedListener
 * 
 */
public interface IEventListener
{
}
