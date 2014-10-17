{***************************************}
{*    name: Функция Вейерштрасса-      *}
{*          Мандельброта               *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{* comment:                            *}
{*        +inf  1 - cos(b^n*t)         *}
{* C(t) =  SUM ---------------         *}
{*        -inf   b^((2-D)*n)           *}
{* 1 < D < 2, inf-бесконечность        *}
{*    date: 05.08.05                   *}
{*            (c)iK - 2005             *}
{***************************************}

Program FVM;
Uses CRT, Graph;
Const
  D = 1.5;
  b = 1.5;
  inf = 100;
  tn= 1.0;
Function C(t: Real): Real;
Var
  tmp : Real;
  n : Integer;
Begin
  tmp:=0;
  For n:=-inf to inf do
    tmp:=tmp + (1 - cos(exp(n*ln(b))*t))/(exp(n*(2-D)*ln(b)));
  C:=tmp;
End;

Var
  gd, gm : Integer;
  t: Real;
  my: Integer;
  i:Integer;
  s: String;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  t:=0;
  my:=Round(450/C(tn));
  SetColor(14);
  Rectangle(30,0,639,465);
  For i:=0 to 5 do Begin
    Str((i/5):1:1,s);
    OutTextXY(i*123,470,s);
    Str((i/5*C(tn)*450/480):1:1,s);
    OutTextXY(0,470-i*94, s);
  End;
  SetColor(15);
  MoveTo(30,465);
  Repeat
    LineTo(Round(t*610+30), Round(465-C(t)*my));
    t:=t+0.0005;
    If KeyPressed then Exit;
  Until t>=1;
  Str(D:2:1,s);
  s:='D='+s;
  OutTextXY(500,400,s);
  Str(b:2:1,s);
  s:='b='+s;
  OutTextXY(500,420,s);

  ReadKey;
  CloseGraph;
End.
{
Ниже приведены значения, при которых
программа строит более-менее нормальные
графики (при этом inf=100).
 -------------------
   D   b_min  b_max
 -------------------
  1.1   1.1    1.2
  1.2   1.1    1.3
  1.3   1.1    1.3
  1.4   1.1    1.4
  1.5   1.1    1.6
  1.6   1.1    1.8
  1.7   1.1    2.2
  1.8   1.1    2.4
  1.9   1.1    2.4
 -------------------
}



