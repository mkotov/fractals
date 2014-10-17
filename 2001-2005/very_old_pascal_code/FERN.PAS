{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
program Fern;
Uses CRT, Graph;
Var
   gd,gm : Integer;
Procedure draw;
const iter = 50000;
Var
   t, x, y, p : Real;
   k : LongInt;
   mx, my, rad : Integer;
Begin
   mx := 320;
   my := 479;
   rad := Trunc(0.1 * my);
   Randomize;
   x := 1.0;
   y := 0.0;
   For k := 1 To iter Do Begin
      p := Random;
      t := x;
      If p <= 0.85 Then Begin
         x :=  0.85 * x + 0.04 * y;
         y := -0.04 * t + 0.85 * y + 1.6;
      End
      Else
         If p <= 0.92 Then Begin
            x :=  0.20 * x - 0.26 * y;
            y :=  0.23 * t + 0.22 * y + 1.6;
         End
         Else
            If p <= 0.99 Then Begin
               x := -0.15 * x + 0.28 * y;
               y :=  0.26 * t + 0.24 * y + 0.44;
            End
            Else Begin
               x := 0.0;
               y := 0.16 * y;
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