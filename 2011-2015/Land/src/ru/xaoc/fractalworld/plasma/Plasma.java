package ru.xaoc.fractalworld.plasma;

public class Plasma {

    private float[][] x;
    private int size;

    private void calc(int a, int b, int c, int d) {
        if (a + 1 == c || b + 1 == d) {
            return;
        }
        float r = ((c - a) + (d - b)) / 4;
        int e = (a + c) / 2;
        int f = (b + d) / 2;
        x[e][f] =
                (x[a][b] + x[a][d] + x[c][b] + x[c][d]) / 4
                + r * (float)(Math.random() - .5);
        x[e][b] = (x[a][b] + x[c][b]) / 2;
        x[e][d] = (x[a][d] + x[c][d]) / 2;
        x[a][f] = (x[a][b] + x[a][d]) / 2;
        x[c][f] = (x[c][b] + x[c][d]) / 2;
        calc(a, b, e, f);
        calc(a, f, e, d);
        calc(e, b, c, f);
        calc(e, f, c, d);
    }

    public Plasma(int countLevels, float a, float b, float c, float d) {
        size = (int) Math.round(Math.pow(2, countLevels));
        x = new float[size + 1][size + 1];
        x[0][0] = a;
        x[0][size] = b;
        x[size][0] = c;
        x[size][size] = d;
        calc(0, 0, size, size);
        float min = Float.MAX_VALUE;
        float max = Float.MIN_VALUE;
        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (x[i][j] < min) {
                    min = x[i][j];
                }
                if (x[i][j] > max) {
                    max = x[i][j];
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public float getValue(int i, int j) {
        return x[i][j];
    }
}
