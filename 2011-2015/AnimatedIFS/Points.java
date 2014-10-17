public class Points {
    private float[] xs;
    private float[] ys;
    private int count;

    public Points(float[] xs, float[] ys) {
	assert xs.length == ys.length;
	this.xs = xs;
	this.ys = ys;
	count = xs.length;
    }

    public Points(Points ps) {
        xs = ps.xs.clone();
        ys = ps.ys.clone();
        assert xs.length == ys.length;
        count = xs.length;
    }

    public Points() {
        xs = new float[]{0f};
        ys = new float[]{0f};
        count = 1;
    }

    public void transform(Transform f) {
         MKL.affineTransform(count, xs, ys, f.a, f.b, f.c, f.d, f.e, f.f);
	// float t;
        // for (int i = 0; i < count; ++i) {
        //    t     = f.a * xs[i] + f.b * ys[i] + f.e;
        //    ys[i] = f.c * xs[i] + f.d * ys[i] + f.f;
        //    xs[i] = t;
        // }
    }

    public static Points union(Points[] pss) {
        Points ps = new Points();
        int count = 0;
        for (int i = 0; i < pss.length; ++i) {
            count += pss[i].count;
        }
        ps.xs = new float[count];
        ps.ys = new float[count];
        ps.count = count;
        int index = 0;
        for (int i = 0; i < pss.length; ++i) {
            for (int j = 0; j < pss[i].count; ++j) {
                ps.xs[index] = pss[i].xs[j];
                ps.ys[index] = pss[i].ys[j];
                ++index;
            }
        }
        return ps;
    }

    public float getX(int i) {
        assert i < count;
        return xs[i];
    }

    public float getY(int i) {
        assert i < count;
        return ys[i];
    }

    public int getCount() {
        return count;
    }
}
