package ru.xaoc.fractalworld.rewritingsystems;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static int[][] rewrite(int[][] A, int[][][] Rs) {
        int r = A.length;
        int s = A[0].length;
        int p = Rs[0].length;
        int q = Rs[0][0].length;

        int[][] C = new int[r * p][s * q];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < s; ++j) {
                for (int m = 0; m < p; ++m) {
                    for (int n = 0; n < q; ++n) {
                        C[i * p + m][j * q + n] = Rs[A[i][j]][m][n];
                    }
                }
            }
        }
        return C;
    }

    public static int[][] system(int[][] G, int[][][] Rs, int n) {
        if (n == 0) {
            return G;
        }
        return system(rewrite(G, Rs), Rs, n - 1);
    }

    public static Image draw(int[][] A)
    {
        int r = A.length;
        int s = A[0].length;
        BufferedImage image = new BufferedImage(s, r, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fill(new Rectangle2D.Double(0, 0, s, r));
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < r; ++i)
        {
            for (int j = 0; j < s; ++j)
            {
                if (A[i][j] != 0)
                {
                    graphics.fillRect(j, i, 1, 1);
                }
            }
        }
        return image;
    }


    private static Image drawSierpinskiCarpet(int n)
    {
        return draw(
                system(new int[][] {{1}},
                new int[][][] {{
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}},

                   {{1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1}}
            }, n));
    }


    private static Image drawHafermanCarpet(int n)
    {
        return draw(
                system(new int[][] {{1}},
                new int[][][] {{
                    {1, 1, 1},
                    {1, 1, 1},
                    {1, 1, 1}},

                   {{0, 1, 0},
                    {1, 0, 1},
                    {0, 1, 0}}
            }, n));
    }

    public static Image image;
    public static void main(String[] args)
    {
        //image = drawSierpinskiCarpet(6);
        image = drawHafermanCarpet(6);

        int width = image.getWidth(null);
        int height = image.getHeight(null);
        JFrame frame = new JFrame();
        frame.addNotify();
        frame.setSize(frame.getInsets().left +
                frame.getInsets().right + width,
                frame.getInsets().top +
                frame.getInsets().bottom + height);
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
