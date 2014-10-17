{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
uses crt,graph;
const
min_size=0;
Var
   gd,gm : Integer;
procedure triangle(xc,yc:Integer; l:integer);
Var
  x1,y1,x2,y2,x3,y3:Integer;
Begin
  x1:=xc;
  y1:=yc-l;
  x2:=xc+Round(l*cos(pi/6));
  y2:=yc+Round(l*sin(pi/6));
  x3:=xc-Round(l*cos(pi/6));
  y3:=yc+Round(l*sin(pi/6));
  SetColor(1);
  Line(x1,y1,x2,y2);
  Line(x2,y2,x3,y3);
  Line(x3,y3,x1,y1);
  FloodFill(xc,yc,1);
   SetColor(15);
  Line(x1,y1,x2,y2);
  Line(x2,y2,x3,y3);
  Line(x3,y3,x1,y1);
End;
procedure draw(x,y:integer;size:word);
var s:word;
begin
if size>min_size then begin
s:=size div 2;
draw(x,y-size,s);
draw(x+Round(size*cos(pi/6)), y+Round(size*sin(pi/6)),s);
draw(x-Round(size*cos(pi/6)), y+Round(size*sin(pi/6)),s);

end;
triangle(x,y,size);
end;
begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
setfillstyle(solidfill,0);
draw(320,280,120);
readln;
closegraph;
end.
