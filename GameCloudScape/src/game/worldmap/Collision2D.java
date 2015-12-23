package game.worldmap;

public class Collision2D
{


	public static double distanceBetween(XY xy1, XY xy2)
	{
		double x1 = xy1.getX();
		double x2 = xy2.getX();
		
		double y1 = xy1.getY();
		double y2 = xy2.getY();
		
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
	
	
	//Helpful http://gamedev.stackexchange.com/questions/18340/get-position-of-point-on-circumference-of-circle-given-an-angle
	public static XY move(XY startPosition, XY endPosition, double speed)
	{
		
		double angle = getAngle(startPosition, endPosition);
		double x = Math.cos(angle) * speed;
		double y = Math.sin(angle) * speed;
		
		//You have to flip it if x is negative or else it will only do it one way
		if(startPosition.getX() - endPosition.getX() > 0)
		{
			x = -x;
			y = -y;
		}
		
		return new XY(x, y);
	}
	
	public static double getAngle(XY startPosition, XY endPosition)
	{
		double xDistance = startPosition.getX() - endPosition.getX();
		double yDistance = startPosition.getY() - endPosition.getY();
	
		return Math.atan(yDistance/xDistance);
	}
}
