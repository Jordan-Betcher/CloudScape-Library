
package game.worldmap;

import java.awt.Rectangle;
import java.util.ArrayList;

public interface WorldMap
{
	public ArrayList<Drawable> getDrawableInArea(Rectangle rectangle);
	public void addMoveable(Moveable moveable);
}

