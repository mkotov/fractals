package ru.xaoc.fractalworld.carpets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
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


    public static int[][] generateSierpinskiCarpet(int n)
    {
        int[][] T = new int[n + 1][n + 1];
        for (int j = 0; j < n + 1; ++j)
        {
            T[0][j] = T[j][0] = 0;
        }
        T[1][1] = 1;

        for (int i = 1; i < n + 1; ++i)
        {
            for (int j = 1; j < n + 1; ++j)
            {
                if (i == 1 && j == 1) {
                    continue;
                }
                T[i][j] = (T[i - 1][j]  + T[i - 1][j - 1] + T[i][j - 1]) % 3;
            }
        }
        return T;
    }

    public static int[][] generateField(int[][] a, int n, int m)
    {
        int w = a.length;
        int[][] T = new int[n + w - 1][n + w - 1];
        for (int i = 0; i < n + w - 1; ++i)
        {
            for (int j = 0; j < n + w - 1; ++j)
            {
                T[i][j] = 0;
            }
        }

        T[w - 1][w - 1] = 1;

        for (int i = w - 1; i < n + w - 1; ++i)
        {
            for (int j = w - 1; j < n + w - 1; ++j)
            {
                for (int r = 0; r < w; ++r)
                {
                    for (int s = 0; s < w; ++s)
                    {
                        T[i][j] += a[r][s] * T[i - w + 1 + r][j - w + 1 + s];
                    }
                }
                T[i][j] %= m;
            }
        }
        return T;
    }

     public static Image drawSierpinskiCarpet(int n)
    {
        return draw(generateSierpinskiCarpet(n));
    }


    public static Image drawCarpet(int[][] a, int n, int m)
    {
        return draw(generateField(a, n, m));
    }

    public static Image image;

    public static void main(String[] args)
    {
        // image = drawCarpet(new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 0}}, 700, 3);
        // image = drawCarpet(new int[][] {{0, 1, 0}, {1, 1, 0}, {0, 0, 0}}, 700, 3);
        // image = drawCarpet(new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 0}}, 512, 2);
        // image = drawCarpet(new int[][] {{1, 1}, {1, 0}}, 729, 3);
        // image = drawCarpet(new int[][] {{1, 1}, {1, 0}}, 625, 5);
        // image = drawCarpet(new int[][] {{1, 0, 0}, {0, 1, 1}, {0, 1, 0}}, 512, 2);
        // image = drawCarpet(new int[][] {{1, 1}, {0, 0}}, 729, 2);
        image = drawSierpinskiCarpet(729);
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
















