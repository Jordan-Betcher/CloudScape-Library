package game.worldmap;

import java.awt.Graphics2D;

public interface Drawable
{
	public void draw(Graphics2D graphics2D);
	public Position3D getPosition();
}
