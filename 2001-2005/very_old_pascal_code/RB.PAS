{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program RB;
Uses CRT, Graph;
Var
  gd, gm: Integer;
  x, y, a, b: Real;
  r: Real;
  x1, y1: Real;

Begin
  gd:=detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=0;
  y:=0;
  a:=0;
  b:=0;
  r:=sqrt(2);
  Randomize;
  While Not KeyPressed Do Begin
    a:=Random;
    If a <= 1/2 Then Begin
      x1:=y/r+3/2;
      y1:=-x/r+3/2;
    End Else Begin
      x1:=-y/r+1/2;
      y1:=x/r+1/2;
    End;
    If random>0.5 Then Begin
      x:=x1-2;
      y:=y1;
    End Else Begin
      x:=(x1-2)/(sqr(x1-2)+sqr(y1));
      y:=y1/(sqr(x1-2)+sqr(y1));
    End;
    PutPixel(350 + Round(x*50), 200 + Round(y*50), 15);
  End;
  ReadLn;
  CloseGraph;
End.


