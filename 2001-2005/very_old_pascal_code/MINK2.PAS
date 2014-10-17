{***************************************}
{*    name: Curve Mink                 *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{*    date: 7.12.04                    *}
{* comment: использование сист. счисле-*}
{*          ния по основанию 8         *}
{*            (c)iK - 2004             *}
{***************************************}
Program Mink;
Uses CRT, Graph;
Const
  p=4;
Var
  gd, gm: Integer;
  i, j: Integer;
  x, y, l: Real;
  a: Real;
  n, m: Integer;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=0;
  y:=240;
  l:=640/(exp(p*ln(4)));
  MoveTo(Round(x), Round(y));
  For i:=0 to Round(exp(p*ln(8)))-1 Do Begin
    a:=0;
    n:=i;
    Repeat
      m:=n mod 8;
      n:=n div 8;
      Case m of
        0: a:=a+0;
        1: a:=a-pi/2;
        2: a:=a+0;
        3: a:=a+pi/2;
        4: a:=a+pi/2;
        5: a:=a+0;
        6: a:=a-pi/2;
        7: a:=a+0;
      End;
    Until n<1;
    x:=x + l*cos(a);
    y:=y + l*sin(a);
    LineTo(Round(x), Round(y));
  End;
  ReadKey;
  CloseGraph;
End.