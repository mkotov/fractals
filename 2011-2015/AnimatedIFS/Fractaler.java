public class Fractaler {
    public static Points calc(Transform[] fs, int n) {
        Points ps = new Points();
        Points[] pss = new Points[fs.length];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < fs.length; ++j) {
                pss[j] = new Points(ps);
                pss[j].transform(fs[j]);
            }
            ps = Points.union(pss);
        }

//        Points ps = MKL.apply(n, fs);
	return ps;
    }
}
