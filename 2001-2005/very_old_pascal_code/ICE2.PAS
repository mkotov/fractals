{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Ice2;
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
    l := l*0.5;
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l*0.45, u+2*pi/3, t-1);
    Draw2(x, y, l*0.45, u-pi/3, t-1);
    Draw2(x, y, l*0.45, u+pi/3, t-1);
    Draw2(x, y, l*0.45, u-2*pi/3, t-1);
    Draw2(x, y, l, u, t-1);
  End
  Else Line(Round(x), Round(y), Round(x+cos(u)*l), Round(y-sin(u)*l))
End;

Begin
  gd := Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  Draw(210, 8, 400, -2*pi/3, 3);
  Draw(10, 354, 400, 0, 3);
  Draw(410, 354, 400, 2*pi/3, 3);

  ReadKey;              {^}
  CloseGraph
End.


