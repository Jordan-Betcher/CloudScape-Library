package screen.render;

import game.worldmap.camara.Camara;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Render extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CamaraRenderer renderPanel;
	private KeyListenerEvent keyEvent;
	
	/**
	 * Creates a screen that displays the passed in WorldMap
	 * 
	 * @author pplluumm
	 * @param events 
	 * @param worldMap is the precreated world that will be loaded onto the screen
	 */
	public Render(Camara camara)
	{
		this.createScreen(camara);
		this.keyEvent = new KeyListenerEvent();
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

	public KeyListenerEvent getKeyListenerEvent()
	{
		return this.keyEvent;
	}
}
