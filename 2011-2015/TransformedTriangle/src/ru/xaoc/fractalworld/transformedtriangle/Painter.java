package ru.xaoc.fractalworld.transformedtriangle;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Painter {
    Generator generator;
    Transformator transformator;

    public Painter(Generator generator, Transformator transformator) {
        this.generator = generator;
        this.transformator = transformator;
    }
    
    public BufferedImage draw(int width, int height, int countPoint, Transformator viewTransformator) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics imageGraphics = image.getGraphics();
        imageGraphics.setColor(Color.WHITE);
        imageGraphics.fillRect(0, 0, width, height);

        for (int i = 0; i < countPoint; ++i) {
            Complex z = viewTransformator.transform(transformator.transform(generator.generatePoint()));
            if (z.getReal() >= 0 && z.getReal() < width &&
                    z.getImag() >= 0 && z.getImag() < height) {
                image.setRGB((int)z.getReal(), (int)z.getImag(), 0);
            }
        }
        return image;
    }

}
