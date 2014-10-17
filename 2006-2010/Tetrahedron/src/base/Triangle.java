package base;

import java.awt.*;

// Трёхмерный треугольник
public class Triangle
{
	private Vector[] vertexes = new Vector[3];	// Вершины треугольника
	private Colorer colorer;
	
	
	// Конструктор по вершинам 
	public Triangle(Vector[] vertexes, Colorer colorer)
	{
		setVertexes(vertexes);
		setColorer(colorer);
	}
	
	
	// Получить нормаль
	public Vector getNormal()
	{
		return vertexes[1].minus(vertexes[0]).cross(vertexes[2].minus(vertexes[0]));
	}	
	
	
	// Получить вершины
	public Vector[] getVertexes()
	{
		return vertexes;
	}
	
	public void setVertexes(Vector[] vertexes)
	{
		this.vertexes = vertexes;
	}

	
	public Colorer getColorer()
	{
		return colorer;
	}
	
	public void setColorer(Colorer colorer)
	{
		this.colorer = colorer;
	}
	
	public Vector getCenter()
	{
		return new Vector(
			(vertexes[0].getX() + vertexes[1].getX() + vertexes[2].getX()) / 3.0,
			(vertexes[0].getY() + vertexes[1].getY() + vertexes[2].getY()) / 3.0,
			(vertexes[0].getZ() + vertexes[1].getZ() + vertexes[2].getZ()) / 3.0);
	}

	@Override public String toString()
	{
		return "(" + vertexes[0] + ", " + vertexes[1] + ", " + vertexes[2] + ")";
	}
	
	public Color getColor(Solid solid, Vector point, Vector sun)	
	{
		return colorer.getColor(solid, this, point, sun);
	}
}
