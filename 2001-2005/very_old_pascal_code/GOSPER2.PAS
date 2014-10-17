{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Gosp2;
Uses CRT, Graph;
var
  gd, gm: Integer;

Procedure Draw(x, y, l, u : Real; t, q : Integer);
Procedure Draw2(Var x, y: Real; l, u : Real; t, q : Integer);
Begin
    Draw(x, y, l, u, t, q);
    x := x + l*cos(u);
    y := y - l*sin(u);
End;
Begin
  If t > 0 Then Begin
    If q = 1 then Begin
      x := x + l*cos(u);
      y := y - l*sin(u);
      u := u + pi;
    End;
    u := u - 2*pi/19;
    l := l/sqrt(7);
    Draw2(x, y, l, u,        t-1, 0);
    Draw2(x, y, l, u+pi/3,   t-1, 1);
    Draw2(x, y, l, u+pi,     t-1, 1);
    Draw2(x, y, l, u+2*pi/3, t-1, 0);
    Draw2(x, y, l, u,        t-1, 0);
    Draw2(x, y, l, u,        t-1, 0);
    Draw2(x, y, l, u-pi/3,   t-1, 1);
  End
  Else Line(Round(x), Round(y), Round(x+cos(u)*l), Round(y-sin(u)*l))
End;

Begin
  gd := Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  Draw(100, 355, 400, 0, 4, 0);
  ReadKey;              {^}
  CloseGraph
End.


