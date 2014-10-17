/*
 * Matvej Kotov, 2009
 * http://fractalworld.xaoc.ru/
 * ilab24@yandex.ru
 */
package juliaset;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.NoninvertibleTransformException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
    private static Painter painter = new JuliaPainter();

    private static Image image;

    private static JPanel buttonPanel = new JPanel();

    private static JPanel centerPanel = new JPanel()
    {
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D G = (Graphics2D)g;
            G.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }

        @Override
        public void setBounds(int x, int y, int width, int height)
        {
            super.setBounds(x, y, width, height);
            painter.setSize(new Rectangle(width, height));
            try
            {
                image = painter.createImage();
            }
            catch (NoninvertibleTransformException ex)
            {
            }
        }
    };

    public static void main(String[] args)
    {
        painter.setColorer(new IterationColorer());
        painter.setMap(new JuliaSetCollection.JuliaSet(2, Complex.I));
        centerPanel.repaint();
        JFrame frame = new JFrame();
        frame.addNotify();
        frame.setSize(frame.getInsets().left +
                frame.getInsets().right + 1024,
                frame.getInsets().top +
                frame.getInsets().bottom + 780);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(centerPanel, BorderLayout.CENTER);

        addButton("Julia 2", new JuliaSetCollection.JuliaSet(2, Complex.I));
        addButton("Sierpinski", new JuliaSetCollection.Polygon(3, 0.5));
        addButton("Hexagon", new JuliaSetCollection.Polygon(6, 1.0 / 3));
        addButton("Whirl", new JuliaSetCollection.Whirl(12, 0.15, Math.PI / 13, 0.7));
        addButton("Pentagon", new JuliaSetCollection.Whirl(5, 0.37, Math.PI, 0.2));
        addButton("Binary", new JuliaSetCollection.Binary());
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void addButton(String name, final Painter.Map map)
    {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                painter.setMap(map);
                try
                {
                    image = painter.createImage();
                }
                catch (NoninvertibleTransformException ex)
                {
                }
                centerPanel.repaint();
            }
        });
        buttonPanel.add(button);
    }
}