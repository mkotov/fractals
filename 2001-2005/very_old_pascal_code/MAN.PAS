{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Man;
Uses Graph, Crt;
Var
   x, t, y  : Real;
   n        : Integer;
   gd, gm   : Integer;
Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   x:=-0.1;
   y:=0;
   n:=0;
   While Not KeyPressed Do Begin
     t:=x;
     x:=1-y+abs(x);
     y:=t; {}
     inc(n);
     PutPixel(round(x*20)+320,round(y*20)+240,n mod 16)
   End;
   Readkey;
   CloseGraph;
end.

