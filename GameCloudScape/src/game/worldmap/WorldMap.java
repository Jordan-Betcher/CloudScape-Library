package game.worldmap;

import java.awt.Shape;
import java.util.ArrayList;

public interface WorldMap
{
	public ArrayList<Drawable> getDrawableInArea(Shape shape);
	public void addMoveable(Moveable moveable);
}
