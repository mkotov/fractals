package zbuffer;

import base.*;

import java.awt.*;
import java.util.*;

public class TriangleProjectionYZ
{
	ArrayList<Point> vertexes;
	int width;
	int height;
	
	public TriangleProjectionYZ(Triangle triangle, int width, int height)
	{
		vertexes = new ArrayList<Point>();
		this.width = width;
		this.height = height;
		vertexes.add(new Point((int)Math.round(triangle.getVertexes()[0].getY()), (int)Math.round(triangle.getVertexes()[0].getZ())));
		vertexes.add(new Point((int)Math.round(triangle.getVertexes()[1].getY()), (int)Math.round(triangle.getVertexes()[1].getZ())));
		vertexes.add(new Point((int)Math.round(triangle.getVertexes()[2].getY()), (int)Math.round(triangle.getVertexes()[2].getZ())));

		Collections.sort(vertexes, new Comparator<Point>()
		{
			public int compare(Point p, Point q)
			{
				return p.y - q.y;
			}
		});
	}
	
	public void forEach(Action action)
	{
	
		int x, y, z, a, b;
		if (vertexes.get(1).y - vertexes.get(0).y != 0 && vertexes.get(2).y - vertexes.get(0).y != 0)
		{
			for (z = vertexes.get(0).y; z <= vertexes.get(1).y; ++z)
			{
				a = (int)Math.round((double)(vertexes.get(1).x - vertexes.get(0).x) * (z - vertexes.get(0).y) / (vertexes.get(1).y - vertexes.get(0).y) + vertexes.get(0).x);
				b = (int)Math.round((double)(vertexes.get(2).x - vertexes.get(0).x) * (z - vertexes.get(0).y) / (vertexes.get(2).y - vertexes.get(0).y) + vertexes.get(0).x);
				for (y = Math.min(a, b); y <= Math.max(a, b); ++y)
				{
					action.action(y, z);
				}
			}
		}
		
		if (vertexes.get(1).y - vertexes.get(2).y != 0 && vertexes.get(2).y - vertexes.get(0).y != 0)
		{
			for (z = vertexes.get(1).y; z <= vertexes.get(2).y; ++z)
			{
				a = (int)Math.round((double)(vertexes.get(1).x - vertexes.get(2).x) * (z - vertexes.get(2).y) / (vertexes.get(1).y - vertexes.get(2).y) + vertexes.get(2).x);
				b = (int)Math.round((double)(vertexes.get(2).x - vertexes.get(0).x) * (z - vertexes.get(0).y) / (vertexes.get(2).y - vertexes.get(0).y) + vertexes.get(0).x);
				for (y = Math.min(a, b); y <= Math.max(a, b); ++y)
				{
					action.action(y, z);
				}
			}
		}
	}
}