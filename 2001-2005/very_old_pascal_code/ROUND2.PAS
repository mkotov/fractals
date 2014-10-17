{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
uses crt,graph;
Var
   gd,gm : Integer;

const
  min=1;
  n=3;
  m=5; {2..6}
procedure draw(x,y:integer;size:word);
Var
  s1,s2:Integer;
  i:integer;
begin
  If size>min then begin
    s1:=size div n;
    s2:=Round(size*(n-1)/n);
    For i:=1 to m do Begin
      draw(x-Round(s2*sin(2*pi/m*i)),y+Round(s2*cos(2*pi/m*i)),s1);
    End;
    draw(x,y,s1);
  end;
  Circle(x,y,size);
end;
begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   draw(320,240,200);
   readln;
   closegraph;
end.
