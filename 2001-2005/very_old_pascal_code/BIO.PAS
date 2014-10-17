{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
program Bio1;
uses graph, crt;
type
   complex=record X:real;Y:real; end;
const
   iter=50;
   max=70;
var
   z,z1,c:complex;
   x,y,n:integer;
   cancel:boolean;
   gd,gm : Integer;
begin
   cancel:=false;
   Randomize;
   GD:= Detect;
   InitGraph(GD,GM,'c:\bp\bgi');
   for y:=-getmaxy div 2 to getmaxy div 2 do
      for x:=-getmaxx div 2 to getmaxx div 2 do
      begin
         n:=0;
         z.X:=X*0.01;
         z.Y:=Y*0.01;
         c.X:=0;
         c.Y:=1;
         while ((sqr(z.x) < max) and (sqr(z.y) < max)) and (n<iter) do
         begin
            z1:=z;
            Z.X:=Z1.X*Z1.X*Z1.X*Z1.X + Z1.Y*Z1.Y*Z1.Y*Z1.Y - 6*Z1.X*Z1.X*Z1.Y*Z1.Y;
            Z.Y:=4*Z1.X*Z1.X*Z1.X*Z1.Y - 4*Z1.X*Z1.Y*Z1.Y*Z1.Y;{}
            {Z.X:=Z1.X*Z1.X*Z1.X - 3*Z1.X*Z1.Y*Z1.Y;
            Z.Y:=3*Z1.X*Z1.X*Z1.Y - Z1.Y*Z1.Y*Z1.Y; {}
            {Z.X:=Sqr(Z1.X)-Sqr(Z1.Y);
            Z.Y:=2*Z1.X*Z1.Y;{}
            Z1.X:=Z.X+C.X;
            Z1.Y:=Z.Y+C.Y;
            z:=z1;
            inc(n);
            if keypressed then cancel:=true;
         end;
         if ( ABS(z.x) > 10 ) OR ( ABS(z.y) > 1000) then begin
            putpixel(getmaxx div 2+x,getmaxy div 2+y,n mod 16);{}
         end;
         if cancel then exit;
      end;
   readkey;
   closegraph;
end.