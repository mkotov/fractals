package tetrahedron;

import base.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Main extends JApplet
{
    private Drawer drawer = new Drawer(Tetrahedron.createTetrahedron(5),
            new PainterImageBuilder());

    private Image image;

    private double phi = 0;

    private double psi = Math.PI / 12;

    private double theta = -Math.PI / 12;

    private double deltaPhi = 0.01;

    private double deltaPsi = 0.02;

    private double deltaTheta = 0.02;

    private Vector sun = new Vector(-1.2, 0.5, 1.0);

    private Random random = new Random();

    Timer timer2 = new Timer(50000, new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            deltaPhi *= random.nextBoolean() ? 1 : -1;
            deltaPsi *= random.nextBoolean() ? 1 : -1;
            deltaTheta *= random.nextBoolean() ? 1 : -1;
        }
    });

    Timer timer1 = new Timer(500, new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            image = drawer.draw(400, 400, sun,
                    Transform.createRotateZ(theta).composite(
                    Transform.createRotateY(psi).composite(
                    Transform.createRotateX(phi).composite(
                    Transform.createScale(1, 1, -1).composite(
                    Transform.createTranslate(0, 200, 200))))));
            repaint();
            phi += deltaPhi;
            psi += deltaPsi;
            theta += deltaTheta;
        }
    });

    @Override
    public void update(Graphics g)
    {
        paint(g);
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D G = (Graphics2D)g;
        if (image != null)
            G.drawImage(image, 0, 0, null);
    }

    @Override
    public void start()
    {
        super.start();
        timer1.start();
        timer2.start();
    }

    @Override
    public void stop()
    {
        super.stop();
        timer1.stop();
        timer2.stop();
    }
}
