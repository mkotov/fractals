package FractalStrings;
/**
 * Фрактальные строки
 * Файл содержит классы, необходимые построения СИФ
 * по заданной строке
 * @author Котов Матвей
 * @version 1.0
 */

import java.awt.image.*;
import java.awt.*;
import java.util.*;

/** Обратный вызов для прогрессбара */
interface ProcessCallBack
{
        void callBack(int n);
}

/** Класс, отвечающий за графическое отображение системы итерируемых функций */
class Drawer
{
        public Drawer(ProcessCallBack processCallBack)
        {
                // Заполняем таблицу цветов
                colors.put(0, Color.BLUE);
                colors.put(1, Color.CYAN);
                colors.put(2, Color.RED);
                colors.put(3, Color.GREEN);
                colors.put(4, Color.MAGENTA);
                colors.put(5, Color.ORANGE);
                colors.put(6, Color.PINK);
                colors.put(7, Color.WHITE);
                colors.put(8, Color.YELLOW);
                this.processCallBack = processCallBack;
        }
        
        /** Построить изображение по заданной системе в заданном буфере */
        public void draw(SystemOfTransforms system, BufferedImage image, int count)
        {
                int width  = image.getWidth();
                int height = image.getHeight();
                Graphics graphics = image.getGraphics();
                graphics.setColor(Color.BLACK);
                graphics.fillRect(0, 0, width, height);
                if (system.transforms.length == 0)
                        return;
                double z;
                double dx;
                double dy;
                if (width < height / system.height)
                {
                        z = width;
                        dx = 0.0;
                        dy = height / 2 + z * system.height / 2;
                }
                else
                {
                        z = height / system.height;
                        dx = width / 2 - z / 2;
                        dy = height;
                }
                
                double v;
                double w;
                double x = 0.0;
                double y = 0.0;
                double t;
                int    j;
                int    i = 0;
                int    k;
                int    maxk;
                
                while (i < count)
                {
                        if (Thread.currentThread().isInterrupted())
                                return;
                        processCallBack.callBack((i * 100) / count);
                        k = 0;
                        maxk = Math.min(UNINTCOUNT, count - i + 1);
                        while (k < maxk)
                        {
                                v = Math.random();
                                j = -1;
                                w = 0.0;
                                while (w <= v)
                                        w += system.transforms[++j].p;
                                
                                t = x;
                                x = system.transforms[j].a * x + system.transforms[j].b * y + system.transforms[j].e;
                                y = system.transforms[j].c * t + system.transforms[j].d * y + system.transforms[j].f;
                                try
                                {
                                        image.setRGB((int)(dx + x * z), (int)(dy - z * y),
                                                colors.get(j % colors.size()).getRGB());
                                }
                                catch (ArrayIndexOutOfBoundsException e)
                                {
                                }
                                ++i;
                                ++k;
                        }
                }
        }
        
        private Map<Integer, Color> colors = new HashMap<Integer, Color>();
        private static final int UNINTCOUNT = 10000;
        private ProcessCallBack processCallBack;
}
