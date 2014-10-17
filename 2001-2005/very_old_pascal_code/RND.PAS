{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Rnd;
uses CRT, Graph;
Type
TComplex=record
   r:real;
   i:real;
end;
var
  gd, gm  : Integer;
  a, z, z2: TComplex;
  x, y    : Integer;
  cx, cy  : Integer;
  n       : Integer;

begin
  gd := Detect;
  InitGraph(gd,gm,'c:\bp\bgi');
  randomize;
  a.r:=random;
  a.i:=random;
  cx:=getmaxx div 2;
  cy:=getmaxy div 2;
   for y:=-cy to cy do
      for x:=-cx to cx do begin
        if keypressed then break;
        z.i:=x*0.01;
        z.r:=y*0.01;
        n:=0;
        repeat
          z2.r:=sqr(z.r) - sqr(z.i) + random;
          z2.i:=(z.r*z.i)*ln(abs((z.r*z.i+a.r)))+sin(z.r+z.i+a.i)*(z.r+z.i);
          z.r:=a.r+z2.r;
          z.i:=a.i+z2.i;
          inc(n);
        until (n>254) or ((sqr(z.r)+sqr(z.i)) > 25);
        PutPixel(cx+x,cy+y,n mod 16);
   end;
   readkey;
   closegraph;
end.
