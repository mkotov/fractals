package ru.xaoc.fractalworld.plasma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    static float[][] x;

    static void calc(int a, int b, int c, int d) {
        if (a + 1 == c || b + 1 == d) {
            return;
        }
        float r = ((c - a) + (d - b)) / 4;
        int e  = (a + c) / 2;
        int f = (b + d) / 2;
        x[e][f] =
                (x[a][b] + x[a][d] + x[c][b] + x[c][d]) / 4 +
                r * (float)(Math.random() - .5);
        x[e][b] = (x[a][b] + x[c][b]) / 2;
        x[e][d] = (x[a][d] + x[c][d]) / 2;
        x[a][f] = (x[a][b] + x[a][d]) / 2;
        x[c][f] = (x[c][b] + x[c][d]) / 2;
        calc(a, b, e, f);
        calc(a, f, e, d);
        calc(e, b, c, f);
        calc(e, f, c, d);
    }
    
    static Color floatToColor(float x) {
        if (x <= 0) {
            return new Color(1f, 0f, 0f);
        }
        if (x <= 1f/6) {
            return new Color(1f, x * 6f, 0f);
        }
        if (x <= 2f/6) {
            return new Color(1f - (x - 1f/6) * 6f, 1f, 0f);
        }
        if (x <= 3f/6) {
            return new Color(0f, 1f, (x - 2f/6f) * 6f);
        }
        if (x <= 4f/6) {
            return new Color(0f, 1f - (x - 3f/6f) * 6f, 1f);
        }
        if (x <= 5f/6) {
            return new Color((x - 4f/6) * 6f, 0f, 1f);
        }
        if (x < 1f) {
            return new Color(1f, 0f, 1f - (x - 5f/6f) * 6f);
        }
        return new Color(1f, 0f, 0f);
    }

    static BufferedImage createPlasma(int countLevels) {
        int size = (int)Math.round(Math.pow(2, countLevels));
        BufferedImage image = new BufferedImage(size + 1, size + 1,
                BufferedImage.TYPE_INT_RGB);
        x = new float[size + 1][size + 1];
        x[0][0] = (float)Math.random() * size / 2 - size / 4;
        x[0][size] = (float)Math.random() * size / 2 - size / 4;
        x[size][0] = (float)Math.random() * size / 2 - size / 4;
        x[size][size] = (float)Math.random() * size / 2 - size / 4;
        calc(0, 0, size, size);
        float min = Float.MAX_VALUE;
        float max = Float.MIN_VALUE;
        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (x[i][j] < min) {
                    min = x[i][j];
                }
                if (x[i][j] > max) {
                    max = x[i][j];
                }
            }
        }

        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                image.setRGB(j, i,
                        floatToColor((x[i][j] - min) / (max - min)).getRGB());
            }
        }
        return image;
    }

    static Image image;


    public static void main(String[] args) {
        image = createPlasma(9);
        JFrame frame = new JFrame();
        frame.addNotify();
        frame.setSize(frame.getInsets().left
                + frame.getInsets().right + image.getWidth(null),
                frame.getInsets().top
                + frame.getInsets().bottom + image.getHeight(null));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D G = (Graphics2D) g;
                if (image != null) {
                    G.drawImage(image, 0, 0, null);
                }
            }
        });
        frame.setVisible(true);
    }
}

