package game;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WorldMap worldMap;
	private RenderPanel renderPanel;
	
	public Screen()
	{
		//TODO generate a real world Map

		this.createScreen(new WorldMap());
	}
	
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
		
		this.worldMap = worldMap;
		this.addKeyListener(new NormalKeyListener());
		this.setFocusable(true);
		
		renderPanel = new RenderPanel(this.worldMap);
		
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
