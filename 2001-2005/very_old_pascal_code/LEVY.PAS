{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
program levy;
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
   mx := 200;
   my := 300;
   rad := 250;
   Randomize;
   x := 0.0;
   y := 0.0;
   For k := 1 To iter Do Begin
      p := Random;
      t := x;
     If p <= 1/2 Then Begin
         x :=  0.5*x-0.5*y;
         y :=  0.5*t+0.5*y;
      End
      Else
         Begin
         x :=  0.5*x+0.5*y+0.5;
         y :=  -0.5*t+0.5*y+0.5;

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