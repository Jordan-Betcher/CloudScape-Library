package game.worldmap;

public class XYCoords
{
	private int x;
	private int y;

	public XYCoords(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public XYCoords(XYZCoords xyzPosition)
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
	
	public void add(int x, int y)
	{
		this.x += x;
		this.y += y;
	}
	
	public void add(XYCoords xyPosition)
	{
		this.x += xyPosition.getX();
		this.y += xyPosition.getY();
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
	    
	    XYCoords other = (XYCoords)o;
	    
	    if(this.x == other.getX() && this.y == other.getY())
	    {
	    	return true;
	    }
	    
	    return false;
	}
	
}
