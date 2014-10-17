package base;

// Аффинное преобразование трёхмерного пространства
public class Transform
{
	private Matrix M;
	private Vector v;
	
	
	public Matrix getMatrix()
	{
		return M;
	}
	
	public Vector getVector()
	{
		return v;
	}
	
	
	// Матрица НЕ копируется
	public void setMatrix(Matrix N)
	{
		M = N;
	}
	
	// Вектор НЕ копируется
	public void setVector(Vector u)
	{
		v = u;
	}	
	
	private Transform()
	{
		setMatrix(Matrix.createNull());
		setVector(Vector.createNull());
	}
	
	
	// Матрица и вектор НЕ копируются
	private Transform(Matrix N, Vector u)
	{
		setMatrix(N);
		setVector(u);
	}	
	
	
	public Vector apply(Vector p)
	{
		return M.mul(p).plus(v);
	}
	
	
	public Vector[] apply (Vector[] v)
	{
		Vector[] u = new Vector[v.length];
		for (int i = 0; i < v.length; ++i)
			u[i] = apply(v[i]);
		return u;
	}
	

	public Triangle apply (Triangle triangle)
	{
		return new Triangle(apply(triangle.getVertexes()), triangle.getColorer());
	}	
	
	public Solid apply (Solid solid)
	{
		Solid result = new Solid();
		for (Triangle triangle : solid)
			result.add(apply(triangle));
		return result;
	}	

	
	public Transform composite (Transform T) // действие "слева"
	{	
		return new Transform(T.getMatrix().mul(getMatrix()),
			T.getMatrix().mul(getVector()).plus(T.getVector()));
	}
	
	
	// Обратное преобразование
	public Transform inverse()
	{
		return new Transform(getMatrix().inverse(), getMatrix().inverse().mul(getVector()).mul(-1.0));
	}
	
	
	// Нулевая матрица
	public static Transform createNull()
	{
		return new Transform();
	}
	
	
	// Единичная матрица
	public static Transform createIdent()
	{
		return new Transform(Matrix.createIdent(), Vector.createNull());
	}
	
	
	public static Transform createRotateX(double a)
	{
		return new Transform(Matrix.createRotateX(a), Vector.createNull());
	}	

	
	public static Transform createRotateY(double a)
	{
		return new Transform(Matrix.createRotateY(a), Vector.createNull());
	}	

	
	public static Transform createRotateZ(double a)
	{
		return new Transform(Matrix.createRotateZ(a), Vector.createNull());
	}

	
	public static Transform createTranslate(double dx, double dy, double dz)
	{
		return new Transform(Matrix.createIdent(), new Vector(dx, dy, dz));
	}
	
	
	public static Transform createTranslateX(double dx)
	{
		return new Transform(Matrix.createIdent(), Vector.createTranslateX(dx));
	}
	
	
	public static Transform createTranslateY(double dy)
	{
		return new Transform(Matrix.createIdent(), Vector.createTranslateY(dy));
	}
	
	
	public static Transform createTranslateZ(double dz)
	{
		return new Transform(Matrix.createIdent(), Vector.createTranslateZ(dz));
	}
	
	
	public static Transform createScale(double a, double b, double c)
	{
		return new Transform(Matrix.createScale(a, b, c), Vector.createNull());
	}			
}
