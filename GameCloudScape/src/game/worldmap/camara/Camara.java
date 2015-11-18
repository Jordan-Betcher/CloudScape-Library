package game.worldmap.camara;

import game.worldmap.Moveable;
import game.worldmap.Position2D;
import game.worldmap.Position3D;
import game.worldmap.WorldMap;

import java.awt.Graphics2D;


public abstract class Camara implements Moveable
{
	
	private WorldMap map;
	private Position3D xyzPosition;
	
	public Camara(WorldMap map, Position3D xyzPosition)
	{
		this.map = map;
		this.xyzPosition = xyzPosition;
	}
	
	public Camara(WorldMap map, Position2D xyPosition)
	{
		this.map = map;
		this.xyzPosition = new Position3D(xyPosition);
	}
	
	@Override
	public Position3D getPosition3D()
	{
		return xyzPosition;
	}
	
	public void changeMap(WorldMap map)
	{
		this.map = map;
	}

	/**
	 * Uses the Map to draw stuff 
	 * 
	 * @param g2d
	 * @param worldMap
	 */
	public abstract void draw(Graphics2D g2d, WorldMap worldMap);

	public WorldMap getMap()
	{
		return map;
	}
	
}
