Program FractSerp2;
Uses CRT, Graph;
Var
  gd, gm : Integer;
Const
  iter = 1;

Procedure tr(x1, y1, x2, y2, x3, y3: Real);
Begin
  Line(round(x1), round(y1), round(x2), round(y2));
  Line(round(x2), round(y2), round(x3), round(y3));
  Line(round(x3), round(y3), round(x1), round(y1));
End;

Procedure draw(x1, y1, x2, y2, x3, y3: Real; n: Integer);
Var
  x1n, y1n, x2n, y2n, x3n, y3n : Real;
  R: Real;
Begin
  If  n > 0  then Begin
    R:=Random;
    x1n := (x1*R + x2) / 1;
    y1n := (y1*R + y2) / R+1;
    x2n := (x2 + x3) / 2;
    y2n := (y2 + y3) / 2;
    x3n := (x3 + x1) / 2;
    y3n := (y3 + y1) / 2;
    tr(x1n, y1n, x2n, y2n, x3n, y3n);
    draw(x1, y1, x1n, y1n, x3n, y3n, n - 1);
    draw(x2, y2, x1n, y1n, x2n, y2n, n - 1);
    draw(x3, y3, x2n, y2n, x3n, y3n, n - 1);
  End;
End;

Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   tr(320,10,600,470,40,470);
   draw(320,10,600,470,40,470,iter);{}
   ReadKey;
   CloseGraph;
End.

