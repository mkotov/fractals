Program Curve30;
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
  If t > 0 then Begin
    l := l/sqrt(2);
    Draw2(x, y, l, u-pi/4, t-1);
    Draw2(x, y, l, u+pi/4, t-1);
  End
  Else Line(Round(x), Round(y), Round(x+cos(u)*l), Round(y-sin(u)*l))
End;

Begin
  gd := Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  Draw(360, 160, 150, -pi, 10);
  Draw(210, 310, 150, 0, 10);
  Draw(210, 160, 150, -pi/2, 10);
  Draw(360, 310, 150, pi/2, 10);
  ReadKey;
  CloseGraph
End.


