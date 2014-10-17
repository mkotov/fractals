package ru.xaoc.fractalworld.hilbertcurvepictures;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import static java.lang.Math.*;

public class Main {

    static Point2D[] drawHilbertCurve(Point2D p, double size, int d) {
        Point2D q = new Point2D.Double(
                p.getX() + size * sqrt(2) * cos(PI * (d + 0.5) / 2),
                p.getY() + size * sqrt(2) * sin(PI * (d + 0.5) / 2));
        if (size <= 2) {
            if (blockIsWhite(p, q)) {
                return null;
            } else {
                Point2D cc = new Point2D.Double(
                        p.getX() + size * sqrt(2) * cos(PI * (d + 0.5) / 2) / 2,
                        p.getY() + size * sqrt(2) * sin(PI * (d + 0.5) / 2) / 2);
                return new Point2D[]{cc, cc};
            }
        } else {
            Point2D cl = new Point2D.Double(
                    p.getX() + size * cos(PI * (d + 1) / 2) / 2,
                    p.getY() + size * sin(PI * (d + 1) / 2) / 2);
            Point2D cc = new Point2D.Double(
                    p.getX() + size * sqrt(2) * cos(PI * (d + 0.5) / 2) / 2,
                    p.getY() + size * sqrt(2) * sin(PI * (d + 0.5) / 2) / 2);
            Point2D br = new Point2D.Double(
                    p.getX() + size * cos(PI * d / 2),
                    p.getY() + size * sin(PI * d / 2));
            Point2D[] p1 = drawHilbertCurve(cl, size / 2, d - 1);
            Point2D[] p2 = drawHilbertCurve(cl, size / 2, d);
            Point2D[] p3 = drawHilbertCurve(cc, size / 2, d);
            Point2D[] p4 = drawHilbertCurve(br, size / 2, d + 1);
            if (p1 == null && p2 == null && p3 == null && p4 == null && blockIsWhite(p, q)) {
                return null;
            } else {
                if (p1 == null) {
                    p1 = new Point2D[2];
                    p1[0] = p1[1] = new Point2D.Double(
                            cl.getX() + size * sqrt(2) * cos(PI * (d - 0.5) / 2) / 4,
                            cl.getY() + size * sqrt(2) * sin(PI * (d - 0.5) / 2) / 4);
                }
                if (p2 == null) {
                    p2 = new Point2D[2];
                    p2[0] = p2[1] = new Point2D.Double(
                            cl.getX() + size * sqrt(2) * cos(PI * (d + 0.5) / 2) / 4,
                            cl.getY() + size * sqrt(2) * sin(PI * (d + 0.5) / 2) / 4);
                }
                if (p3 == null) {
                    p3 = new Point2D[2];
                    p3[0] = p3[1] = new Point2D.Double(
                            cc.getX() + size * sqrt(2) * cos(PI * (d + 0.5) / 2) / 4,
                            cc.getY() + size * sqrt(2) * sin(PI * (d + 0.5) / 2) / 4);
                }
                if (p4 == null) {
                    p4 = new Point2D[2];
                    p4[0] = p4[1] = new Point2D.Double(
                            br.getX() + size * sqrt(2) * cos(PI * (d + 1.5) / 2) / 4,
                            br.getY() + size * sqrt(2) * sin(PI * (d + 1.5) / 2) / 4);
                }

                drawLine(p1[0], p2[0]);
                drawLine(p2[1], p3[0]);
                drawLine(p3[1], p4[1]);
            }
            return new Point2D[]{p1[1], p4[0]};
        }
    }

    static boolean blockIsWhite(Point2D p, Point2D q) {
        int l = (int) min(p.getX(), q.getX());
        int r = (int) max(p.getX(), q.getX());
        int t = (int) min(p.getY(), q.getY());
        int b = (int) max(p.getY(), q.getY());

        double c = 0;
        for (int i = l; i < r; ++i) {
            for (int j = t; j < b; ++j) {
                c += (srcImage.getRGB(i, j) & 0x0000FF) / 255.0;
            }
        }
        return c / ((b - t) * (r - l)) > 1.2 * (1 - log(2) / log(b - t));
    }

    static void drawLine(Point2D p1, Point2D p2) {
        graphics.drawLine(
                (int) round(p1.getX()),
                (int) round(p1.getY()),
                (int) round(p2.getX()),
                (int) round(p2.getY()));
    }
    static BufferedImage dstImage;
    static BufferedImage srcImage;
    static Graphics2D graphics;

    public static void main(String[] args) throws IOException {
        srcImage = ImageIO.read(new File("/home/mkotov/cat.png"));

        dstImage = new BufferedImage(512, 512, BufferedImage.TYPE_INT_RGB);
        graphics = dstImage.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fill(new Rectangle2D.Double(0, 0, 512, 512));
        graphics.setColor(Color.BLACK);
        drawHilbertCurve(new Point(0, 0), 512, 0);
        int width = dstImage.getWidth(null);
        int height = dstImage.getHeight(null);
        JFrame frame = new JFrame();
        frame.addNotify();
        frame.setSize(frame.getInsets().left
                + frame.getInsets().right + width,
                frame.getInsets().top
                + frame.getInsets().bottom + height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                if (dstImage != null) {
                    g2.drawImage(dstImage, 0, 0, null);
                }
            }
        });
        frame.setVisible(true);
    }
}
