
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
// import javax.imageio.ImageIO;
// import java.io.File;


public class Main {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static BufferedImage image;
    private static Timer timer;
    private static int i = 0;
//    private static int j = 0;
    private static JPanel panel;
    private static int first = 0;
    private static int second = 1;

    public static void main(String[] args) {

        final Transform[][] fss = new Transform[][]{
            new Transform[]{
                new Transform(.5f, 0, 0, .5f, 0, .5f),
                new Transform(.5f, 0, 0, .5f, -.25f, 0),
                new Transform(.5f, 0, 0, .5f, .25f, 0),},
            new Transform[]{
                new Transform(.5f, 0, 0, -.5f, 0, 0),
                new Transform(.5f, 0, 0, -.5f, .5f, 0),
                new Transform(.5f, 0, 0, -.5f, .25f, .433013f)},
            new Transform[]{
                new Transform(.5f, -.5f, .5f, .5f, 0, 0),
                new Transform(-.5f, .5f, -.5f, -.5f, 0.75f, .25f),},
        new Transform[]{
                new Transform(.5f, .288675f, .288675f, -.5f, 0, 0),
                new Transform(.5f, -.288675f, -.288675f, -.5f, .5f, .288675f),},
        };

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        timer = new Timer(50, new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                Animator.animate(image, fss[first], fss[second], i, 10, new Transform(300, 0, 0, -300, 300, 350));
//                try {
//			ImageIO.write(image, "PNG", new File("/tmp/vifs/" + j + ".png"));
//		} catch (Exception ex) {
//		}	
		panel.repaint();
                ++i;
//		++j;
                if (i > Animator.COUNT) {
                    second = first;
                    first = (int)Math.floor(Math.random() * fss.length);
                    if (second != first) {
                         i = 0;
                    }
                }
            }
        });

        JFrame frame = new JFrame();
        frame.addNotify();
        frame.setSize(frame.getInsets().left
                + frame.getInsets().right + WIDTH,
                frame.getInsets().top
                + frame.getInsets().bottom + HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                Graphics2D G = (Graphics2D) g;
                if (image != null) {
                    G.drawImage(image, 0, 0, null);
                }
            }
        });
        frame.setVisible(true);
        timer.start();

    }
}
