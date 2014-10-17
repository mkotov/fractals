/*
 * Matvej Kotov, 2009
 * http://fractalworld.xaoc.ru/
 * ilab24@yandex.ru
 */

package juliaset;

import java.awt.Color;

public interface Colorer
{
    public Color getColor(int iter, Complex z);
}
