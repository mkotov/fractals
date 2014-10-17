package ru.xaoc.fractalworld.base3d;

import java.awt.*;

public interface ImageBuilder {
    public void init(Solid solid, Vector sun, int width, int height);
    public void add(Triangle triangle);
    public Image getResult();
}
