{******************************}
{*   name: IFS Curve          *}
{*  autor: Kotov D., Kotov M. *}
{*   date: 14.11.2004         *}
{* e-mail: ikot@mail.ru       *}
{*comment: no comment         *}
{*        (c)iK - 2004        *}
{******************************}
Program Curve;
Uses Graph, Crt;
Var
   gd, gm: Integer;
   i, p, m, n, c, ix, iy: Integer;
   a, b, x, y, x1, y1, r: Real;

Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   Randomize;
   x:=0.3;
   y:=0.1;
   a:=0;
   b:=0;
   While Not KeyPressed Do Begin
    a:=Random;
    IF Random>0.5 then p:=1 else p:=-1;
    r:=sqrt(x*x+y*y);
    If (a<=1/2) Then Begin
       x1:=x/r-1;
       y1:=p*y/r;
    End Else
    IF (a<=3/4) Then Begin
       x1:=x/3;
       y1:=y/3;
    End Else Begin
       x1:=x/3+2/3;
       y1:=y/3;
    End;
    x:=x1;
    y:=y1;
    PutPixel(Round(180*x+400), Round(180*y+240), 9);
  End;
   Readkey;
   CloseGraph;
end.
