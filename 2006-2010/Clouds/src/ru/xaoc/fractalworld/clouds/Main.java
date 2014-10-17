package ru.xaoc.fractalworld.clouds;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
    private static final double SX = 0.004;
    private static final double SY = 0.004;
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final double DX = -400;
    private static final double DY = -235;
    private static final int COUNT_ITER = 500;
    private static final int BOIL_OUT = 4;
    private static final int STEP_X = 10;
    private static final int STEP_Y = 10;

    private static void drawClouds(Graphics g)
    {
        for (int i = 0; i < WIDTH; i += STEP_X)
        {
            for (int j = 0; j < HEIGHT; j += STEP_Y)
            {
                double c = SX * (i + DX);
                double d = SY * (j + DY);
                double x = c;
                double y = d;
                double t;
                int k = 0;
                while (x * x + y * y < BOIL_OUT && k < COUNT_ITER)
                {
                    t = x * x - y * y + c;
                    y = 2 * x * y + d;
                    x = t;
                    ++k;
                }
                if (k == COUNT_ITER)
                {
                    x = c;
                    y = d;
                    k = 0;
                    g.setColor(new Color((float) Math.random(), (float) Math.random(), (float) Math.random()));
                    while (k < COUNT_ITER)
                    {
                        t = x * x - y * y + c;
                        y = 2 * x * y + d;
                        x = t;
                        ++k;
                        g.fillRect((int) (x / SX - DX), (int) (y / SY - DY), 1, 1);

                    }

                }

            }
        }
    }

    public static void main(String[] args)
    {
        {
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
                    super.paintComponent(g);
                    drawClouds(g);
                }

            });
            frame.setVisible(true);
        }
    }

}