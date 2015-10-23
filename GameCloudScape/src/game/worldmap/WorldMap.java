package game.worldmap;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class WorldMap implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<ArrayList<Section>> Q1 = new ArrayList<ArrayList<Section>>();
	ArrayList<ArrayList<Section>> Q2 = new ArrayList<ArrayList<Section>>();
	ArrayList<ArrayList<Section>> Q3 = new ArrayList<ArrayList<Section>>();
	ArrayList<ArrayList<Section>> Q4 = new ArrayList<ArrayList<Section>>();
	
	HashMap<Position2D, Section> recentSections = new HashMap<Position2D, Section>();
	

	public void draw(Graphics2D g2d, Entity entity)
	{
		
	}
	public void draw(Graphics2D g2d, Position3D xyzPosition)
	{
		draw(g2d, xyzPosition.getX(), xyzPosition.getY(), xyzPosition.getZ());
	}
	public void draw(Graphics2D g2d, int x, int y, int z)
	{
		//TODO create algorithm that finds all nearby sections and draws them
		//DrawsSections
			//Handles draw things in that section
				//Entities
				//Missles
	}
	
	
	
	public  abstract Section getSection(Position3D xyzPosition);
	public abstract Section getSection(Position2D xyPosition);
	
	public Section getSection(int x, int y)
	{
		if(recentSections.containsKey(new Position2D(x, y)))
		{
			return recentSections.get(new Position2D(x, y));
		}
		else
		{
		
			/*
			 * The -1s offset it because only the last section gets 0,0
			 * So instead of you not being able to acces Q1 0,0  
			 * You can access it with 1,1
			 */
			if( x > 0 && y > 0)
			{
				Section section = getSectionFromQuadrant(x - 1, y - 1, this.Q1);
				return section;
			}
			else if( x < 0 && y > 0)
			{
				Section section = getSectionFromQuadrant(x - 1, y - 1, this.Q2);
				return section;
			}
			else if( x < 0 && y < 0)
			{
				Section section = getSectionFromQuadrant(x - 1, y - 1, this.Q3);
				return section;
			}
			else
			{
				Section section = getSectionFromQuadrant(x, y, this.Q4);
				return section;
			}
		}
	}
	
	private Section getSectionFromQuadrant(int x, int y, ArrayList<ArrayList<Section>> Sections)
	{
		Section section = Sections
							.get(Math.abs(x))
							.get(Math.abs(y));

		recentSections.put(new Position2D(x, y), section);
		
		return section;
	}
	
	public Block getBlock(Position3D xyzPosition)
	{
		return getBlock(xyzPosition.getX(), xyzPosition.getY(), xyzPosition.getZ());
	}
	public abstract Block getBlock(int x, int y, int z);
	
}
