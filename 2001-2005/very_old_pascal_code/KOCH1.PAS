{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Koch1;
Uses CRT, Graph;
var
  gd, gm: Integer;

Procedure Draw(x, y, l, u : Real; t : Integer);
Procedure Draw2(Var x, y: Real; l, u : Real; t : Integer);
Begin
    Draw(x, y, l, u, t);
    x := x + l*cos(u);
    y := y - l*sin(u);
End;
Begin
  If t > 0 Then Begin
    l := l/3;
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u+pi/3, t-1);
    Draw2(x, y, l, u-pi/3, t-1);
    Draw2(x, y, l, u, t-1);
  End
  Else Line(Round(x), Round(y), Round(x+cos(u)*l), Round(y-sin(u)*l))
End;

Begin
  gd := Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  Draw(410, 10, 400, -pi, 4);
  Draw(10, 410, 400, 0, 4);
  Draw(10, 10, 400, -pi/2, 4);
  Draw(410, 410, 400, pi/2, 4);

  ReadKey;              {^}
  CloseGraph
End.


