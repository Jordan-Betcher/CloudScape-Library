package screen.render;

import game.worldmap.camara.Camara;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class RenderCamara extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Camara camara;
	
	public RenderCamara(Camara camara)
	{
		this.camara = camara;
		
		this.setBackground(Color.BLUE);
		this.setBounds(0, 0, 960, 640);
		
		this.setLayout(new BorderLayout(0, 0));
		//took out menu Panel when I made it so that world Map wasn't inputted her
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
		camara.draw(g2d);
		g2d.translate(-this.getWidth() / 2, -this.getHeight() / 2);	
	}
	
}
