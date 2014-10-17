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
procedure draw(x,y:integer;size:word);
var s:word;
begin
if size>min_size then begin
s:=size div 3;
draw(x,y+20,s);
draw(x+size*2,y+20,s);
end;
bar(x,y,x+size,y+5);
bar(x+2*size,y,x+3*size,y+5);
end;
Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
draw(10,10,600);
readln;
closegraph;
end.
