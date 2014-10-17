/*
 * Matvej Kotov, 2009
 * http://fractalworld.xaoc.ru/
 * ilab24@yandex.ru
 */
package juliaset;

import java.awt.Image;
import java.awt.Rectangle;

public interface Painter
{
    public static interface Map
    {
        public Complex map(Complex z);
    }

    Image createImage() throws java.awt.geom.NoninvertibleTransformException;

    void setColorer(Colorer colorer);

    void setMap(Map map);

    void setSize(Rectangle size);
}
