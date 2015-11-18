package game.worldmap.camara;

import game.worldmap.WorldMap;

import java.awt.Graphics2D;


public interface Camara
{

	/**
	 * Uses the Map to draw stuff 
	 * 
	 * @param g2d
	 * @param worldMap
	 */
	public abstract void draw(Graphics2D g2d, WorldMap worldMap);
	
}
