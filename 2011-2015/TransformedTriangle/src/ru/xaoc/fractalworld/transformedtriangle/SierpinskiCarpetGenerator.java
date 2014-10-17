package ru.xaoc.fractalworld.transformedtriangle;

public class SierpinskiCarpetGenerator implements Generator {
    Complex z = Complex.ZERO;
    public Complex generatePoint() {
        double r = Math.random();
        if (r < .125) {
            z = z.mul(1./3);
        } else if (r < .25) {
            z = z.mul(1./3).add(1./3);
        } else if (r < .375) {
            z = z.mul(1./3).add(2./3);
        } else if (r < .5) {
            z = z.mul(1./3).add(new Complex(0, 1./3));
        } else if (r < .625) {
            z = z.mul(1./3).add(new Complex(2./3, 1./3));
        } else if (r < .75) {
            z = z.mul(1./3).add(new Complex(0, 2./3));
        } else if (r < .875) {
            z = z.mul(1./3).add(new Complex(1./3, 2./3));
        } else {
            z = z.mul(1./3).add(new Complex(2./3, 2./3));
        }
        return z;
    }
}
