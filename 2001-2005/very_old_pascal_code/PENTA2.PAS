{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Polygon;
Uses CRT, Graph;
Const
  n = 5;     {3, 1/2} {4, 1/2} {5, 3/8} {6, 1/3} {7, 3/10}
  t = 3/8;
Type
  PolyPoints = Array [1..n+1] of PointType;

Procedure Draw(x, y, s : Integer; r : Byte);
Var
  i : Integer;
  p : PolyPoints;
    a : Real;
Begin
  If r = 0 then Exit;
  a := (360 / n + 0) * (pi / 180);
  For i := 1 to n do Begin
    p[i].x := x + Round(cos(a * i) * s / 2);
    p[i].y := y + Round(sin(a * i) * s / 2);
  End;
  p[n + 1] := p[1];
  For i := 1 to n do Draw(p[i].x, p[i].y, Round(s*t), r - 1);
  FillPoly(n + 1, p);
End;
Var
  gd, gm : Integer;
Begin
  gd := Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  SetLineStyle(0, 0, 0);
  SetFillStyle(1, 0);
  Draw(320, 240, 300, 6);
  ReadKey;
  CloseGraph;
End.