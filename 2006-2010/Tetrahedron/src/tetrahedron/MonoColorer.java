package tetrahedron;

import base.*;
import java.awt.*;

public class MonoColorer implements Colorer
{
    private Color color;

    public MonoColorer(Color color)
    {
        this.color = color;
    }

    public Color getColor(Solid solid, Triangle triangle,
            Vector point, Vector sun)
    {
        return color;
    }
}
