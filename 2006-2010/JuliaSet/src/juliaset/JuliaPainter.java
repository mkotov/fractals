/*
 * Matvej Kotov, 2009
 * http://fractalworld.xaoc.ru/
 * ilab24@yandex.ru
 */
package juliaset;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class JuliaPainter implements Painter
{
    private Rectangle2D getBounds()
    {
        return new Rectangle2D.Double(-2, -2, 4, 4);
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

    public Image createImage() throws java.awt.geom.NoninvertibleTransformException
    {
        BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, size.width, size.height);
        AffineTransform resultTransform = new AffineTransform();
        resultTransform.concatenate(getTransform());
        Complex z;
        int n;
        for (int x = 0; x < size.width; ++x)
            for (int y = 0; y < size.height; ++y)
            {
                n = 0;
                Point2D point = resultTransform.inverseTransform(new Point2D.Double(x, y), null);
                z = new Complex(point.getX(), point.getY());
                while (Complex.abs(z) < MAX_Z && n < MAX_ITER)
                {
                    z = map.map(z);
                    ++n;
                }
                image.setRGB((int)x, (int)y,
                        colorer.getColor(n, z).getRGB());
            }
        return image;
    }

    public void setColorer(Colorer colorer)
    {
        this.colorer = colorer;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }

    public void setSize(Rectangle size)
    {
        this.size = size;
    }

    private Rectangle size = new Rectangle(640, 480);

    private Colorer colorer = null;

    private Map map = null;

    private static final int BORDER = 20;

    private static final int MAX_Z = 10;

    private static final int MAX_ITER = 50;
}
