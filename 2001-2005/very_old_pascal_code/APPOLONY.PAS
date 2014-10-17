Program Apollony;
Uses CRT, Graph;
Var
  gd, gm: Integer;
  x, y, a: Real;
  r: Real;
  a0, b0: Real;
  fx, fy: Real;
Begin
  gd:=detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
   x:=0;
   y:=0;
   a:=0;
   Randomize;
   r:=Sqrt(3);
   While not KeyPressed Do Begin
     a:=random;
     a0:=3*(1+r-x)/(sqr(1+r-x)+sqr(y))-(1+r)/(2+r);
     b0:=3*y/(sqr(1+r-x)+sqr(y));
     fx:=a0/(sqr(a0)+sqr(b0));
     fy:=-b0/(sqr(a0)+sqr(b0));
     If a<=1/3 Then Begin
        x:=a0;
        y:=b0;
     End
     Else If a<=2/3 Then Begin
       x:=-fx*1/2-fy*r/2;
       y:=fx*r/2-fy*1/2;
     End
     Else Begin
       x:=-fx*1/2+fy*r/2;
       y:=-fx*r/2-fy*1/2;
     End;
   PutPixel(320+Round(x*50), 240+Round(y*50), 15);
  End;
  ReadKey;
  CloseGraph;
End.
