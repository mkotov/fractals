{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
program mink;
uses crt,graph;
Const
  min=4;
var
  a,b:integer;
procedure rotate_plus(var x,y:integer);
var t:integer;
begin
   t:=x;
   x:=y;
   y:=-t
end;
procedure rotate_minus(var x,y:integer);
var t:integer;
begin
   t:=x;
   x:=-y;
   y:=t
end;
procedure draw(x,y:integer;length:word);
var t:word;
begin
   if keypressed then exit;
   if length>= min then
    begin
     t:=length div 4;
     draw(x,y,t);
     rotate_plus(x,y);
     draw(x,y,t);
     rotate_minus(x,y);
     draw(x,y,t);
     rotate_minus(x,y);
     draw(x,y,t);
     draw(x,y,t);
     rotate_plus(x,y);
     draw(x,y,t);
     rotate_plus(x,y);
     draw(x,y,t);
     rotate_minus(x,y);
     draw(x,y,t)
    end
   else linerel(length*x,length*y)
  end;
begin
 initgraph(a,b,'c:\bp\bgi');
 moveto(50,200);
 draw(1,0,512);
 readkey;
 closegraph
end.


