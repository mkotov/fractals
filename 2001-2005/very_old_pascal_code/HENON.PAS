{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Henon;
Uses Graph, Crt;
Var
   x, t, y: Real;
   gd, gm : Integer;
   a, b   : Real;
   i      : Integer;
Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   x:=0;
   y:=0;
   For i:=1 To 10000 Do Begin
     a:=1.4;
     b:=0.3;
     t:=x;
     x:=1 + y - a*x*x;
     y:=b*t;
     PutPixel(Round(x*150)+320, Round(y*150)+240, 14)
   End;
   Readkey;
   CloseGraph;
end.

