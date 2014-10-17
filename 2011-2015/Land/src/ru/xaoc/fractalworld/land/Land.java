package ru.xaoc.fractalworld.land;

import ru.xaoc.fractalworld.base3d.*;
import ru.xaoc.fractalworld.plasma.Plasma;

public class Land extends Solid
{
    public Land(int countLevels) {
        Colorer landColorer = new LandColorer();
        Colorer waterColorer = new WaterColorer();
        Plasma plasma = new Plasma(countLevels, 0, 0, 0, 0);
        double t = plasma.getSize() / 2;
        double r = plasma.getValue(0, 0);
        double s = 1.0 / plasma.getSize();
        for (int i = 0; i < plasma.getSize(); ++i) {
            for (int j = 0; j < plasma.getSize(); ++j) {
                double n = (plasma.getValue(i, j) - r) * s;
                double m = (plasma.getValue(i + 1, j + 1) - r) * s;
                double p = (plasma.getValue(i, j + 1) - r) * s;
                double q = (plasma.getValue(i + 1, j) - r) * s;
                Vector a = new Vector((i - t) * s, (j - t) * s, n > 0 ? n : 0);
                Vector b = new Vector((i + 1 - t) * s, (j + 1 - t) * s, m > 0 ? m : 0);
                Vector c = new Vector((i - t) * s, (j + 1 - t) * s, p > 0 ? p : 0);
                Vector d = new Vector((i + 1 - t) * s, (j - t) * s, q > 0 ? q : 0);
                add(new Triangle(new Vector[] {a, b, c}, (n > 0 || m > 0 || p > 0) ? landColorer : waterColorer));
                add(new Triangle(new Vector[] {a, d, b}, (n > 0 || q > 0 || m > 0) ? landColorer : waterColorer));
            }
        }
    }
}
