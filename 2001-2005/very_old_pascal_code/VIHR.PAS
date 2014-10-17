{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Vihr;
Uses Graph, CRT;
Const
   max = 7;
   iter = 50000;
Var
  gd, gm : Integer;
Procedure draw;
Var
   x, y, p, c0, s0 : Real;
   k : Longint;
   q : Word;
   c, s : Array[0..max - 1] Of real;
   mx, my, rad : Integer;
   dx, dy : Array[0..5] Of Real;

   Procedure A (k : Word; Var x, y : Real);
   Const
      r = 0.75;
   Var
      t : Real;
   Begin
      t := x;
      x := r * (c0 * x + s0 * y);
      y := r * (-s0 * t + c0 * y);
   End;

   Procedure B (k : Word; Var x, y : Real);
   Const
      r = 0.15;
   Begin
      x := r * x + c[k];
      y := r * y + s[k];
   End;
Begin
   mx := GetMaxX Div 2;
   my := GetMaxY Div 2;
   rad := trunc(0.8 * my);
   c0 := Cos(-0.05 * Pi);
   s0 := Sin(-0.05 * Pi);
   For k := 0 To max - 1 Do Begin
      c[k] := Cos(2.0 * k * Pi / max);
      s[k] := Sin(2.0 * k * Pi / max);
   End;
   Randomize;
   x := 0.0;
   y := 0.0;
   For k := 1 To iter Do Begin
      p := Random;
      q := Random(max);
      If p < 0.25 Then B(q, x, y)
      Else A(q, x, y);
      PutPixel(mx + Round(rad * x), my + Round(rad * y), 15);
   End;
End;

Begin
   gd:=Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   draw;
   ReadKey;
   CloseGraph;
End.