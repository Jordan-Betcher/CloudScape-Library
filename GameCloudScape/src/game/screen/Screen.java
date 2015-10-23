package game.screen;

import game.worldmap.WorldMap;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RenderPanel renderPanel;
	
	/**
	 * Creates a screen that displays a new WorldMap
	 * 
	 * @author pplluumm
	 * @param worldMap is the precreated world that will be loaded onto the screen
	 */
	public Screen()
	{
		//TODO generate a real world Map
	}
	/**
	 * Creates a screen that displays the passed in WorldMap
	 * 
	 * @author pplluumm
	 * @param worldMap is the precreated world that will be loaded onto the screen
	 */
	public Screen(WorldMap worldMap)
	{
		this.createScreen(worldMap);
	}
	
	private void createScreen(WorldMap worldMap)
	{
		JPanel panel = new JPanel();
		this.setSize(960, 640);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addKeyListener(new NormalKeyListener());
		this.setFocusable(true);
		
		//renderPanel = new RenderPanel(worldMap);
		
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
