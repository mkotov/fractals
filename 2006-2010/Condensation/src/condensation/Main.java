package condensation;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
    private static final int COUNT_ITER = 300000;

    private static final int BORDER_SIZE = 20;

    private static Painter painter = new Painter();

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
            int scale = Math.min(width, height) / 2 - BORDER_SIZE;
            image = painter.createImage();
        }
    };

    public static void main(String[] args)
    {
        painter.setCount(COUNT_ITER);
        painter.setMap(new CirclesCollection.CirclesInv(3));
        JFrame frame = new JFrame();
        frame.addNotify();
        frame.setSize(frame.getInsets().left +
                frame.getInsets().right + 1024,
                frame.getInsets().top +
                frame.getInsets().bottom + 780);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton("2", new CirclesCollection.Circles(2));
        addButton("half 2", new CirclesCollection.HalfTwoCircles());
        addButton("3", new CirclesCollection.Circles(3));
        addButton("3 inv", new CirclesCollection.CirclesInv(3));
        addButton("4", new CirclesCollection.Circles(4));
        addButton("5", new CirclesCollection.Circles(5));
        addButton("6", new CirclesCollection.Circles(6));
        addButton("p", new CirclesCollection.PyramidCircles());
        addButton("Y", new LinesCollection.YTree(1 / Math.sqrt(2)));
        addButton("smallY", new LinesCollection.YTree(0.5));
        addButton("V", new LinesCollection.VTree());
        addButton("H", new LinesCollection.HTree());
        addButton("Pyth", new LinesCollection.PythagorasTree(Math.PI / 6));
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
                image = painter.createImage();
                centerPanel.repaint();
            }
        });
        buttonPanel.add(button);
    }
}