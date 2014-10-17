{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
program Koch;
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
   mx := 20;
   my := 300;
   rad := 600;
   Randomize;
   x := 0.0;
   y := 0.0;
   For k := 1 To iter Do Begin
      p := Random;
      t := x;
     If p <= 1/2 Then Begin
          x :=  1/2 * x + 1/(2*sqrt(3)) * y;
         y :=  1/(2*sqrt(3)) * t - 1/2 * y;
      End
      Else
         Begin
            x :=  1/2 * x - 1/(2*sqrt(3)) * y +1/2;
            y :=  -1/(2*sqrt(3)) * t - 1/2 * y + 1/(2*sqrt(3));
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