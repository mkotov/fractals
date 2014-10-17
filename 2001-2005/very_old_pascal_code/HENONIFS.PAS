{***************************************}
{*    name: Henon_IFS                  *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{*    date: 22.11.2004                 *}
{*            (c)iK - 2004             *}
{***************************************}
Program HenonIFS;
Uses CRT, Graph;
Const
  m=3; {2..12}
Var
  gd, gm: Integer;
  i, n, l: Integer;
  x1, y1, x, y: Real;
  a, b: array[0..m] of Real;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=0; y:=0;
  For i:=0 To m Do Begin
    a[i]:=cos(2*pi * i/m);
    b[i]:=sin(2*pi * i/m);
  End;
  Randomize;
  While not Keypressed Do Begin
    l:=random(m);
    If random<0.7 Then Begin
       {Sierp}
       x1:=x/2+a[l];
       y1:=y/2+b[l];
    End Else Begin
       {Henon}
       x1:=(x*a[l] + y*b[l] + x*x*b[l]) / 6;
       y1:=(y*a[l] - x*b[l] + x*x*a[l]) / 6;
    End;
    x:=x1;
    y:=y1;
    PutPixel(320 + Round(x*140), 240 + Round(y*140), 14);
  End;
  Readkey;
  CloseGraph;
End.

