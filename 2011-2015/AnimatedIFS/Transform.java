public class Transform {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public Transform(float a, float b, float c, float d, float e, float f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public static Transform sum(Transform f, Transform g, float u, float v) {
        return new Transform(
                f.a * u + g.a * v,
                f.b * u + g.b * v,
                f.c * u + g.c * v,
                f.d * u + g.d * v,
                f.e * u + g.e * v,
                f.f * u + g.f * v);
    }

    public static final Transform zero = new Transform(0, 0, 0, 0, 0, 0);
}
