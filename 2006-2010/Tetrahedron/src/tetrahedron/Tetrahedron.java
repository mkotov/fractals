package tetrahedron;

import base.*;
import java.awt.*;
import static java.lang.Math.sqrt;

public class Tetrahedron extends Solid
{
	public static Colorer redColorer = new MonoColorer(Color.RED);
    public static Colorer blueColorer = new MonoColorer(Color.BLUE);
    public static Colorer yellowColorer = new MonoColorer(Color.YELLOW);
    public static Colorer greenColorer = new MonoColorer(Color.GREEN);
	
	public static Tetrahedron createTetrahedron(int n)
	{
            Tetrahedron cube = new Tetrahedron();
            cube.addTetrahedron(n, new Vector[] {
                new Vector(-2 / (3 * sqrt(2)), 2 / sqrt(6), - 1.0 / 3).mul(200),
                new Vector(4 / (3 * sqrt(2)), 0, -1.0 / 3).mul(200),
                new Vector(-2 / (3 * sqrt(2)), -2 / sqrt(6), - 1.0 / 3).mul(200),
                new Vector(0,0,1).mul(200)});
            return cube;
	}	
	
	private void addTetrahedron(int n, Vector[] v)
	{
		if (--n > 0)
		{
			addTetrahedron(n, new Vector[] {v[0], v[0].plus(v[1]).mul(0.5), v[0].plus(v[2]).mul(0.5), v[0].plus(v[3]).mul(0.5)});
            addTetrahedron(n, new Vector[] {v[0].plus(v[1]).mul(0.5), v[1], v[1].plus(v[2]).mul(0.5), v[1].plus(v[3]).mul(0.5)});
            addTetrahedron(n, new Vector[] {v[0].plus(v[2]).mul(0.5), v[1].plus(v[2]).mul(0.5), v[2], v[2].plus(v[3]).mul(0.5)});
            addTetrahedron(n, new Vector[] {v[0].plus(v[3]).mul(0.5), v[1].plus(v[3]).mul(0.5), v[2].plus(v[3]).mul(0.5), v[3]});
		}
		else
		{
            add(new Triangle(new Vector[] {v[1], v[0], v[3]}, redColorer));
            add(new Triangle(new Vector[] {v[2], v[1], v[3]}, blueColorer));
            add(new Triangle(new Vector[] {v[2], v[0], v[3]}, yellowColorer));
            add(new Triangle(new Vector[] {v[0], v[2], v[1]}, greenColorer));
		}
	}	
}
