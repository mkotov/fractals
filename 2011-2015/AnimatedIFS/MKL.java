public class MKL {
	static {
		System.loadLibrary("MKL");
	}

	public static native void affineTransform(int n, float[] xs, float[] ys, float a, float b, float c, float d, float e, float f);
	public static native Points apply(int n, Transform[] fs);
}
