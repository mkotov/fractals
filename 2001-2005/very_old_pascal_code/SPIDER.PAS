{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
program Spider;
uses graph, crt;
type
   complex=record X:real;Y:real; end;
const
   iter=50;
   max=16;
var
   z,z1,c,c1:complex;
   x,y,n:integer;
   cancel:boolean;
   gd,gm : Integer;
begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   cancel:=false;Randomize;
   for y:=-getmaxy div 2 to getmaxy div 2 do
      for x:=-getmaxx div 2 to getmaxx div 2 do
      begin
         n:=0;
         z.X:=X*0.01;
         z.Y:=Y*0.01;
         c.X:=z.x;
         c.Y:=z.y;
         while (sqr(Z.X)+sqr(Z.Y)<max)and(n<iter) do begin
            z1:=z;
            c1:=c;
             z.x:=sqr(z1.x)-sqr(z1.y)+c.x;
             z.y:=2*z1.x*z1.y+c.y;
             c.x:=c1.x/2+z.x;
             c.y:=c1.y/2+z.y;
            inc(n);
            if keypressed then cancel:=true;
         end;
         if n<iter then
            putpixel(getmaxx div 2+x,getmaxy div 2+y,n mod 16);{}
         if cancel then exit;
      end;
   readkey;
   closegraph;
end.