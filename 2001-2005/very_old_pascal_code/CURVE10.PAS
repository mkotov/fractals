{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Curve10;
Uses CRT, Graph;
Var
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
    l := l/6;
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u+pi/2, t-1);
    Draw2(x, y, l, u+pi/2, t-1);
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u-pi/2, t-1);
    Draw2(x, y, l, u-pi, t-1);
    Draw2(x, y, l, u-pi/2, t-1);
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u-pi/2, t-1);
    Draw2(x, y, l, u-pi, t-1);
    Draw2(x, y, l, u-pi/2, t-1);
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u+pi/2, t-1);
    Draw2(x, y, l, u+pi/2, t-1);
    Draw2(x, y, l, u, t-1);
  End
  Else Line(Round(x), Round(y), Round(x+cos(u)*l), Round(y-sin(u)*l))
End;

Begin
  gd := Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  Draw(310, 110, 200, -pi, 2);
  Draw(110, 310, 200, 0, 2);
  Draw(110, 110, 200, -pi/2, 2);
  Draw(310, 310, 200, pi/2, 2);
  ReadKey;
  CloseGraph
End.


