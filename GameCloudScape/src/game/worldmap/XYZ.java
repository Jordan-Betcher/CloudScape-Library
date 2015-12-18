package game.worldmap;

public class XYZ
{
	private double x;
	private double y;
	private double z;
	
	
	public XYZ(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public XYZ(XY xyPosition, double z)
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
	
	public double getX()
	{
		return this.x;
	}
	public double getY()
	{
		return this.y;
	}
	public double getZ()
	{
		return this.z;
	}
	
	public void add(double x, double y)
	{
		this.x += x;
		this.y += y;
	}
	
	public void add(double x, double y, double z)
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
