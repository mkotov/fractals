Program DTr;
Uses Graph, CRT;
Const
  max = 5;
Var
 gd, gm : Integer;

Procedure lineto1(x, y, l, u : real);
Begin
   Line(Round(x), Round(y), round(x + l * cos(u)), Round(y - l * sin(u)));
End;

Procedure Draw(x, y : Integer; l, u : real);
Begin
   If KeyPressed then exit;
   If l > max then Begin
      l := l * 0.37;
      lineto1(x, y, l, u);
      x := round(x + l * cos(u));
      y := round(y - l * sin(u));
      Draw(x, y, l + l / 3, u + 4 * pi/3);
      Draw(x, y, l + l / 3, u - 4 * pi/3);
      Draw(x, y, l + l / 3, u);
   End;
End;

Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   Draw(320, 240, 300, pi/2);
   Draw(320, 240, 300, pi/2 + 4 * pi/3);
   Draw(320, 240, 300, pi/2 - 4 * pi/3);
   ReadKey;
   CloseGraph;
End.
