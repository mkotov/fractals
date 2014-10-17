package ru.xaoc.fractalworld.randomkochcurve;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static BufferedImage image;
    private static Graphics2D graph;
    private static Random random = new Random();

    private static int randomSgn()
    {
        return random.nextInt(2) * 2 - 1;
    }

    private static void drawRandomKochCurve(Point2D p, Point2D q, int n, Color inColor, Color outColor)
    {
        int w = randomSgn();
        Point2D r = new Point2D.Double((2 * p.getX() + q.getX()) / 3, (2 * p.getY() + q.getY()) / 3);
        Point2D s = new Point2D.Double((p.getX() + q.getX()) / 2 - w * (p.getY() - q.getY()) * Math.sqrt(3) / 6, ((p.getY() + q.getY()) / 2 + w * (p.getX() - q.getX()) * Math.sqrt(3) / 6));
        Point2D t = new Point2D.Double((p.getX() + 2 * q.getX()) / 3, (p.getY() + 2 * q.getY()) / 3);
        Path2D path = new Path2D.Double();
        path.moveTo(r.getX(), r.getY());
        path.lineTo(s.getX(), s.getY());
        path.lineTo(t.getX(), t.getY());
        path.lineTo(r.getX(), r.getY());
        path.closePath();
        if (w == 1)
        {
            graph.setColor(inColor);
        }
        else /* if w == -1 */ {
            graph.setColor(outColor);
        }
        graph.fill(path);
        if (n == 0)
        {
            return;
        }
        drawRandomKochCurve(p, r, n - 1, inColor, outColor);
        drawRandomKochCurve(r, s, n - 1, inColor, outColor);
        drawRandomKochCurve(s, t, n - 1, inColor, outColor);
        drawRandomKochCurve(t, q, n - 1, inColor, outColor);

    }

    private static void drawRandomKochSnowflake(Point2D c, double d, int m, int n, Color inColor, Color outColor)
    {
        Point2D[] vs = new Point2D[m];
        for (int i = 0; i < m; ++i)
        {
            vs[i] = new Point2D.Double(c.getX() + d * Math.cos(2 * Math.PI / m * i), c.getY() - d * Math.sin(2 * Math.PI / m * i));
        }
        Path2D path = new Path2D.Double();
        path.moveTo(vs[0].getX(), vs[0].getY());
        for (int i = 0; i < m; ++i)
        {
            path.lineTo(vs[(i + 1) % m].getX(), vs[(i + 1) % m].getY());
        }
        path.closePath();
        graph.setColor(inColor);
        graph.fill(path);
        for (int i = 0; i < m; ++i)
        {
            drawRandomKochCurve(vs[(i + 1) % m], vs[i], n, inColor, outColor);
        }
    }

    private static Color getBetweenColor(Color startColor, Color endColor, double p)
    {
        return new Color((int) (startColor.getRed() + (endColor.getRed() - startColor.getRed()) * p),
                (int) (startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * p),
                (int) (startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * p));
    }

    private static void drawKochMegaSnowflake(Point2D c, double d, int m, int k, int n, Color inColor, Color endColor, Color outColor)
    {
        drawRandomKochSnowflake(c, d, m, n, endColor, outColor);
        for (int i = 1; i < k; ++i)
        {
            drawRandomKochSnowflake(c, d * (k - i) / k, m, n, getBetweenColor(endColor, inColor, (double) i / k), getBetweenColor(endColor, inColor, (double) (i - 1) / k));
        }

    }

    public static void main(String[] args)
    {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        graph = image.createGraphics();
        graph.setColor(Color.BLUE);
        graph.fill(new Rectangle2D.Double(0, 0, WIDTH, HEIGHT));

        //drawRandomKochSnowflake(new Point2D.Double(WIDTH / 2, HEIGHT / 2), WIDTH / 3,
        //        4, 4, Color.GREEN, Color.BLUE);
        drawKochMegaSnowflake(new Point2D.Double(WIDTH / 2, HEIGHT / 2), WIDTH / 3,
                6, 3, 4, Color.GREEN, Color.ORANGE, Color.BLUE);
        JFrame frame = new JFrame();
        frame.addNotify();
        frame.setSize(frame.getInsets().left +
                frame.getInsets().right + WIDTH,
                frame.getInsets().top +
                frame.getInsets().bottom + HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JPanel()
        {
            @Override
            public void paintComponent(Graphics g)
            {
                Graphics2D G = (Graphics2D) g;
                if (image != null)
                {
                    G.drawImage(image, 0, 0, null);
                }
            }

        });
        frame.setVisible(true);
    }

}