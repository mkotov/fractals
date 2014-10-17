package zbuffer;

import java.awt.*;

public class ZBuffer
{
	private int[][] zBuffer;
	
	public void init(int width, int height)
	{
		zBuffer = new int[width][];
		for (int i = 0; i < width; ++i)
		{
			zBuffer[i] = new int[height];
			for (int j = 0; j < height; ++j)
				zBuffer[i][j] = Integer.MIN_VALUE;
		}		
	}
	
	public boolean test(int x, int y, int z)
	{
		if (x < 0 || x >= zBuffer.length || y < 0 || y >= zBuffer[0].length)
			return false;
		if (z > zBuffer[x][y])
		{
			zBuffer[x][y] = z;
			return true;
		}
		return false;
	}
}
