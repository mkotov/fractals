import java.awt.image.BufferedImage;

public class Animator {
    public static final int COUNT = 100;
    public static void animate(BufferedImage image, Transform[] fs, Transform[] gs, int i, int n, Transform t) {
        int count = Math.max(fs.length, gs.length);
        Transform[] fsz = new Transform[count];
        Transform[] gsz = new Transform[count];

        for (int j = 0; j < fs.length; ++j) {
            fsz[j] = fs[j];
        }
        for (int j = fs.length; j < count; ++j) {
            fsz[j] = Transform.zero;
        }
        for (int j = 0; j < gs.length; ++j) {
            gsz[j] = gs[j];
        }
        for (int j = gs.length; j < count; ++j) {
            gsz[j] = Transform.zero;
        }
        Transform[] hs = new Transform[count];
        for (int j = 0; j < hs.length; ++j) {
            hs[j] = Transform.sum(fsz[j], gsz[j], (float)i / COUNT,
                    (float)(COUNT - i) / COUNT);
        }
        Painter.paint(image, Fractaler.calc(hs, n), t);
    }
}
