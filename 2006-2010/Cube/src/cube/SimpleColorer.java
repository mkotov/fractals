package cube;


import base.*;
import java.awt.*;

public class SimpleColorer implements Colorer
{
	private Color begin;
	private Color end;
	
	public SimpleColorer(Color begin, Color end)
	{
		this.begin = begin;
		this.end = end;
	}

	public Color getColor(Solid solid, Triangle triangle, 
		Vector point, Vector sun)
	{
		double s = triangle.getNormal().cos(sun) * 0.5 + 0.5;
		return new Color(
			(int)(begin.getRed()   + s * (end.getRed()   - begin.getRed())), 
			(int)(begin.getGreen() + s * (end.getGreen() - begin.getGreen())),
			(int)(begin.getBlue()  + s * (end.getBlue()  - begin.getBlue())));
	}
}
