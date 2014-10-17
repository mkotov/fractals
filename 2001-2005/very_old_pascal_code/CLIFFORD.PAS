Program Clifford;
Uses Graph, Crt;
Const
  A = 1.5;
  B =-1.8;
  C = 1.6;
  D = 0.9;
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
    x:=sin(A*y) + C*cos(A*x);
    y:=sin(B*t) + D*cos(B*y);
    x2:=Round(x*100)+350;
    y2:=Round(y*100)+210;
    PutPixel(x2, y2, GetPixel(x2, y2)+1);
  End;
  ReadKey;
  CloseGraph;
end.


