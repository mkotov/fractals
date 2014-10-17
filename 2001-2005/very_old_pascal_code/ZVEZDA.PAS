{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Zvezda;
Uses Crt, Graph;
Const
  it = 1280;
  r = 0.35;
  l = 300;
  da = 4*pi/5;
  v = 4;

Var
   gd,gm : Integer;
   a     : Real;
   x, y  : Real;
   xn,yn : Real;
   i     : Integer;

Function Mn(nn: Integer): Real;
Begin
  If nn mod (v*v*v*v) = 0 then Mn:=1     Else
  If nn mod (v*v*v)   = 0 then Mn:=r     Else
  If nn mod (v*v)     = 0 then Mn:=r*r   Else
  If nn mod (v)       = 0 then Mn:=r*r*r Else
                               Mn:=r*r*r*r;
End;
begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   a:=0;
   x:=200;
   y:=320;
   For i:=0 to it Do Begin
     xn:=x+sin(a)*l*Mn(i);
     yn:=y-cos(a)*l*Mn(i);
     Line(Round(x), Round(y), Round(xn), Round(yn));
     x:=xn;
     y:=yn;
     a:=a+da;
   End;
   ReadKey;
   closegraph;
end.
