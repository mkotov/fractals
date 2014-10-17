package ru.xaoc.fractalworld.kroneckerproduct;

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
    public static int[][] product(int[][] A, int[][] B)
    {
        int m = A.length;
        int n = A[0].length;
        int p = B.length;
        int q = B[0].length;
        int r = m * p;
        int s = n * q;
        int C[][] = new int[r][s];
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                for (int u = 0; u < p; ++u)
                {
                    for (int v = 0; v < q; ++v)
                    {
                        C[i * p + u][j * q + v] = A[i][j] * B[u][v];
                    }
                }
            }
        }
        return C;
    }

    public static int[][] power(int[][] A, int n)
    {
        if (n == 0)
        {
            return new int[][] {{1}};
        }
        return product(power(A, n - 1), A);
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

    public static Image draw(int[][] A, int m)
    {
        Color[] colors = new Color[] {Color.WHITE, Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.BLACK, Color.MAGENTA};
        int r = A.length;
        int s = A[0].length;
        BufferedImage image = new BufferedImage(s, r, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fill(new Rectangle2D.Double(0, 0, s, r));
        for (int i = 0; i < r; ++i)
        {
            for (int j = 0; j < s; ++j)
            {
                graphics.setColor(colors[A[i][j] % m]);
                graphics.fillRect(j, i, 1, 1);
            }
        }
        return image;
    }

    public static Image drawSierpinskiCarpet(int n)
    {
        return draw(
                power(new int[][]
                {{1, 1, 1},
                 {1, 0, 1},
                 {1, 1, 1}},
                n));
    }

    public static Image drawBoxFractal(int n)
    {
        return draw(
                power(new int[][]
                {{1, 0, 1},
                 {0, 1, 0},
                 {1, 0, 1}},
                n));
    }

    public static Image drawCantorDust(int n)
    {
        return draw(
                power(new int[][]
                {{1, 0, 1},
                 {0, 0, 0},
                 {1, 0, 1}},
                n));
    }

    public static Image drawSierpinskiTriangle(int n)
    {
        return draw(
                power(new int[][]
                {{1, 0},
                 {1, 1}},
                n));
    }


    public static Image drawSmile(int n)
    {
        return draw(
                power(new int[][]
                {{0, 1, 1, 1, 1, 1, 0},
                 {1, 1, 2, 1, 2, 1, 1},
                 {1, 1, 2, 1, 2, 1, 1},
                 {1, 1, 1, 1, 1, 1, 1},
                 {1, 2, 1, 1, 1, 2, 1},
                 {1, 1, 2, 2, 2, 1, 1},
                 {0, 1, 1, 1, 1, 1, 0}},
                n), 3);
    }

    public static Image drawModifiedSierpinskiCarpet(int n, int m) {
        return draw(
                power(new int[][]
                {{1, 1, 1},
                 {1, 2, 1},
                 {1, 1, 1}},
                n), m);
    }

    public static Image drawYetAnotherModifiedSierpinskiCarpet(int n, int m) {
        return draw(
                power(new int[][]
                {{1, 1, 1, 1, 1},
                 {1, 2, 2, 2, 1},
                 {1, 2, 0, 2, 1},
                 {1, 2, 2, 2, 1},
                 {1, 1, 1, 1, 1}},
                n), m);
    }

    public static Image drawModifiedSierpinskiTriangle(int n, int m) {
        return draw(
                power(new int[][]
                {{1, 0, 0},
                 {1, 1, 0},
                 {1, 2, 1}},
                n), m);
    }

    public static Image image;
    public static void main(String[] args)
    {
        // image = drawSierpinskiCarpet(6);
        image = drawSierpinskiTriangle(9);
        // image = drawBoxFractal(6);
        // image = drawCantorDust(6);
        // image = drawModifiedSierpinskiCarpet(6, 3);
        // image = drawModifiedSierpinskiCarpet(6, 4);
        // image = drawYetAnotherModifiedSierpinskiCarpet(4, 3);
        // image = drawYetAnotherModifiedSierpinskiCarpet(4, 5);
        // image = drawModifiedSierpinskiTriangle(6, 3);
        // image = drawModifiedSierpinskiTriangle(6, 5);
        // image = drawSmile(3);

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
















