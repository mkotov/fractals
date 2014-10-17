package ru.xaoc.fractalworld.base3d;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

final public class PainterImageBuilder implements ImageBuilder {

    private int width;
    private int height;
    private Transform transform;
    private Solid solid;
    private Vector sun;
    private BufferedImage image;
    private Graphics2D graph;

    public void init(Solid solid, Vector sun, int width, int height) {
        this.solid = solid;
        this.sun = sun;
        this.width = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graph = image.createGraphics();

        Iterator<Triangle> iter = solid.iterator();
        while (iter.hasNext()) {
            if (testInvisible(iter.next())) {
                iter.remove();
            }
        }

        Collections.sort(solid, new Comparator<Triangle>() {

            public int compare(Triangle tr1, Triangle tr2) {
                // Ищем проекцию на ось наблюдателя центров квадратов
                double center1 = tr1.getCenter().getX();
                double center2 = tr2.getCenter().getX();
                double r = center1 - center2;
                if (r < 0.0) {
                    return -1;
                } else if (r > 0.0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    private boolean testInvisible(Triangle triangle) {
        return (triangle.getNormal().getX() > 0);
    }

    private GeneralPath genPath(Triangle triangle) {
        Vector[] vertexes = triangle.getVertexes();
        GeneralPath path = new GeneralPath();

        // плоскость наблюдателя параллельна Oyz
        path.moveTo((float) vertexes[0].get(1), (float) vertexes[0].get(2));
        path.lineTo((float) vertexes[1].get(1), (float) vertexes[1].get(2));
        path.lineTo((float) vertexes[2].get(1), (float) vertexes[2].get(2));
        path.lineTo((float) vertexes[0].get(1), (float) vertexes[0].get(2));
        return path;
    }

    public void add(Triangle triangle) {
        graph.setColor(triangle.getColor(null, null, sun));
        graph.fill(genPath(triangle));
    }

    public Image getResult() {
        return image;
    }
}
