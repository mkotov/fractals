import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Painter {
    public static void paint(BufferedImage image, Points ps, Transform f) {
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        float x;
        float y;
        float t;
        for (int i = 0; i < ps.getCount(); ++i) {
            x = ps.getX(i);
            y = ps.getY(i);
            t = f.a * x + f.b * y + f.e;
            y = f.c * x + f.d * y + f.f;
            x = t;
            if (x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight()) {
                image.setRGB((int)x, (int)y, 0xFFFFFF);
            }
        }
    }
}
