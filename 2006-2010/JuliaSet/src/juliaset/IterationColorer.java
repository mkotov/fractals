/*
 * Matvej Kotov, 2009
 * http://fractalworld.xaoc.ru/
 * ilab24@yandex.ru
 */

package juliaset;

import java.awt.Color;

public class IterationColorer implements Colorer
{
    private static final Color[] colors =
    {
        Color.BLACK,
        Color.BLUE,
        Color.GREEN,
        Color.CYAN,
        Color.RED,
        Color.MAGENTA,
        Color.LIGHT_GRAY,
        Color.DARK_GRAY,
        Color.GRAY,
        Color.ORANGE,
        Color.PINK,
        Color.YELLOW,
        Color.WHITE
    };

    public Color getColor(int iter, Complex z)
    {
        return colors[iter % colors.length];
    }
}
