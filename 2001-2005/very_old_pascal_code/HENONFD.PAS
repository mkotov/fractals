{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
{$N+}
Program HenonFD;
Uses Graph, Crt;
Var
   x, t, y,x0: Real;
   gd, gm : Integer;
   a, b   : Real;
   i      : Integer;
Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   x:=0;
   y:=0;
   x0:=0;
   Repeat
     y:=0;
     x:=x0;
     For i:=1 To 10000 Do Begin
       a:=2;{1.57;}
       t:=x;
       x:=x*cos(a)-(y-x*x)*sin(a);
       y:=t*sin(a)+(y-t*t)*cos(a);
       PutPixel(Round(x*150)+320, Round(y*150)+240, 14);
       if (x>10)or(y>10) Then Break;
     End;
     x0:=x0+0.01;
   Until x0>1;
   Readkey;
   CloseGraph;
end.

