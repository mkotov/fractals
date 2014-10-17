Program Circle;
Uses Graph, Crt;
Var
   x, y, z  : Integer;
   gd, gm   : Integer;
   mx, my   : Integer;
Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   mx:=GetMaxX div 2;
   my:=GetMaxY div 2;
   For y:=-my to my do
      For x:=-mx to mx do Begin
        z:=trunc(0.1*(sqr(x)+sqr(y)));
        PutPixel(mx + x,my + y,z mod 16);
      End;
   Readkey;
   CloseGraph;
end.

