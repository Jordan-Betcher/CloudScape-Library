package screen.render;

import game.worldmap.Moveable;
import game.worldmap.WorldMap;
import game.worldmap.camara.Camara;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class RenderMapPanel extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WorldMap worldMap;
	private Camara camara;
	
	public RenderMapPanel(WorldMap worldMap, Camara camara)
	{
		this.worldMap = worldMap;
		this.camara = camara;
		
		this.setBackground(Color.BLUE);
		this.setBounds(0, 0, 960, 640);
		
		JMenuBar menuPanel = new MenuPanel(worldMap);
		
		this.setLayout(new BorderLayout(0, 0));
		
		this.add(menuPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		drawMap(g2d);
	}
	
	private void drawMap(Graphics2D g2d)
	{
		g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
		camara.draw(g2d, worldMap);
		g2d.translate(-this.getWidth() / 2, -this.getHeight() / 2);	
	}
	
}
