package tree;

import base.*;

import java.awt.*;

public class Tree extends Solid
{
	Colorer treeColorer = new SimpleColorer(Color.RED, Color.ORANGE);
	Colorer leafColorer = new SimpleColorer(new Color(0, 127, 0), Color.YELLOW);

	// Создать конус
	public static Solid createCone(double height, double radius, int countQuadrangles, Colorer colorer)
	{
		Solid solid = new Solid();
		double phi1, phi2;
	
		for (int i = 0; i < countQuadrangles; ++i)
		{
			phi1 = 2 * Math.PI / countQuadrangles * i;
			phi2 = 2 * Math.PI / countQuadrangles * (i + 1);
			Vector[] vertexes = new Vector[3];
			vertexes[0] = new Vector(radius * Math.cos(phi1), radius * Math.sin(phi1), 0);
			vertexes[1] = new Vector(radius * Math.cos(phi2), radius * Math.sin(phi2), 0);
			vertexes[2] = new Vector(0.0, 0.0, height);
			solid.add(new Triangle(vertexes, colorer));
		}
		
		return solid;
	}	
	
	public static Solid createLeaf(double size, Colorer colorer)
	{
		Solid solid = new Solid();
		Vector[] vertexes = new Vector[3];
		vertexes[0] = new Vector(0.0, 0.0, 0.0);
		vertexes[1] = new Vector(0.0, size / 3.0, size / 2.0);
		vertexes[2] = new Vector(0.0, 0, size);
		solid.add(new Triangle(vertexes, colorer));
		vertexes = new Vector[3];
		vertexes[0] = new Vector(0.0, 0, size);
		vertexes[1] = new Vector(0.0, -size / 3.0, size / 2.0);
		vertexes[2] = new Vector(0.0, 0.0, 0.0);
		solid.add(new Triangle(vertexes, colorer));
		return solid;
	}		
	
	
	void branch(int n, double size, double radius, Transform T)
	{
		
		if (--n > 0)
		{
			int count = (int)((n == 1) ? (size / 8 + 1) : (size / 25));
			for (int i = 0; i < count ; ++i)
			{
				double r = (Math.random() * 0.9 + 0.1) * size;
				branch(n, (size - r) * 0.7, (size - r) / 25.0,
					Transform.createTranslateZ((size - r) / 30.0).composite(
					Transform.createRotateY(Math.PI / 3.0).composite(
					Transform.createRotateZ(2.0 * Math.PI * Math.random()).composite(
					Transform.createTranslateZ(r).composite(
					T)))));
			}
			for (int i = 0; i < 5 ; ++i)
			{
				double r = (Math.random() * 0.1) * size;
				branch(1, 0, 0,
					Transform.createTranslateZ((size - r) / 30.0).composite(
					Transform.createRotateY(Math.PI / 3.0).composite(
					Transform.createRotateZ(2.0 * Math.PI * Math.random()).composite(
					Transform.createTranslateZ(r).composite(
					T)))));
			}			
			addAll(T.apply(createCone(size, radius, 10, treeColorer)));
		}
		else
			addAll(T.apply(createLeaf(20, leafColorer)));
	}
	
	Tree()
	{
		branch(4, 600.0, 60.0, Transform.createTranslateZ(-300));
	}
}