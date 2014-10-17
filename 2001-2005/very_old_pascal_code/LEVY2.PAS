{***************************************}
{*    name: Curve Levy                 *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{*    date: 7.12.04                    *}
{* comment: использование сист. счисле-*}
{*          ния по основанию 2         *}
{*            (c)iK - 2004             *}
{***************************************}
Program Levy;
Uses CRT, Graph;
Const
  p=12;
Var
  gd, gm: Integer;
  i, j: Integer;
  x, y, l: Real;
  a: Real;
  n, m, k: Integer;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=300;
  y:=240;
  l:=3;{640/(exp(p*ln(sqrt(2))));}
  MoveTo(Round(x), Round(y));
  For i:=0 to Round(exp(p*ln(2)))-1 Do Begin
    a:=0;
    n:=i;
    m:=0;
    k:=0;
    Repeat
      m:=n mod 2;
      n:=n div 2;
      Case m of
        0: a:=a+pi/4;
        1: a:=a-pi/4
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