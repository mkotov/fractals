package base;

import java.awt.*;

public interface Colorer
{
	public Color getColor(Solid solid, Triangle triangle, 
		Vector point, Vector sun);
}
