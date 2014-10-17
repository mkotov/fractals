package zbuffer;

import base.*;
import java.awt.image.BufferedImage;

public class ZBufferAction implements Action
{
	private ZBuffer buffer;
	private BufferedImage image;
	private Triangle triangle;
	private Solid solid;
	private Vector sun;
	
	public ZBufferAction(Solid solid, ZBuffer buffer, BufferedImage image, Vector sun)
	{
		this.buffer = buffer;
		this.image = image;
		this.solid = solid;
		this.sun = sun;
	}
	
	public void setTriangle(Triangle triangle)
	{
		this.triangle = triangle;
	}
	
	private int getXFromYZ(Triangle triangle, int x, int y)
	{
		Vector n = triangle.getNormal();
		if (n.getX() != 0.0)
		return (int)Math.round((-n.getY() * (x - triangle.getVertexes()[0].getY()) - 
				n.getZ() * (y - triangle.getVertexes()[0].getZ())) / 
				n.getX() + triangle.getVertexes()[0].getX());
		return Integer.MIN_VALUE;
		
	}
	

	public void action(int y, int z)
	{
			int x = getXFromYZ(triangle, y, z);
			if (buffer.test(y, z, x))
			{
				image.setRGB(y, z, triangle.getColor(solid, 
						new Vector(x, y, z), sun).getRGB());
				}						
	}
	
}
