package game.worldmap;

public class XY
{
	private double x;
	private double y;

	public XY(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public XY(XYZ xyzPosition)
	{
		this.x = xyzPosition.getX();
		this.y = xyzPosition.getY();
	}

	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	@Override
	public int hashCode() 
	{
        return 0;
    }
	
	public void add(double x, double y)
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
