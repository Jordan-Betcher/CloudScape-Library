package game.worldmap;

public class XYZ
{
	private int x;
	private int y;
	private int z;
	
	
	public XYZ(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public XYZ(XY xyPosition, int z)
	{
		this.x = xyPosition.getX();
		this.y = xyPosition.getY();
		this.z = z;
	}
	public XYZ(XY xyPosition)
	{
		this.x = xyPosition.getX();
		this.y = xyPosition.getY();
		this.z = 0;
	}
	
	public XY get2DPosition()
	{
		return new XY(x,y);
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
	
	public void add(XY xyPosition)
	{
		this.x += xyPosition.getX();
		this.y += xyPosition.getY();
	}
	
	public void add(XYZ xyzPosition)
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
	    
	    XYZ other = (XYZ)o;
	    
	    if(this.x == other.getX() && this.y == other.getY() && this.z == other.getZ())
	    {
	    	return true;
	    }
	    
	    return false;
	}
}
