/*
 * Matvej Kotov, 2009
 * http://fractalworld.xaoc.ru/
 * ilab24@yandex.ru
 */
package juliaset;

class JuliaSetCollection
{
    public static class JuliaSet implements Painter.Map
    {
        public JuliaSet(int n, Complex c)
        {
            this.n = n;
            this.c = c;
        }

        public Complex map(Complex z)
        {
            return Complex.pow(z, n).add(c);
        }

        private int n;

        private Complex c;
    }

    public static class Polygon implements Painter.Map
    {
        public Polygon(int n, double r)
        {
            this.n = n;
            this.r = r;
        }

        public Complex map(Complex z)
        {
            int k = (int)Math.floor(Complex.arg(z) / 2 / Math.PI * n + 0.5);
            return z.rotate(-2 * Math.PI * k / n).sub(1).div(r);
        }

        private int n;

        private double r;
    }

    public static class Whirl implements Painter.Map
    {
        public Whirl(int n, double r, double phi, double R)
        {
            this.n = n;
            this.r = r;
            this.phi = phi;
            this.R = R;
        }

        public Complex map(Complex z)
        {
            if (Complex.abs(z) < 1 - r / (1 - r))
                return z.div(R).rotate(-phi);
            int k = (int)Math.floor(Complex.arg(z) / 2 / Math.PI * n + 0.5);
            return z.rotate(-2 * Math.PI * k / n).sub(1).div(r);
        }

        private int n;

        private double r;

        private double phi;

        private double R;
    }

    public static class Binary implements Painter.Map
    {
        public Complex map(Complex z)
        {
            if (z.getReal() > 0 && z.getImag() < 0)
                return z.mul(2).add(new Complex(-1, 1));
            else if (z.getReal() > 0 && z.getImag() > 0)
                return z.mul(2).add(new Complex(-1, -1)).rotate(- Math.PI / 2);
            return z.mul(2).add(new Complex(1, 1));
        }
    }
}