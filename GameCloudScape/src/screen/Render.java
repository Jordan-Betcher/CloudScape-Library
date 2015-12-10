package screen;

import game.worldmap.WorldMap;
import game.worldmap.camara.Camara;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import screen.render.RenderMapPanel;

public class Render extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RenderMapPanel renderPanel;
	
	/**
	 * Creates a screen that displays the passed in WorldMap
	 * 
	 * @author pplluumm
	 * @param worldMap is the precreated world that will be loaded onto the screen
	 */
	public Render(WorldMap worldMap, Camara camara)
	{
		this.createScreen(worldMap, camara);
	}
	
	private void createScreen(WorldMap worldMap, Camara camara)
	{
		JPanel panel = new JPanel();
		this.setSize(960, 640);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setFocusable(true);
		
		renderPanel = new RenderMapPanel(camara);
		
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
