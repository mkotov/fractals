package whirl;

class Whirl implements Painter.Map
{
    public Whirl(int n, double phi, double r, double R)
    {
        this.n = n;
        this.phi = phi;
        this.r = r;
        this.R = R;
    }

    public Complex map(Complex z)
    {
        double D = R * R + n * r * r;
        double p = Math.random();
        if (p <= R * R / D)
            return z.mul(R).rotate(phi);
        int k = (int)(D * (p - R * R / D) / (r * r));
        return z.mul(r).add(1).rotate(2 * Math.PI * k / n);
    }

    private final int n;

    private final double phi;

    private final double r;

    private final double R;
}
