package condensation;

import static condensation.Complex.I;
import static condensation.Complex.exp;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.random;

public class LinesCollection
{
    public static class YTree implements Painter.Map
    {
        public YTree(double r)
        {
            this.r = r;
        }

        public Complex map(Complex z)
        {
            double p = random();
            if (p <= 0.005)
                return Complex.Random.random().rotate(-PI / 2);
            if (p <= 0.475)
                return z.add(I).mul(r).rotate(PI / 4);
            return z.add(I).mul(r).rotate(-PI / 4);
        }

        private double r;
    }

    public static class VTree implements Painter.Map
    {
        public Complex map(Complex z)
        {
            double p = random();
            if (p <= 0.005)
                return Complex.Random.random().rotate(PI / 4);
            if (p <= 0.01)
                return Complex.Random.random().rotate(3 * PI / 4);
            if (p <= 0.6)
                return z.div(2).add(exp(I.mul(PI / 4)));
            return z.div(2).add(exp(I.mul(3 * PI / 4)));
        }
    }

    public static class HTree implements Painter.Map
    {
        public Complex map(Complex z)
        {
            double p = random();
            if (p <= 0.067)
                return Complex.Random.random().mul(2).sub(1);
            if (p <= 0.133)
                return Complex.Random.random().sub(0.5).rotate(PI / 2).add(1);
            if (p <= 0.2)
                return Complex.Random.random().sub(0.5).rotate(PI / 2).sub(1);
            if (p <= 0.4)
                return z.div(2.5).add(new Complex(1, 0.5));
            if (p <= 0.6)
                return z.div(2.5).add(new Complex(-1, 0.5));
            if (p <= 0.8)
                return z.div(2.5).add(new Complex(1, -0.5));
            return z.div(2.5).add(new Complex(-1, -0.5));
        }
    }

    public static class PythagorasTree implements Painter.Map
    {
        public Complex map(Complex z)
        {
            double p = random();
            if (p <= 0.005)
                return Complex.Random.random().add(new Complex(-0.5, 0.5));
            if (p <= 0.01)
                return Complex.Random.random().add(new Complex(-0.5, -0.5));
            if (p <= 0.015)
                return Complex.Random.random().rotate(PI / 2).add(new Complex(-0.5, -0.5));
            if (p <= 0.02)
                return Complex.Random.random().rotate(PI / 2).add(new Complex(0.5, -0.5));
            if (p <= 0.02 + 0.98 * cos(phi) * cos(phi))
                return z.mul(cos(phi)).rotate(-phi).add(new Complex(0.5, 0.5)).add(new Complex(-0.5, 0.5).mul(cos(phi)).rotate(-phi));
            return z.mul(sin(phi)).rotate(PI / 2 - phi).add(new Complex(-0.5, 0.5)).add(new Complex(0.5, 0.5).mul(sin(phi)).rotate(PI / 2 - phi));
        }

        public PythagorasTree(double phi)
        {
            this.phi = phi;
        }

        private double phi;
    }
}
