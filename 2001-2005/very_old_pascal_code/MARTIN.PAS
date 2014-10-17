{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Martin;
Uses Graph, Crt;
Var
   x, t, y  : Real;
   n        : Integer;
   gd, gm   : Integer;
   a,b,c    : Real;
   m        : Real;
Function Sign(x:Real):Real;
Begin
   if x<>0 Then sign:=abs(x)/x Else sign:=0;
End;

Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   x:=0;
   y:=0;
   n:=0;
   While Not KeyPressed Do Begin
     t:=x;
     {Martin}
     a:=3.14;
     m:=2;
     x:=y-sin(x);
     y:=a-t; {}
     {Hopalong}
     {a:=0.1;
     b:=1;
     c:=0;
     m=100;}
     {a:=-1000;
     b:=0.1;
     c:=-10;
     m:=10;}
     {x:=y-sign(x)*sqrt(abs(b*x-c));
     y:=a-t; {}
     {Chip}
     {a:=-15;
     b:=-19;
     c:=1;
     m:=1;
     x:=y-sign(x)*cos(sqr(ln(abs(b*x-c))));
     y:=a-t;{}
     {Quadruptwo}
     {a:=34;
     b:=1;
     c:=5;
     m:=2;
     x:=y-sign(x)*sin(ln(abs(b*x-c)))*arctan(sqr(ln(abs(c*x-b))));
     y:=a-t;{}
     {Threeply}
     {a:=-55;
     b:=-1;
     c:=-42;
     m:=0.1;
     x:=y-sign(x)*(abs(sin(x)*cos(b)+c-x*sin(a+b+c)));
     y:=a-t;{}
     inc(n);
     PutPixel(round(x*m)+320,round(y*m)+240,n mod 16)
   End;
   Readkey;
   CloseGraph;
end.

