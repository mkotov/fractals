/*
 * Matvej Kotov, 2009
 * http://fractalworld.xaoc.ru/
 * ilab24@yandex.ru
 */
package whirl;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Main
{
    private static ActionListener repaintActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            painter.setMap(new Whirl(
                    (Integer)nSpinner.getValue(),
                    2 * Math.PI * phiSlider.getValue() / DISCR_PHI / (Integer)nSpinner.getValue(),
                    (double)rSlider.getValue() / DISCR_R,
                    (double)RSlider.getValue() / DISCR_R));
            image = painter.createImage();
            centerPanel.repaint();
        }
    };

    private static final int COUNT_ITER = 1000000;

    private static int DISCR_PHI = 100;
    private static int DISCR_R = 100;

    private static Painter painter = new Painter();

    private static Image image;

    private static JPanel buttonPanel = new JPanel();

    private static JSpinner nSpinner = new JSpinner(new SpinnerNumberModel(12, 3, 50, 1));

    private static JSlider phiSlider = new JSlider(0, DISCR_PHI, 0);

    private static JSlider rSlider = new JSlider(0, DISCR_R, 15);

    private static JSlider RSlider = new JSlider(0, DISCR_R, 70);

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
            image = painter.createImage();
        }
    };

    public static void main(String[] args)
    {
        painter.setCount(COUNT_ITER);
        painter.setMap(new Whirl(12, Math.PI / 10, 0.15, 0.7));
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

        buttonPanel.add(new JLabel("n"));
        buttonPanel.add(nSpinner);
        JButton drawButton = new JButton("Построить");
        drawButton.addActionListener(repaintActionListener);
        buttonPanel.add(new JLabel("phi"));
        buttonPanel.add(phiSlider);
        buttonPanel.add(new JLabel("r"));
        buttonPanel.add(rSlider);
        buttonPanel.add(new JLabel("R"));
        buttonPanel.add(RSlider);

        buttonPanel.add(drawButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}