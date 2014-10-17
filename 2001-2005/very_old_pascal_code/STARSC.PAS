{***************************************}
{*    name: STARSC                     *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{*    date: 26.11.2004                 *}
{*            (c)iK - 2004             *}
{***************************************}
Program STARSC;
Uses CRT, Graph;
Var
    GD, GM: Integer;
    nx, ny: Integer;
    key: Char;
    a, b, c, d, x, y: Real;
    x1, y1, sx, sy, sx4, sy4: Real;
Begin
    Randomize;
    GD:=Detect;
    InitGraph(GD, GM, 'c:\bp\bgi');
    While key<>#27 Do Begin
      a := 2*(0.5-Random);
      b := 2*(0.5-Random);
      c := 2*(0.5-Random);
      d := 2*(0.5-Random);
      x := Random;
      y := Random;
      While not KeyPressed Do Begin
	sx  := pi*2*x;
        sy  := pi*2*y;
	sx4 := pi*4*x;
        sy4 := pi*4*y;
	x1 := a*sin(sx) + b*sin(sx)*cos(sy) + c*sin(sx4) +
	     d*sin(pi*6*x)*cos(sy4);
	y1 := a*sin(sy) + b*sin(sy)*cos(sx) + c*sin(sy4) +
	     d*sin(pi*6*y)*cos(sx4);
	nx := Round(100*x1 + 320);
	ny := Round(100*y1 + 240);
	PutPixel(nx, ny, getpixel(nx,ny)+1);
	x := x1;
        y := y1;
      End;
      Key:=Readkey;
      ClearDevice;
    End;
    CloseGraph;
End.

