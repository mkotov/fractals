Program Barn;
Uses Graph, CRT;
Type
  Complex = Record
    x: Real;
    y: Real;
  End;

Const
  Iter=50;
  Max=4;

Var
  z, z1, c: Complex;
  x, y, n : Integer;
  gd, gm  : Integer;
  mx, my  : Integer;

Begin
  gd := Detect;
  InitGraph(gd,gm,'c:\bp\bgi');
  Randomize;
  mx:=GetMaxX div 2;
  my:=GetMaxY div 2;
  For y:=-my To my Do
    For x:=-mx To mx Do Begin
      n:=0;
      z1.x:=x*0.008;
      z1.y:=y*0.008;
      c.x:=0.6;
      c.y:=1.1;
      While (sqr(z1.x)+sqr(z1.y) < max) and (n<iter) Do begin
        z:=z1;
        If z.x*c.y+c.x*z.y>=0 Then Begin
          z1.x := z.x*c.x-z.y*c.y-c.x;
          z1.y := z.x*c.y+z.y*c.x-c.y;
        End Else Begin
          z1.x := z.x*c.x-z.y*c.y+c.x;
          z1.y := z.x*c.y+z.y*c.x+c.y;
        End;
        Inc(n);
      End;
      PutPixel(mx+x, my+y, n mod 16);
      If KeyPressed Then Break;
    End;
  ReadKey;
  CloseGraph;
End.