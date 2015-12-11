package screen.render.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import game.events.Event;

public class MouseKeyPressedEvent extends Event<MouseEvent> implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		this.activate(e);
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
}
