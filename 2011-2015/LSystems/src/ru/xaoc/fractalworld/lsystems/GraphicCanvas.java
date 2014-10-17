package ru.xaoc.fractalworld.lsystems;

import java.awt.Graphics;

public class GraphicCanvas implements Canvas {
    private final Graphics graphics;

    public GraphicCanvas(Graphics graphics) {
        this.graphics = graphics;
    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        graphics.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    }

}
