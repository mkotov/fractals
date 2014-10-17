package base;

// Трёхмерный вектор
public class Vector
{
	private double[] x;
	
	
	public Vector()
	{
		x = new double[3];
		set(0, 0.0);
		set(1, 0.0);
		set(2, 0.0);
	}
	
	
	public Vector(double x1, double x2, double x3)
	{
		x = new double[3];
		set(0, x1);
		set(1, x2);
		set(2, x3);
	}
	
	
	public Vector(double[] v)
	{
		x = new double[3];
		set(0, v[0]);
		set(1, v[1]);
		set(2, v[2]);
	}
	

	@Override public Vector clone()
	{
		return new Vector(x);
	}
	
	
	public double get(int i)
	{
		return x[i];
	}
	
	
	public void set(int i, double t)
	{
		x[i] = t;
	}
	
	// Увеличение i-ой координаты на t
	public void inc(int i, double t)
	{
		x[i] += t;
	}
	
	public double getX()
	{
		return x[0];
	}
	
	
	public void setX(double t)
	{
		x[0] = t;
	}
	
	
	public double getY()
	{
		return x[1];
	}
	
	
	public void setY(double t)
	{
		x[1] = t;
	}
	
	
	public double getZ()
	{
		return x[2];
	}
	
	
	public void setZ(double t)
	{
		x[2] = t;
	}
	
	
	// Сумма векторов
	public Vector plus(Vector p)
	{
		Vector q = clone();
		for (int i = 0; i < 3; ++i)
			q.inc(i, p.get(i));
		return q;
	}
	
	
	// Разность векторов
	public Vector minus(Vector p)
	{
		Vector q = clone();
		for (int i = 0; i < 3; ++i)
			q.inc(i, -p.get(i));
		return q;
	}
	
	
	// Скалярное произведение
	public double dot(Vector p)
	{
		double r = 0.0;
		for (int i = 0; i < 3; ++i)
			r += get(i) * p.get(i);
		return r;
	}
	
	
	// Векторное произведение
	public Vector cross(Vector p)
	{
		return new Vector(
			get(1) * p.get(2) - p.get(1)* get(2),
			-get(0) * p.get(2) + p.get(0)* get(2),
			get(0) * p.get(1) - p.get(0)* get(1));
	}
	
	
	// Норма вектора
	public double norm()
	{
		double r = 0.0;
		for (int i = 0; i < 3; ++i)
			r += get(i) * get(i);
		return Math.sqrt(r);
	}
	
	
	// Косинус угла между векторами
	public double cos(Vector p)
	{
		return dot(p) / (norm() * p.norm());
	}
	
	
	// Умножение на скаляр
	public Vector mul(double a)
	{
		Vector q = createNull();
		for (int i = 0; i < 3; ++i)
			q.set(i, a * get(i));
		return q;
	}
	
	
	// Проекция вектора на вектор p
	public double proj(Vector p)
	{
		return dot(p) / p.norm();
	}
	
	
	// Нулевой вектор
	public static Vector createNull()
	{
		return new Vector(0.0, 0.0, 0.0);
	}
	
	
	// Сдвиг по X
	public static Vector createTranslateX(double d)
	{
		return new Vector(d, 0.0, 0.0);
	}

	
	// Сдвиг по Y
	public static Vector createTranslateY(double d)
	{
		return new Vector(0.0, d, 0.0);
	}	
	
	
	// Сдвиг по Z
	public static Vector createTranslateZ(double d)
	{
		return new Vector(0.0, 0.0, d);
	}	
	
	@Override public String toString()
	{
		return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
	}
}
