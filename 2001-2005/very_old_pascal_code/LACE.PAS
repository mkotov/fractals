{***************************************}
{*    name: Lace                       *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{* comment: No comment                 *}
{*    date: 02.08.2005                 *}
{*            (c)iK - 2005             *}
{***************************************}

Program Lace;
Uses CRT, Graph;
Var
  gd, gm: Integer;
  x, y, a, x1, y1: Real;
  n: Integer;
  r0, w: Real;
Function Arctg(x,y:Real):Real;
Var
  w:Real;
Begin
  w:=arctan(abs(y/x));
  If (y>0)and(x<0) then w:=pi-w Else
  If (y<0)and(x<0) then w:=w+pi Else
  If (y<0)and(x>0) then w:=-w;
  Arctg:=w;
End;

Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=0.1;
  y:=0.1;
  While not KeyPressed do Begin
    a:=Random;
    r0:=sqrt(x*x+y*y);
    w:=Arctg(x-1, y);
    If a <= 1/4 then Begin
      w:=Arctg(x-1, y);
       Y1:=-r0*cos(w)/2+1;
       X1:=-r0*sin(w)/2;
    End Else
    If (a<=2/4) then Begin
       w:=Arctg(x+1/2, y-sqrt(3)/2);
       Y1:=-r0*cos(w)/2-1/2;
       X1:=-r0*sin(w)/2+sqrt(3)/2;
    End Else
    If (a<=3/4) then Begin
       w:= Arctg(x+1/2, y+sqrt(3)/2);
       Y1:=-r0*cos(w)/2-1/2;
       X1:=-r0*sin(w)/2-sqrt(3)/2;
    End Else
    Begin
       w:=Arctg(x, y);
       Y1:=-r0*cos(w)/2;
       X1:=-r0*sin(w)/2;
    End;
    x:=x1;
    y:=y1;
    PutPixel(Round(320+130*x), Round(200+130*y), 14);
  End;
  ReadKey;
  CloseGraph;
End.

