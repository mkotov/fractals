{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Lato;
Uses Graph, Crt;
Var
   x, t, y  : Real;
   xp, yp   : Integer;
   gd, gm   : Integer;
   a,b,c,d  : Real;
   m        : Real;

Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   x:=1;
   y:=1;
   While Not KeyPressed Do Begin
     t:=x;
     a:=-0.97;
     b:=2.87;
     c:=0.76;
     d:=0.74;
     m:=100;
     x:=sin(y*b)+c*sin(x*b);
     y:=sin(t*a)+d*sin(y*a);
     xp:=round(x*m)+320;
     yp:=round(y*m)+240;
     PutPixel(xp, yp, GetPixel(xp, yp)+1)
   End;
   Readkey;
   CloseGraph;
end.

