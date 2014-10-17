/*
 * Matvej Kotov, 2009
 * http://fractalworld.xaoc.ru/
 * ilab24@yandex.ru
 */

package juliaset;

import static java.lang.Math.PI;

/**
 * Класс реализует основные функции и операции над комплексными числами
 */
public class Complex
{
    /**
     * Конструктор по действительной и мнимой частям
     */
    public Complex(double real, double imag)
    {
        this.real = real;
        this.imag = imag;
    }

    /**
     * Конструктор комплексных чисел вида real + i * 0
     */
    public Complex(double real)
    {
        this(real, 0.0);
    }

    @Override
    public String toString()
    {
        if (real == 0 && imag == 0)
            return "0";
        if (real == 0)
            return imag + "i";
        if (imag == 0)
            return real + "";
        if (imag < 0)
            return real + " - " + imag + "i";
        return real + " + " + imag + "i";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (obj.getClass() != this.getClass())
            return false;

        Complex z = (Complex)obj;
        return z.imag == imag && z.real == real;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 89 * hash + (int)(Double.doubleToLongBits(this.real) ^ (Double.doubleToLongBits(this.real) >>> 32));
        hash = 89 * hash + (int)(Double.doubleToLongBits(this.imag) ^ (Double.doubleToLongBits(this.imag) >>> 32));
        return hash;
    }

    /**
     * @return z * conj(z)
     */
    public static double norm(Complex z)
    {
        return z.real * z.real + z.imag * z.imag;
    }

    /**
     * @return |z| = sqrt(z * conj(z))
     */
    public static double abs(Complex z)
    {
        return Math.sqrt(norm(z));
    }

    /**
     * @return this + z
     */
    public Complex add(Complex z)
    {
        return new Complex(real + z.real, imag + z.imag);
    }

    /**
     * @return this + r
     */
    public Complex add(double r)
    {
        return new Complex(real + r, imag);
    }

    /**
     * @return this - z
     */
    public Complex sub(Complex z)
    {
        return new Complex(real - z.real, imag - z.imag);
    }

    /**
     * @return this - r
     */
    public Complex sub(double r)
    {
        return new Complex(real - r, imag);
    }

    /**
     * @return this * z
     */
    public Complex mul(Complex z)
    {
        return new Complex(real * z.real - imag * z.imag,
                imag * z.real + real * z.imag);
    }

    /**
     * @return this * r
     */
    public Complex mul(double r)
    {
        return new Complex(real * r, imag * r);
    }

    /**
     * @return this / z
     */
    public Complex div(Complex z)
    {
        return this.mul(conj(z)).div(norm(z));
    }

    /**
     * @return this / r
     */
    public Complex div(double r)
    {
        return this.mul(1.0 / r);
    }

    /**
     * @return z ^ 2
     */
    public static Complex sqr(Complex z)
    {
        return z.mul(z);
    }

    /**
     * @return сопряжённое к z число
     */
    public static Complex conj(Complex z)
    {
        return new Complex(z.real, -z.imag);
    }

    /**
     * @return аргумент числа z
     */
    public static double arg(Complex z)
    {
        return Math.atan2(z.imag, z.real);
    }

    /**
     * @return this * exp(i * phi)
     */
    public Complex rotate(double phi)
    {
        return this.mul(new Complex(Math.cos(phi), Math.sin(phi)));
    }

    /**
     * @return 1 / z
     */
    public static Complex inv(Complex z)
    {
        return new Complex(1.0).div(z);
    }

    /**
     * exp(z) = exp(Re(z)) * (cos(Im(z)) + i * sin (Im(z)))
     */
    public static Complex exp(Complex z)
    {
        return new Complex(Math.exp(z.real)).rotate(z.imag);
    }

    /**
     * sin(z) = (exp(i * z) - exp(-i * z)) / (2 * i)
     */
    public static Complex sin(Complex z)
    {
        return exp(z.mul(I)).sub(exp(z.mul(-1).mul(I))).div(new Complex(0, 2));
    }

    /**
     * cos(z) = (exp(i * z) + exp(-i * z)) / 2
     */
    public static Complex cos(Complex z)
    {
        return exp(z.mul(I)).add(exp(z.mul(-1).mul(I))).div(2);
    }

    /**
     * sh(z) = (exp(z) - exp(-z)) / 2
     */
    public static Complex sh(Complex z)
    {
        return exp(z).sub(exp(z.mul(-1))).div(2);
    }

    /**
     * ch(z) = (exp(z) + exp(-z)) / 2
     */
    public static Complex ch(Complex z)
    {
        return exp(z).add(exp(z.mul(-1))).div(2);
    }

    /**
     * ln(z) = ln(|z|) + i * arg(z)
     */
    public static Complex ln(Complex z)
    {
        return new Complex(Math.log(abs(z)), arg(z));
    }

    /**
     * z ^ w = exp(w * ln(z))
     */
    public static Complex pow(Complex z, Complex w)
    {
        return exp(w.mul(ln(z)));
    }

    /**
     * z ^ r = exp(r * ln(z))
     */
    public static Complex pow(Complex z, double r)
    {
        return pow(z, new Complex(r));
    }

    /**
     * @return z ^ (1/2)
     */
    public static Complex sqrt(Complex z)
    {
        return pow(z, 0.5);
    }

    /**
     * @return мнимая часть this
     */
    public double getImag()
    {
        return imag;
    }

    /**
     * @return действительная часть this
     */
    public double getReal()
    {
        return real;
    }

    private final double real;

    private final double imag;

    /**
     * 0 + 1 * i
     */
    public static final Complex I = new Complex(0, 1);

    /**
     * 1 + 0 * i
     */
    public static final Complex ONE = new Complex(1, 0);

    /**
     * 0 + 0 * i
     */
    public static final Complex ZERO = new Complex(0, 0);

    /**
     * Генерация случайных комплексных чисел на отрезке и окружности
     */
    public static class Random
    {
        /**
         * @return случайное комплексное число из отрезка [0, 1]
         */
        public static Complex random()
        {
            return new Complex(random.nextDouble());
        }

        /**
         * @return случайное комплексное число на единичной окружности
         */
        public static Complex randomPointOnCircle()
        {
            return exp(I.mul(2 * PI * random.nextDouble()));
        }

        /**
         * @return exp(2 * PI * I / n * k), k случайное число из 0..n - 1
         */
        public static Complex randomPointOnCircle(int n)
        {
            return exp(I.mul(2 * PI * random.nextInt(n) / n));
        }

        private static java.util.Random random = new java.util.Random();
    }
}
