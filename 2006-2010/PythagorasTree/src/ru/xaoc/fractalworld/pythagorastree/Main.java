package ru.xaoc.fractalworld.pythagorastree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;
    private static BufferedImage image;
    private static Graphics2D graph;
    private static final double DA = Math.PI / 6;
    private static final int BASE_SIZE = 100;
    private static final Color treeColor = new Color(0x712F26);
    private static final Color leafColor = new Color(0x00FF00);

    private static void drawPythagorasTree(double a, double size, double x, double y)
    {
        double dx = size * Math.sin(a);
        double dy = size * Math.cos(a);
        double x1 = x;
        double y1 = y;
        double x2 = x + dx;
        double y2 = y - dy;
        double x3 = x + dx - dy;
        double y3 = y - dy - dx;
        double x4 = x - dy;
        double y4 = y - dx;
        double x5 = x - dy + size * Math.cos(DA) * Math.sin(a - DA);
        double y5 = y - dx - size * Math.cos(DA) * Math.cos(a - DA);
        Path2D path = new Path2D.Double();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.lineTo(x5, y5);
        path.lineTo(x4, y4);
        path.lineTo(x1, y1);
        path.closePath();


        graph.setColor(getBetweenColor(leafColor, treeColor, Math.pow(size / BASE_SIZE, 0.2)));
        graph.fill(path);

        if (size > 1)
        {

            drawPythagorasTree(
                    a - DA,
                    size * Math.cos(DA),
                    x4,
                    y4);
            drawPythagorasTree(
                    a - DA + (Math.PI / 2),
                    size * Math.sin(DA),
                    x5,
                    y5);
        }
    }

    private static Color getBetweenColor(Color startColor, Color endColor, double p)
    {
        return new Color((int) (startColor.getRed() + (endColor.getRed() - startColor.getRed()) * p),
                (int) (startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * p),
                (int) (startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * p));
    }

    public static void main(String[] args)
    {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        graph = image.createGraphics();
        graph.setColor(Color.WHITE);
        graph.fill(new Rectangle2D.Double(0, 0, WIDTH, HEIGHT));
        graph.setColor(Color.BLACK);

        drawPythagorasTree(
                Math.PI / 2,
                BASE_SIZE,
                WIDTH / 2 - BASE_SIZE / 2,
                HEIGHT - 50);

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