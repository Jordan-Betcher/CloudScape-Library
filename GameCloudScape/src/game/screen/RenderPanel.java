package game.screen;

import game.worldmap.Moveable;
import game.worldmap.WorldMap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class RenderPanel extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WorldMap worldMap;
	private Moveable player;
	
	public RenderPanel(WorldMap worldMap, Moveable player)
	{
		this.worldMap = worldMap;
		this.player = player;
		
		this.setBackground(Color.BLUE);
		this.setBounds(0, 0, 960, 640);
		
		JPanel menuPanel = new MenuPanel(worldMap);
		
		this.setLayout(new BorderLayout(0, 0));
		
		this.add(menuPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.yellow);
	}
	
	protected void drawMap(Graphics2D g2d)
	{
		g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
		worldMap.draw(g2d, player.getPosition3D());
		g2d.translate(-this.getWidth() / 2, -this.getHeight() / 2);	
	}
	
}
