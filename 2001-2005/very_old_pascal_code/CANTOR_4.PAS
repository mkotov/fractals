{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
uses crt,graph;
Var
   gd,gm : Integer;

const
min_size=1;
procedure draw(x,y:integer;size:word);
var s:word;
begin
if size>min_size then begin
s:=size div 2;
draw(x-size,y+size,s);
draw(x-size,y-size,s);
draw(x+size,y+size,s);
draw(x+size,y-size,s);
end;
rectangle(x-size,y-size,x+size,y+size);
bar(x-size+1,y-size+1,x+size-1,y+size-1);
end;
begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   setfillstyle(solidfill,0);
   setcolor(15);
   draw(320,240,120);
   readln;
   setwritemode(xorput);
   setcolor(0);
   draw(320,240,120);
   readln;
   closegraph;
end.
