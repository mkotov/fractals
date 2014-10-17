{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
program Sierp;
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
   rad := my;
   Randomize;
   x := 0.0;
   y := 0.0;
   For k := 1 To iter Do Begin
      p := Random;
      t := x;
      If p <= 1/3 Then Begin
         x :=  0.50 * x + 0.00 * y + 0.0;
         y :=  0.00 * t + 0.50 * y + 0.5;
      End
      Else
         If p <= 2/3 Then Begin
            x :=  0.50 * x + 0.00 * y - 0.25;
            y :=  0.00 * t + 0.50 * y + 0.0;
         End
            Else Begin
            x :=  0.50 * x + 0.00 * y + 0.25;
            y :=  0.00 * t + 0.50 * y + 0.0;
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