package game.screen;

import game.worldmap.Entity;
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
	private Entity entity;
	
	public RenderPanel(WorldMap worldMap, Entity entity)
	{
		this.worldMap = worldMap;
		this.entity = entity;
		
		this.setBackground(Color.BLUE);
		this.setBounds(0, 0, 960, 640);
		
		JPanel AbilitiesPanel = new FightInfoPanel();
		JPanel menuPanel = new MenuPanel(worldMap);
		
		this.setLayout(new BorderLayout(0, 0));
		
		this.add(menuPanel, BorderLayout.NORTH);
		this.add(AbilitiesPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.yellow);
		
		g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
		worldMap.draw(g2d, entity.getPosition3D());
		g2d.translate(-this.getWidth() / 2, -this.getHeight() / 2);		
	}
	
}
