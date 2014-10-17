{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
program IFS100;
Uses CRT, Graph;
Var
   gd,gm : Integer;

Const
  iter = 100000;
  {1}
   {a = 0.00;
   b = 0.70;
   c = 0.70;
   d = 0.00;{}
  {2}
  {a = 0.60;
   b = 0.60;
   c = 0.53;
   d = 0.00;{}

Procedure draw;
Var
   t, x, y, p : Real;
   k : LongInt;
   mx, my, rad : Integer;
Begin
   mx := 220;
   my := 300;
   rad := 400;
   Randomize;
   x := 0.0;
   y := 0.0;
   For k := 1 To iter Do Begin
      p := Random;
      t := x;
     If p <= 1/2 Then Begin
         x :=  a * x - b * y;
         y :=  b * t + a * y;
      End
      Else
         Begin
            x :=  c * x - d * y + 1 - c;
            y :=  d * t + c * y - d;
         End;
      PutPixel(mx + Round(rad * x), my - Round(rad * y), 2);
   End;
End;

Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   Draw;
   ReadKey;
   CloseGraph;
End.