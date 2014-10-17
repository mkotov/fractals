package ru.xaoc.fractalworld.lsystems;

import java.awt.Image;

public class Collection {

    public static Image drawKochCurve(int depth) {
        return Painter.draw(new LSystem("F", new String[][]{{"F", "F-F++F-F"}}),
                Math.PI / 3, depth);
    }

    public static Image drawKochSnowflake(int depth) {
        // Кроновер, стр. 36
        return Painter.draw(new LSystem("F++F++F", new String[][]{{"F", "F-F++F-F"}}),
                Math.PI / 3, depth);
    }

    public static Image drawTriangle(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/triangle/
        return Painter.draw(new LSystem("F+F+F", new String[][]{{"F", "F-F+F"}}),
                2 * Math.PI / 3, depth);
    }

    public static Image drawCrystal(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/crystal/
        return Painter.draw(new LSystem("F+F+F+F", new String[][]{
                    {"F", "FF+F++F+F"}}),
                Math.PI / 2, depth);
    }

    public static Image drawDragon(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/dragon/
        return Painter.draw(new LSystem("FX", new String[][]{
                    {"X", "X+YF+"},
                    {"Y", "-FX-Y"}}),
                Math.PI / 2, depth);
    }

    public static Image drawHexagonalGosper(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/hexagonal_gosper/
        return Painter.draw(new LSystem("XF", new String[][]{
                    {"X", "X+YF++YF-FX--FXFX-YF+"},
                    {"Y", "-FX+YFYF++YF+FX--FX-Y"}}),
                Math.PI / 3, depth);
    }

    public static Image drawSquareSierpinski(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/square_sierpinski/
        return Painter.draw(new LSystem("F+XF+F+XF", new String[][]{
                    {"X", "XF-F+F-XF+F+XF-F+F-X"}}),
                Math.PI / 2, depth);
    }

    public static Image drawHilbertCurve(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/hilbert/
        return Painter.draw(new LSystem("X", new String[][]{
                    {"X", "-YF+XFX+FY-"},
                    {"Y", "+XF-YFY-FX+"}}),
                Math.PI / 2, depth);
    }

    public static Image drawBoard(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/board/
        return Painter.draw(new LSystem("F+F+F+F", new String[][]{
                    {"F", "FF+F+F+F+FF"}}),
                Math.PI / 2, depth);
    }

    public static Image drawYetAnotherKochCurve(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/kochcurve/
        return Painter.draw(new LSystem("F+F+F+F", new String[][]{
                    {"F", "F+F-F-FF+F+F-F"}}),
                Math.PI / 2, depth);
    }

    public static Image drawQuadraticKochIslandA(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/quadratic_koch_island_a/
        return Painter.draw(new LSystem("F+F+F+F", new String[][]{
                    {"F", "F+F-F-FFF+F+F-F"}}),
                Math.PI / 2, depth);
    }

    public static Image drawQuadraticKochIslandB(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/quadratic_koch_island_b/
        return Painter.draw(new LSystem("F+F+F+F", new String[][]{
                    {"F", "F-FF+FF+F+F-F-FF+F+F-F-FF-FF+F"}}),
                Math.PI / 2, depth);
    }

    public static Image drawQuadraticSnowflake(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/quadratic_snowflake/
        return Painter.draw(new LSystem("F", new String[][]{
                    {"F", "F-F+F+F-F"}}),
                Math.PI / 2, depth);
    }

    public static Image drawSierpinskiArrowhead(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/sierpinski_arrowhead/
        return Painter.draw(new LSystem("YF", new String[][]{
                    {"X", "YF+XF+Y"},
                    {"Y", "XF-YF-X"}}),
                Math.PI / 3, depth);
    }

    public static Image drawCrossB(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/cross_b/
        return Painter.draw(new LSystem("F+F+F+F", new String[][]{
                    {"F", "F+F-F+F+F"}}),
                Math.PI / 2, depth);
    }

    public static Image drawRings(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/rings/
        return Painter.draw(new LSystem("F+F+F+F", new String[][]{
                    {"F", "FF+F+F+F+F+F-F"}}),
                Math.PI / 2, depth);
    }

    public static Image drawBush1(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/lsys_bush_a/
        return Painter.draw(new LSystem("Y", new String[][]{
                    {"X", "X[-FFF][+FFF]FX"},
                    {"Y", "YFX[+Y][-Y]"}}),
                Math.PI / 7, depth, Math.PI / 2);
    }

    public static Image drawBush2(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/lsys_bush_b/
        return Painter.draw(new LSystem("F", new String[][]{
                    {"F", "FF+[+F-F-F]-[-F+F+F]"}}),
                Math.PI / 8, depth, Math.PI / 2);
    }

    public static Image drawBush3(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/lsys_bush_c/
        return Painter.draw(new LSystem("F", new String[][]{
                    {"F", "F[+FF][-FF]F[-F][+F]F"}}),
                Math.PI / 5, depth, Math.PI / 2);
    }

    public static Image drawSticks(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/lsys_sticks/
        return Painter.draw(new LSystem("X", new String[][]{
                    {"F", "FF"},
                    {"X", "F[+X]F[-X]+X"}}),
                Math.PI / 9, depth, Math.PI / 2);
    }

    public static Image drawBoxFractal(int depth) {
        // http://mathworld.wolfram.com/BoxFractal.html
        return Painter.draw(new LSystem("F-F-F-F", new String[][]{
                    {"F", "F-F+F+F-F"}}),
                Math.PI / 2, depth);
    }

    public static Image drawWeed(int depth) {
        // http://dmitriyku.narod.ru/html/gallery_lfr.htm
        return Painter.draw(new LSystem("F", new String[][]{
                    {"F", "F[+F]F[-F]F"}}),
                Math.PI / 7, depth, Math.PI / 2);
    }

    public static Image drawRings2(int depth) {
        // http://dmitriyku.narod.ru/html/gallery_lfr.htm
        return Painter.draw(new LSystem("F", new String[][]{
                    {"F", "FXF"},
                    {"X", "[-F+F+F]+F-F-F+"},}),
                Math.PI / 3, depth);
    }

    public static Image drawSierpinskiTriangle(int depth) {
        return Painter.draw(new LSystem("FXF--FF--FF", new String[][]{
                    {"F", "FF"},
                    {"X", "--FXF++FXF++FXF--"},}),
                Math.PI / 3, depth);
    }

    public static Image drawSierpinskiCarpet(int depth) {
        return Painter.draw(new LSystem("F", new String[][]{
                    {"F", "FFF[+FFF+FFF+FFF]"},}),
                Math.PI / 2, depth);
    }

    public static Image drawMosaic(int depth) {
        // Кроновер, стр. 36
        return Painter.draw(new LSystem("F-F-F-F", new String[][]{
                    {"F", "F-b+FF-F-FF-Fb-FF+b-FF+F+FF+Fb+FFF"},
                    {"b", "bbbbbb"}}),
                Math.PI / 2, depth);
    }

    public static Image drawSnowflake(int depth) {
        // Кроновер, стр. 36
        return Painter.draw(new LSystem("[F]+[F]+[F]+[F]+[F]+[F]", new String[][]{
                    {"F", "F[++F][--F][-FF][+FF]FF[+F][-F]FF"},}),
                Math.PI / 3, depth);
    }

    public static Image drawFlower(int depth) {
        // Кроновер, стр. 37
        return Painter.draw(new LSystem("F[+F+F][-F-F][++F][--F]F", new String[][]{
                    {"F", "FF[++F][+F][F][-F][--F]"},}),
                Math.PI / 16, depth, Math.PI / 2);
    }

    public static Image drawLevyCurve(int depth) {
        // http://en.wikipedia.org/wiki/L%C3%A9vy_C_curve
        return Painter.draw(new LSystem("F++F++F++F", new String[][]{
                    {"F", "-F++F-"}}),
                Math.PI / 4, depth);
    }

    public static Image drawPentaplexity(int depth) {
        // http://local.wasp.uwa.edu.au/~pbourke/fractals/pentaplexity/
        return Painter.draw(new LSystem("F++F++F++F++F", new String[][]{
                    {"F", "F++F++F+++++F-F++F"}}),
                Math.PI / 5, depth);
    }

    public static Image drawTerdragon(int depth) {
        // http://www.nahee.com/spanky/www/fractint/lsys/spacefilling.html
        return Painter.draw(new LSystem("F", new String[][]{
                    {"F", "F+F-F"}}),
                2 * Math.PI / 3, depth);
    }

    public static Image drawCross(int depth) {
        // http://www.nahee.com/spanky/www/fractint/lsys/spacefilling.html
        return Painter.draw(new LSystem("FX", new String[][]{
                    {"X", "FX+FX+FXFY-FY-"},
                    {"Y", "+FX+FXFY-FY-FY"},
                    {"F", ""}}),
                Math.PI / 2, depth);
    }

    public static Image drawSierpinskiCarpet2(int depth) {
        // http://www.nahee.com/spanky/www/fractint/lsys/truefractal.html
        return Painter.draw(new LSystem("F", new String[][]{
                    {"F", "F+F-F-F-b+F+F+F-F"},
                    {"b", "bbb"}}),
                Math.PI / 2, depth);
    }

    public static Image drawPentigree(int depth) {
        // http://www.nahee.com/spanky/www/fractint/lsys/truefractal.html
        return Painter.draw(new LSystem("F-F-F-F-F", new String[][]{
                    {"F", "F-F++F+F-F-F"},}),
                2 * Math.PI / 5, depth);
    }

    public static Image drawHex7B(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/teachout.l
        return Painter.draw(new LSystem("X", new String[][]{
                    {"F", ""},
                    {"X", "-F++F-X-F--F+Y---F--F+Y+F++F-X+++F++F-X-F++F-X+++F--F+Y--"},
                    {"Y", "+F++F-X-F--F+Y+F--F+Y---F--F+Y---F++F-X+++F++F-X+++F--F+Y"}}),
                Math.PI / 6, depth);
    }

    public static Image drawPeanoC(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/teachout.l
        return Painter.draw(new LSystem("FX", new String[][]{
                    {"F", ""},
                    {"X", "FX-FY-FX+FY+FX+FY+FX+FY+FX-FY-FX-FY-FX-FY-FX+FY+FX"},
                    {"Y", "FY"}}),
                Math.PI / 4, depth);
    }

    public static Image drawBorder(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/mcworter.l
        return Painter.draw(new LSystem("XYXYXYX+XYXYXYX+XYXYXYX+XYXYXYX", new String[][]{
                    {"F", ""},
                    {"X", "FX+FX+FXFY-FY-"},
                    {"Y", "+FX+FXFY-FY-FY"}}),
                Math.PI / 2, depth);
    }

    public static Image drawDoily(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/mcworter.l
        return Painter.draw(new LSystem("F--F--F--F--F--F", new String[][]{
                    {"F", "-F[--F--F]++F--F+"},}),
                Math.PI / 6, depth);
    }

    public static Image drawMaze1(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/mcworter.l
        return Painter.draw(new LSystem("F+F+F", new String[][]{
                    {"F", "F+FF-F"},}),
                2 * Math.PI / 3, depth);
    }

    public static Image drawMaze2(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/mcworter.l
        return Painter.draw(new LSystem("X", new String[][]{
                    {"X", "FY+FYFY-FY"},
                    {"Y", "FX-FXFX+FX"},
                    {"F", ""}}),
                2 * Math.PI / 3, depth);
    }

    public static Image drawMoore(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/mcworter.l
        return Painter.draw(new LSystem("X", new String[][]{
                    {"X", "FX+FX+FXFYFX+FXFY-FY-FY-"},
                    {"Y", "+FX+FX+FXFY-FYFXFY-FY-FY"},
                    {"F", ""}}),
                Math.PI / 2, depth);
    }

    public static Image drawPentant(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/mcworter.l
        return Painter.draw(new LSystem("X-X-X-X-X", new String[][]{
                    {"X", "FX-FX-FX+FY+FY+FX-FX"},
                    {"Y", "FY+FY-FX-FX-FY+FY+FY"},
                    {"F", ""}}),
                2 * Math.PI / 5, depth);
    }

    public static Image drawPentl(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/mcworter.l
        return Painter.draw(new LSystem("F-F-F-F-F", new String[][]{
                    {"F", "F-F-F++F+F-F"}}),
                2 * Math.PI / 5, depth);
    }

    public static Image drawSierpinskiCurve(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/mcworter.l
        return Painter.draw(new LSystem("L--F--L--F", new String[][]{
                    {"L", "+R-F-R+"},
                    {"R", "-L+F+L-"}}),
                Math.PI / 4, depth);
    }

    public static Image drawTiling(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/mcworter.l
        return Painter.draw(new LSystem("X", new String[][]{
                    {"X", "F-F-F+F+FX++F-F-F+F+FX--F-F-F+F+FX"},
                    {"F", ""}}),
                Math.PI / 3, depth);
    }

    public static Image drawADH231A(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/horizons.l
        return Painter.draw(new LSystem("F++++F", new String[][]{
                    {"F", "F+F+F++++F+F+F"}}),
                Math.PI / 4, depth);
    }

    public static Image drawADH256A(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/horizons.l
        return Painter.draw(new LSystem("F+F+F+F++F-F-F-F", new String[][]{
                    {"F", "F+F++F+FF"}}),
                Math.PI / 2, depth);
    }

    public static Image drawADH258A(int depth) {
        // http://www.nahee.com/spanky/pub/fractals/lsystems/horizons.l
        return Painter.draw(new LSystem("F++F++F+++F--F--F", new String[][]{
                    {"F", "FF++F++F++FFF"}}),
                Math.PI / 3, depth);
    }
}
