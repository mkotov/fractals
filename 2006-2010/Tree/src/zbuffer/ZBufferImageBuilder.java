package zbuffer;

import base.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class ZBufferImageBuilder implements ImageBuilder
{
	private int width;
	private int height;
	private BufferedImage image;
	private ZBuffer xBuffer;
	private Solid solid;
	private Vector sun;
	private ZBufferAction zBufferAction;
	
	public ZBufferImageBuilder()
	{
		xBuffer = new ZBuffer();
	}

	public void init(Solid solid, Vector sun, int width, int height)
	{
		this.solid = solid;
		this.sun = sun;
		this.width = width;
		this.height = height;
		xBuffer.init(width, height);
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		zBufferAction = new ZBufferAction(solid, xBuffer, image, sun);
	}
	

	
	public void add(Triangle triangle)
	{
		TriangleProjectionYZ proj = new TriangleProjectionYZ(triangle, width, height);
		zBufferAction.setTriangle(triangle);
		proj.forEach(zBufferAction);
	}

	public Image getResult()
	{
		return image;
	}
}	