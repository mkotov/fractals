package ru.xaoc.fractalworld.land;

import java.awt.*;
import ru.xaoc.fractalworld.base3d.Colorer;
import ru.xaoc.fractalworld.base3d.Solid;
import ru.xaoc.fractalworld.base3d.Triangle;
import ru.xaoc.fractalworld.base3d.Vector;

public class LandColorer implements Colorer {

    private Color begin = Color.DARK_GRAY;
    private Color end = Color.GREEN;

    public Color getColor(Solid solid, Triangle triangle,
            Vector point, Vector sun) {
        double s = triangle.getNormal().cos(sun) * 0.5 + 0.5;
        int r = (int) (begin.getRed() + s * (end.getRed() - begin.getRed()));
        int g = (int) (begin.getGreen() + s * (end.getGreen() - begin.getGreen()));
        int b = (int) (begin.getBlue() + s * (end.getBlue() - begin.getBlue()));
        return new Color(r, g, b);
    }
}
