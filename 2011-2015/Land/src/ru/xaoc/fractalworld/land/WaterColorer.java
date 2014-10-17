package ru.xaoc.fractalworld.land;


import java.awt.*;
import ru.xaoc.fractalworld.base3d.Colorer;
import ru.xaoc.fractalworld.base3d.Solid;
import ru.xaoc.fractalworld.base3d.Triangle;
import ru.xaoc.fractalworld.base3d.Vector;

public class WaterColorer implements Colorer {
	public Color getColor(Solid solid, Triangle triangle, 
		Vector point, Vector sun) {
		return Color.BLUE;
	}
}
