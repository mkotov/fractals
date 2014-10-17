{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
uses graph,crt;
procedure fractal(x,y,l:integer);
begin
   if keypressed then exit;
   if l>3 then begin
      l:=l div 2;
      line(x, y, x+l, y);
      line(x, y, x-l, y);
      line(x + l, y, x + l, y - l div 2);
      line(x + l, y, x + l, y + l div 2);
      line(x - l, y, x - l, y - l div 2);
      line(x - l, y, x - l, y + l div 2);
      fractal(x + l, y - l div 2, l);
      fractal(x + l, y + l div 2, l);
      fractal(x - l, y - l div 2, l);
      fractal(x - l, y + l div 2, l);
   end;
end;
Var
  gd, gm: Integer;
begin
   gd:=detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   setcolor(15);
   fractal(320,240,300);
   readkey;
   closegraph;
end.
