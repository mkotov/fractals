package base;

// Квадратная матрица 3 x 3
public class Matrix
{
	private double[][] M;
	
	
	public Matrix()
	{
		M = new double[3][];
		for (int i = 0; i < 3; ++i)
		{
			M[i] = new double[3];
			for (int j = 0; j < 3; ++j)
				M[i][j] = 0.0;
		}
	}
	

	public Matrix(double [][] N)
	{
		M = new double[3][];
		for (int i = 0; i < 3; ++i)
		{
			M[i] = new double[3];
			for (int j = 0; j < 3; ++j)
				M[i][j] = N[i][j];
		}
	}

	
	public Matrix(double x11, double x12, double x13, 
		      double x21, double x22, double x23, 
		      double x31, double x32, double x33)
	{
		M = new double[3][];
		for (int i = 0; i < 3; ++i)
			M[i] = new double[3];
		set(0, 0, x11); set(0, 1, x12); set(0, 2, x13);
		set(1, 0, x21); set(1, 1, x22); set(1, 2, x23);
		set(2, 0, x31); set(2, 1, x32); set(2, 2, x33);
	}
	
	
	public double get(int i, int j)
	{
		return M[i][j];
	}
	
	
	public void set(int i, int j, double t)
	{
		M[i][j] = t;
	}
	
	
	// Увеличить элемент на t
	public void inc(int i, int j, double t)
	{
		M[i][j] += t;
	}	
	
	
	@Override public Matrix clone()
	{
		return new Matrix(M);
	}
	
	
	// Сумма матриц
	public Matrix plus(Matrix N)
	{
		Matrix K = clone();
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				K.inc(i, j, N.get(i, j));
		return K;
	}
	
	
	// Разность матриц
	public Matrix minus(Matrix N)
	{
		Matrix K = clone();
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				K.inc(i, j, -N.get(i, j));
		return K;
	}
	
	
	// Умножение на матрицу
	public Matrix mul(Matrix N)
	{
		Matrix K = createNull();
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				for (int k = 0; k < 3; ++k)
					K.inc(i, j, get(i, k) * N.get(k, j));
		return K;
	}
	
	
	// Умножение на вектор
	public Vector mul(Vector p)
	{
		Vector v = Vector.createNull();
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				v.inc(i, get(i, j) * p.get(j));
		return v;						
	}	
	
	// Умножение на скаляр
	public Matrix mul(double a)
	{
		Matrix K = createNull();
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				K.set(i, j, a * get(i, j));
		return K;		
	}
	
	public double det()
	{
		return  M[0][0] * M[1][1] * M[2][2] + 
			M[1][0] * M[2][1] * M[0][2] + 
			M[2][0] * M[0][1] * M[1][2] -
			M[2][0] * M[1][1] * M[0][2] - 
			M[1][0] * M[0][1] * M[2][2] - 
			M[0][0] * M[2][1] * M[1][2];
	}
	
	public Matrix inverse()
	{
		Matrix K = new Matrix(
			 M[1][1] * M[2][2] - M[2][1] * M[1][2],
			-M[0][1] * M[2][2] + M[2][1] * M[0][2],
			 M[0][1] * M[1][2] - M[1][1] * M[0][2],
			-M[1][0] * M[2][2] + M[2][0] * M[1][2],
			 M[0][0] * M[2][2] - M[2][0] * M[0][2],
			-M[0][0] * M[1][2] + M[1][0] * M[0][2],
			 M[1][0] * M[2][1] - M[2][0] * M[1][1],
			-M[0][0] * M[2][1] + M[2][0] * M[0][1],
			 M[0][0] * M[1][1] - M[1][0] * M[0][1]
		);
		return K.mul(1.0 / det());
	}
	
	
	// Создать нулевую матрицу
	public static Matrix createNull()
	{
		return new Matrix();
	}
	
	
	// Создать единичную матрицу
	public static Matrix createIdent()
	{
		Matrix K = createNull();
		for (int i = 0; i < 3; ++i)
			K.set(i, i, 1.0);
		return K;				
	}
	
	
	public static Matrix createRotateX(double a)
	{
		Matrix T = new Matrix();
		T.set(0, 0, 1);
		T.set(1, 1, Math.cos(a));
		T.set(2, 2, Math.cos(a));
		T.set(1, 2, -Math.sin(a));
		T.set(2, 1, Math.sin(a));
		return T;
	}	

	
	public static Matrix createRotateY(double a)
	{	
		Matrix T = new Matrix();
		T.set(1, 1, 1);
		T.set(0, 0, Math.cos(a));
		T.set(2, 2, Math.cos(a));
		T.set(0, 2, Math.sin(a));
		T.set(2, 0, -Math.sin(a));
		return T;
	}	

	
	public static Matrix createRotateZ(double a)
	{
		Matrix T = new Matrix();
		T.set(2, 2, 1);
		T.set(0, 0, Math.cos(a));
		T.set(1, 1, Math.cos(a));
		T.set(0, 1, -Math.sin(a));
		T.set(1, 0, Math.sin(a));
		return T;
	}	
	
	
	public static Matrix createScale(double a, double b, double c)
	{
		Matrix T = new Matrix();
		T.set(0, 0, a);
		T.set(1, 1, b);
		T.set(2, 2, c);		
		return T;		
	}
	
	@Override public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
			{
				builder.append(M[i][j]);
				if (j != 2 || i != 2)
					builder.append(", ");
			}
		builder.append(")");
		return builder.toString();
	}
}
