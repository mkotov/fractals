Program Attract2;
Uses Graph, Crt;
Const
  A = -2.7;
  B = -0.9;
  C = -0.86;
  D = -2.2;
Var
  gd, gm: Integer;
  x, y, t: Real;
  x2, y2: Integer;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=0;
  y:=0;
  While not KeyPressed do Begin
    t:=x;
    x:=sin(A*y) - cos(B*x);
    y:=sin(C*t) - cos(D*y);
    x2:=Round(x*125)+350;
    y2:=Round(y*125)+210;
    PutPixel(x2, y2, GetPixel(x2, y2)+1);
  End;
  ReadKey;
  CloseGraph;
end.


