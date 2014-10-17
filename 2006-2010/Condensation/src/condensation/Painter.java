package condensation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Painter
{
    public static interface Map
    {
        public Complex map(Complex z);
    }

    private Rectangle2D getBounds()
    {
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        Complex z = start;
        for (int n = 0; n < TEST_COUNT; ++n)
        {
            z = map.map(z);
            if (n < BEGIN)
                continue;

            if (z.getReal() < minX)
                minX = z.getReal();
            if (z.getReal() > maxX)
                maxX = z.getReal();
            if (z.getImag() < minY)
                minY = z.getImag();
            if (z.getImag() > maxY)
                maxY = z.getImag();

        }
        return new Rectangle2D.Double(minX, minY, maxX - minX, maxY - minY);
    }

    private AffineTransform getTransform()
    {
        Rectangle2D rectangle = getBounds();
        double scale = Math.min((size.width - 2 * BORDER) / rectangle.getWidth(),
                (size.height - 2 * BORDER) / rectangle.getHeight());
        AffineTransform transform =
                AffineTransform.getTranslateInstance(-rectangle.getCenterX(), -rectangle.getCenterY());
        transform.preConcatenate(AffineTransform.getScaleInstance(scale, -scale));
        transform.preConcatenate(AffineTransform.getTranslateInstance(size.getCenterX(), size.getCenterY()));
        return transform;
    }

    public Image createImage()
    {
        BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, size.width, size.height);
        AffineTransform resultTransform = new AffineTransform();
        resultTransform.concatenate(getTransform());
        Complex z = start;
        for (int n = 0; n < count; ++n)
        {
            z = map.map(z);
            if (n < BEGIN)
                continue;
            Point2D point = resultTransform.transform(new Point2D.Double(z.getReal(), z.getImag()), null);
            if ((point.getX() < 0) || (point.getX() > size.width - 1) || (point.getY() < 0) || (point.getY() > size.height - 1))
                continue;
            image.setRGB((int)point.getX(), (int)point.getY(), color.getRGB());
        }
        return image;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }

    public void setSize(Rectangle size)
    {
        this.size = size;
    }

    public void setStart(Complex start)
    {
        this.start = start;
    }

    private Complex start = new Complex(0.0, 1.0);

    private int count = 0;

    private Rectangle size = new Rectangle(640, 480);

    private Color color = Color.BLACK;

    private Map map = new Map()
    {
        public Complex map(Complex z)
        {
            return Complex.ZERO;
        }
    };

    private static final int TEST_COUNT = 1000;

    private static final int BEGIN = 100;

    private static final int BORDER = 20;
}
