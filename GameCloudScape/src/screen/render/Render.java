package screen.render;

import game.events.Events;
import game.worldmap.camara.Camara;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import screen.render.events.KeyListenerEvent;
import screen.render.events.MouseKeyPressedEvent;

public class Render extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CamaraRenderer renderPanel;
	
	/**
	 * Creates a screen that displays the passed in WorldMap
	 * 
	 * @author pplluumm
	 * @param events 
	 * @param worldMap is the precreated world that will be loaded onto the screen
	 */
	public Render(Camara camara, Events events)
	{
		this.createScreen(camara);
		
		KeyListenerEvent keyListenerEvent = new KeyListenerEvent();
		this.addKeyListener(keyListenerEvent);
		events.add(keyListenerEvent);
		
		MouseKeyPressedEvent mouseKeyPressedEvent = new MouseKeyPressedEvent();
		this.addMouseListener(mouseKeyPressedEvent);
		events.add(mouseKeyPressedEvent);
	}
	
	private void createScreen(Camara camara)
	{
		JPanel panel = new JPanel();
		this.setSize(960, 640);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setFocusable(true);
		
		renderPanel = new CamaraRenderer(camara);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(renderPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		
		this.setFocusable(true);
		
		this.requestFocus();
	}
	
	public void end()
	{
		this.dispose();
		
	}
}
