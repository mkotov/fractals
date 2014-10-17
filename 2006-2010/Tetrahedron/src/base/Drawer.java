package base;

import java.awt.*;

public class Drawer
{
	private Solid solid;
	private ImageBuilder imager;
	
	public Drawer(Solid solid, ImageBuilder imager)
	{
		this.solid = solid;
		this.imager = imager;
	}
	
	public Image draw(int width, int height, Vector sun, Transform transform)
	{
		Solid transformedSolid = transform.apply(solid);
		imager.init(transformedSolid, sun, width, height);
		for (Triangle triangle : transformedSolid)
		{
			imager.add(triangle);
		}
		return imager.getResult();
	}
}
