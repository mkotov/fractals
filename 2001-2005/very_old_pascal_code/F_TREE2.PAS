Program FracTree;
Uses Graph, CRT;
Procedure Tree(x, y: Integer; a: Real; l:integer);
Var
  x1, y1: Integer;
  p, s  : Integer;
  i     : Integer;
  a1    : Real;
Begin
  If l<8 Then exit;
  x1 := Round(x + l*cos(a));
  y1 := Round(y + l*sin(a));
  If l > 100 Then p:=100 Else p:=l;
  If p < 40 Then Begin
    If Random > 0.5 Then SetColor(10) Else SetColor(2);   {4, 14}
    For i:=0 To 3 Do Line(x+i, y, x1, y1)
  End
  Else Begin
    Setcolor(6);
    For i:=0 To (p div 6) Do Line(x+i-(p div 12), y, x1, y1);
  End;
  For i:=0 To 9-Random(9) Do Begin
    s := Random(l-l div 6) + (l div 6);
    a1:= a + 1.6*(0.5-Random);
    x1:= Round(x + s*cos(a));
    y1:= Round(y + s*sin(a));
    Tree(x1, y1, a1, p-5-Random(30));
  End;
End;

Var
  gd, gm: Integer;
Begin
  Randomize;
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  Tree(320, 480, 3*pi/2, 200);
  ReadKey;
  CloseGraph;
end.