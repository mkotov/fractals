package condensation;

import static java.lang.Math.sqrt;
import static java.lang.Math.PI;
import static java.lang.Math.sin;

public class CirclesCollection
{
    public static class PyramidCircles implements Painter.Map
    {
        public Complex map(Complex z)
        {
            double p = Math.random();
            if (p <= 1.0 / 3)
                return Complex.Random.randomPointOnCircle();
            if (p <= 2.0 / 3)
                return z.mul(1.0 / 3).add(2.0 / 3);
            return z.mul(1.0 / 3).add(4.0 / 3);
        }
    }

    public static class HalfTwoCircles implements Painter.Map
    {
        public Complex map(Complex z)
        {
            double p = Math.random();
            if (p <= 1.0 / 3.0)
                return Complex.sqrt(Complex.Random.randomPointOnCircle()).rotate(PI / 2);
            if (p <= 2.0 / 3.0)
                return z.add(1.0).mul(0.5);
            return z.add(-1.0).mul(0.5);
        }
    }

    public static class Circles implements Painter.Map
    {
        public Circles(int n)
        {
            this.n = n;
        }

        public Complex map(Complex z)
        {
            double p = Math.random();
            if (p <= 0.05)
                return Complex.Random.randomPointOnCircle();
            return z.div(1 + 1 / sin(PI / n)).add(1 / (1 + sin(PI / n))).mul(
                    Complex.Random.randomPointOnCircle(n));
        }

        private int n;
    }

    public static class CirclesInv implements Painter.Map
    {
        public CirclesInv(int n)
        {
            this.n = n;
        }

        public Complex map(Complex z)
        {
            double p = Math.random();
            if (p <= 0.05)
                return Complex.Random.randomPointOnCircle();
            return z.div(-1 - 1 / sin(PI / n)).add(1 / (1 + sin(PI / n))).mul(
                    Complex.Random.randomPointOnCircle(n));
        }

        private int n;
    }
}