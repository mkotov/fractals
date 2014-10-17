{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}
program Poly10;
uses CRT, Graph;
var
  gd,gm : Integer;

const
  iter = 1000000;
  n    = 5;
  r    = 0.38;

procedure Draw;
var
  t, x, y, p : Real;
  a, b, c, d, u: Real;
  k : LongInt;
  mx, my, rad : Integer;
begin
  mx := 320;
  my := 240;
  rad:= 250;
  u := pi*(n-2)/n;
  a :=-cos(u);
  b := sin(u);
  c := r;
  d := 0;
  x := 0;
  y := 0;
  for k := 1 to iter do
  begin
    p := Random;
    t := x;
    if p <= 1/2 then
    begin
      x :=  a*x - b*y;
      y :=  b*t + a*y
    end
    else
    begin
      x :=  c*x - d*y + 1 - c;
      y :=  d*t + c*y - d
    end;
    PutPixel(mx + Round(rad * x), my - Round(rad * y), 2)
  end
end; {proc Draw}

begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   Draw;
   ReadKey;
   CloseGraph;
end. {of program Poly10}
            Vderevo