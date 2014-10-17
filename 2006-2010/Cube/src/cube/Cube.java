package cube;

import base.*;
import cube.SimpleColorer;
import java.awt.*;

public class Cube extends Solid
{
	public static Colorer colorer = new SimpleColorer(Color.BLACK, Color.WHITE);
	
	public static Cube createCube(int n)
	{
            Cube cube = new Cube();
            cube.addCube(n, 0.0, 0.0, 0.0, 500.0, true, true, true, true, true, true);
            return cube;
	}	
	
	public static Solid createSquare(Vector center, Vector a, Vector b)
	{	
		Solid solid = new Solid();
		Vector[] vertexes = new Vector[3];
		vertexes[0] = center.plus(a).plus(b);
		vertexes[1] = center.minus(a).plus(b);
		vertexes[2] = center.minus(a).minus(b);
		solid.add(new Triangle(vertexes, colorer));
		vertexes = new Vector[3];
		vertexes[0] = center.minus(a).minus(b);		
		vertexes[1] = center.plus(a).minus(b);	
		vertexes[2] = center.plus(a).plus(b);		
		solid.add(new Triangle(vertexes, colorer));
		return solid;
	}	
	
	private void addCube(int n, double centerX, double centerY, double centerZ, double size, 
		boolean front,  boolean right, boolean back, boolean left, boolean top, boolean bottom)
	{
		if (--n > 0)
		{
			size /= 3.0;
			addCube(n, centerX + size, centerY + size, centerZ + size, size, front, right, false, false, top,   false);
			addCube(n, centerX + size, centerY       , centerZ + size, size, front, false, true,  false, top,   true);
			addCube(n, centerX + size, centerY - size, centerZ + size, size, front, false, false, left,  top,   false);
			addCube(n, centerX + size, centerY + size, centerZ       , size, front, right, true,  true,  false, false);
			addCube(n, centerX + size, centerY - size, centerZ       , size, front, true,  true,  left,  false, false);
			addCube(n, centerX + size, centerY + size, centerZ - size, size, front, right, false, false, false, bottom);
			addCube(n, centerX + size, centerY       , centerZ - size, size, front, false, true,  false, true,  bottom);
			addCube(n, centerX + size, centerY - size, centerZ - size, size, front, false, false, left,  false, bottom);
			addCube(n, centerX       , centerY + size, centerZ + size, size, false, right, false, true,  top,   true);
			addCube(n, centerX       , centerY - size, centerZ + size, size, false, true,  false, left,  top,   true);
			addCube(n, centerX       , centerY + size, centerZ - size, size, false, right, false, true,  true,  bottom);
			addCube(n, centerX       , centerY - size, centerZ - size, size, false, true,  false, left,  true,  bottom);
			addCube(n, centerX - size, centerY + size, centerZ + size, size, false, right, back, false,  top,   false);
			addCube(n, centerX - size, centerY       , centerZ + size, size, true,  false, back, false,  top,   true);
			addCube(n, centerX - size, centerY - size, centerZ + size, size, false, false, back, left,   top,   false);
			addCube(n, centerX - size, centerY + size, centerZ       , size, true,  right, back, true,   false, false);
			addCube(n, centerX - size, centerY - size, centerZ       , size, true,  true,  back, left,   false, false);
			addCube(n, centerX - size, centerY + size, centerZ - size, size, false, right, back, false,  false, bottom);
			addCube(n, centerX - size, centerY       , centerZ - size, size, true,  false, back, false,  true,  bottom);
			addCube(n, centerX - size, centerY - size, centerZ - size, size, false, false, back, left,   false, bottom);
		}
		else
		{
			size /= 2.0;
			if (front)
                                addAll(createSquare(
				       new Vector(centerX + size, centerY, centerZ), 
				       new Vector(0, size, 0), 
				       new Vector(0, 0, size)));
			if (right)
                                addAll(createSquare(
				       new Vector(centerX, centerY + size, centerZ), 
				       new Vector(-size, 0, 0), 
				       new Vector(0, 0, size)));
			if (back)
                                addAll(createSquare(
				       new Vector(centerX - size, centerY, centerZ), 
				       new Vector(0, -size, 0), 
				       new Vector(0, 0, size)));
			if (left)
                                addAll(createSquare(
				       new Vector(centerX, centerY - size, centerZ), 
				       new Vector(size, 0, 0), 
				       new Vector(0, 0, size)));
			if (top)
                                addAll(createSquare(
				       new Vector(centerX, centerY, centerZ + size), 
				       new Vector(0, size, 0), 
				       new Vector(-size, 0, 0)));
			if (bottom)
                                addAll(createSquare(
				       new Vector(centerX, centerY, centerZ - size), 
				       new Vector(size, 0, 0), 
				       new Vector(0, -size, 0)));
		}
	}	
}
