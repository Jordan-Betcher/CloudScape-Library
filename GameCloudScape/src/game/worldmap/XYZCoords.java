package game.worldmap;

public class XYZCoords
{
	private int x;
	private int y;
	private int z;
	
	
	public XYZCoords(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public XYZCoords(XYCoords xyPosition, int z)
	{
		this.x = xyPosition.getX();
		this.y = xyPosition.getY();
		this.z = z;
	}
	public XYZCoords(XYCoords xyPosition)
	{
		this.x = xyPosition.getX();
		this.y = xyPosition.getY();
		this.z = 0;
	}
	
	public XYCoords get2DPosition()
	{
		return new XYCoords(x,y);
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
	
	public void add(XYCoords xyPosition)
	{
		this.x += xyPosition.getX();
		this.y += xyPosition.getY();
	}
	
	public void add(XYZCoords xyzPosition)
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
	    
	    XYZCoords other = (XYZCoords)o;
	    
	    if(this.x == other.getX() && this.y == other.getY() && this.z == other.getZ())
	    {
	    	return true;
	    }
	    
	    return false;
	}
}
