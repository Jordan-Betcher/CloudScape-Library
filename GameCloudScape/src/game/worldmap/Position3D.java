package game.worldmap;

public class Position3D
{
	private int x;
	private int y;
	private int z;
	
	
	public Position3D(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Position3D(Position2D xyPosition, int z)
	{
		this.x = xyPosition.getX();
		this.y = xyPosition.getY();
		this.z = z;
	}
	public Position3D(Position2D xyPosition)
	{
		this.x = xyPosition.getX();
		this.y = xyPosition.getY();
		this.z = 0;
	}
	
	public Position2D get2DPosition()
	{
		return new Position2D(x,y);
	}
	
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public int getZ()
	{
		return this.z;
	}
	
	public void add(int x, int y)
	{
		this.x += x;
		this.y += y;
	}
	
	public void add(int x, int y, int z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public void add(Position2D xyPosition)
	{
		this.x += xyPosition.getX();
		this.y += xyPosition.getY();
	}
	
	public void add(Position3D xyzPosition)
	{
		this.x += xyzPosition.getX();
		this.y += xyzPosition.getY();
		this.z += xyzPosition.getZ();
	}
	
	@Override
	public int hashCode() 
	{
        return 0;
    }

	 @Override
    public boolean equals(Object o) 
 	{
	    if (o == null)
	    {
	       return false;
	    }
	        
	    if (o == this)
	    {
	       return true;
	    }
	        
	    if (o.getClass() != getClass())
	    {
	       return false;
	    }
	    
	    Position3D other = (Position3D)o;
	    
	    if(this.x == other.getX() && this.y == other.getY() && this.z == other.getZ())
	    {
	    	return true;
	    }
	    
	    return false;
	}
}
