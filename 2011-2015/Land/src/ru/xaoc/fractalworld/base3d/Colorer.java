package ru.xaoc.fractalworld.base3d;

import java.awt.*;

public interface Colorer {
    public Color getColor(Solid solid, Triangle triangle,
            Vector point, Vector sun);
}
