{***************************************}
{*    name: Trianguloid                *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{* comment: No comment                 *}
{*    date: 27.11.2004                 *}
{*            (c)iK - 2004             *}
{***************************************}
Program Trianguloid;
Uses CRT, Graph;
Var
  gd, gm: Integer;
  x, y, y1, x1, a: Real;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=0.5;
  y:=0.75;
  Randomize;
  While not Keypressed Do Begin
    a:=Random;
    If a<=1/3 Then Begin
       x1:=2*x*y/(sqr(x)+sqr(y));
       y1:=(sqr(y)-sqr(x))/(sqr(y)+sqr(x));
    End Else
    If a<=2/3 Then Begin
       x1:=2/(x+2)-1;
       y1:=2/(y+2)-1;
    End Else Begin
       x1:=(sqr(x)-sqr(y))/(sqr(x)+sqr(y));
       y1:=2*x*y/(sqr(y)+sqr(x));
    End;
    x:=x1;
    y:=y1;
    PutPixel(Round(x*200+320), Round(y*200+240), 7);
  End;
  Readkey;
  CloseGraph;
End.


