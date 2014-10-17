{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
program Rnd;
Uses CRT, Graph;
Var
   gd,gm : Integer;
Procedure draw;
const iter = 70000;
a = 2.8;
Var
   t, x, y, p : Real;
   k : LongInt;
   mx, my, rad : Integer;
Begin
   mx := 320;
   my := 240;
   rad := 200;
   Randomize;
   x := 0.0;
   y := 0.0;
   For k := 1 To iter Do Begin
      p := Random;
      t := x;
     If p <= 1/2 Then Begin
         x := -y;
         y := t;
      End
      Else
         Begin
            x := 1+(a*(x-1))/(sqr(x-1)+sqr(y)+1);
            y := a*y/(sqr(t-1)+sqr(y)+1);
         End;
      PutPixel(mx + Round(rad * x), my - Round(rad * y), 2);
   End;
End;

Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   draw;
   ReadKey;
   CloseGraph;
End.