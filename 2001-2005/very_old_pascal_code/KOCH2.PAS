{***************************************}
{*    name: Curve                      *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{*    date: 7.12.04                    *}
{* comment: использование сист. счисле-*}
{*          ния по основанию 4         *}
{*            (c)iK - 2004             *}
{***************************************}
Program Curve;
Uses CRT, Graph;
Const
  p=4;
Var
  gd, gm: Integer;
  i, j: Integer;
  x, y, l: Real;
  a: Real;
  n, m, k: Integer;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=0;
  y:=400;
  l:=640/(exp(p*ln(3)));
  MoveTo(Round(x), Round(y));
  For i:=0 to Round(exp(p*ln(4)))-1 Do Begin
    a:=0;
    n:=i;
    k:=0;
    Repeat
      m:=n mod 4;
      n:=n div 4;
      Case m of
        0: a:=a+0;
        1: a:=a-pi/3;
        2: a:=a+pi/3;
        3: a:=a+0;
      End;
      inc(k);
    Until k>=p;
    x:=x + l*cos(a);
    y:=y + l*sin(a);
    LineTo(Round(x), Round(y));
  End;
  ReadKey;
  CloseGraph;
End.