{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Pif;
Uses CRT, Graph;
Procedure Draw(x, y, l, a: Real);
Procedure Rect(x1, y1, l: Integer; a1: Real);
Begin
  MoveTo(x1, y1);
  LineTo(x1+Round(l*cos(a1)), y1-Round(l*sin(a1)));
  LineTo(x1+Round(l*sqrt(2)*cos(a1+pi/4)), y1-Round(l*sqrt(2)*sin(a1+pi/4)));
  LineTo(x1+Round(l*cos(a1+pi/2)), y1-Round(l*sin(a1+pi/2)));
  LineTo(x1, y1);
End;
Begin
  If l>4 Then Begin
    Rect(Round(x), Round(y), Round(l), a);
    Draw(x-l*sin(a), y-l*cos(a), l/sqrt(2), a+pi/4);
    Draw(x-l*sin(a)+l/sqrt(2)*cos(a+pi/4),
         y-l*cos(a)-l/sqrt(2)*sin(a+pi/4), l/sqrt(2), a-pi/4);
  End;
End;

Var
  gd, gm: Integer;
Begin
  gd:=detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  Draw(280, 460, 100, 0);
  ReadKey;
  CloseGraph;
End.

