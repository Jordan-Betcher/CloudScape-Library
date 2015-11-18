package game.worldmap;

public class Position2D
{
	private int x;
	private int y;

	public Position2D(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public Position2D(Position3D xyzPosition)
	{
		this.x = xyzPosition.getX();
		this.y = xyzPosition.getY();
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
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
	    
	    Position2D other = (Position2D)o;
	    
	    if(this.x == other.getX() && this.y == other.getY())
	    {
	    	return true;
	    }
	    
	    return false;
	}
	
}
