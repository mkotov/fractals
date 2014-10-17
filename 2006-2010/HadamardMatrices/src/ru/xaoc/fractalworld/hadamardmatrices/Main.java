package ru.xaoc.fractalworld.hadamardmatrices;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
    private static final int WIDTH = 512;
    private static final int HEIGHT = 512;
    private static BufferedImage image;
    private static Graphics2D graph;
    private static Color[] colors =
    {
        Color.BLUE,
        Color.ORANGE,
        Color.RED,
        Color.BLACK
    };

    private static int[][] createHadamardMatrix(int m)
    {
        int size = WIDTH;
        int[][] b = new int[size][m];

        for (int i = 0; i < size; ++i)
        {
            int k = 1;
            for (int j = 0; j < m; ++j)
            {
                b[i][j] = (i / k) % 2;
                k *= 2;
            }
        }

        int[][] H = new int[size][size];
        for (int i = 0; i < size; ++i)
        {
            for (int j = 0; j < size; ++j)
            {
                int sum = 0;
                for (int k = 0; k < m; ++k)
                {
                    sum += b[i][k] * b[j][k];
                    
                }
                H[i][j] = sum;
            }
        }

        return H;
    }

    private static void drawHadamardMatrix(int[][] H)
    {
        int size = H.length;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j)
            {
                graph.setColor(colors[H[i][j] % colors.length]);
                graph.fillRect(i, j, 1, 1);
            }
        }
    }

    public static void main(String[] args)
    {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        graph = image.createGraphics();
        graph.setColor(Color.WHITE);
        graph.fill(new Rectangle2D.Double(0, 0, WIDTH, HEIGHT));

        int[][] H = createHadamardMatrix(9);
        drawHadamardMatrix(H);

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
