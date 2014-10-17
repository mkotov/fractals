package ru.xaoc.fractalworld.lsystems;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Painter {
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 450;
    public static final int DEFAULT_BORDER = 20;

    public static Image draw(LSystem lSystem, double deltaAngle, int depth) {
        return draw(lSystem, deltaAngle, depth, 0);
    }

    public static Image draw(LSystem lSystem, double deltaAngle, int depth, double alpha) {
        return draw(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_BORDER, lSystem, deltaAngle, depth, 0);
    }

    public static Image draw(int width, int height, int border, LSystem lSystem, double deltaAngle, int depth) {
        return draw(width, height, border, lSystem, deltaAngle, depth, 0);
    }

    public static Image draw(int width, int height, int border, LSystem lSystem, double deltaAngle, int depth, double alpha) {
        BoundCanvas boundCanvas = new BoundCanvas();
        Turtle boundTurtle = new Turtle(boundCanvas, 1, deltaAngle);
        boundTurtle.draw(lSystem.getResult(depth), new State(0, 0, alpha));
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        double scale = Math.min(
                (width - 2 * border) / (boundCanvas.getMaxX() - boundCanvas.getMinX()),
                (height - 2 * border) / (boundCanvas.getMaxY() - boundCanvas.getMinY()));
        double x = width / 2 - (boundCanvas.getMaxX() + boundCanvas.getMinX()) / 2 * scale;
        double y = height / 2 - (boundCanvas.getMaxY() + boundCanvas.getMinY()) / 2 * scale;
        Graphics imageGraphics = image.getGraphics();
        imageGraphics.setColor(Color.WHITE);
        imageGraphics.fillRect(0, 0, width, height);
        imageGraphics.setColor(Color.BLACK);
        GraphicCanvas graphicCanvas = new GraphicCanvas(imageGraphics);
        Turtle graphicTurtle = new Turtle(graphicCanvas, scale, deltaAngle);
        graphicTurtle.draw(lSystem.getResult(depth), new State(x, y, alpha));
        return image;
    }
}


