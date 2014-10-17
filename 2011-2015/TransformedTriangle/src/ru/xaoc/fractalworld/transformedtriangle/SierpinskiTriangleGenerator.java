package ru.xaoc.fractalworld.transformedtriangle;

import java.util.Random;

public class SierpinskiTriangleGenerator implements Generator {
    Complex z = Complex.ZERO;
    public Complex generatePoint() {
        double r = Math.random();
        if (r < 1./3) {
            z = z.mul(.5);
        } else if (r < 2./3) {
            z = z.mul(.5).add(.5);
        } else {
            z = z.mul(.5).add(new Complex(.25, Math.sqrt(3)/4));
        }
        return z;
    }
}
