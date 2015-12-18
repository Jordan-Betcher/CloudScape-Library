package game.worldmap;

public class XY
{
	private int x;
	private int y;

	public XY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public XY(XYZ xyzPosition)
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
	
	public void add(XY xyPosition)
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
	    
	    XY other = (XY)o;
	    
	    if(this.x == other.getX() && this.y == other.getY())
	    {
	    	return true;
	    }
	    
	    return false;
	}
	
}
