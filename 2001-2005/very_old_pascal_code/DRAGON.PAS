Program Dragon;
Uses Graph, Crt;
Const
   c = 1024*16;
   d = 3;
   da =pi/2;
Var
   i   : Integer;
   gd, gm   : Integer;
   a,x,y : Real;
procedure lineto1(x,y,l,u:real);
begin
  line(Round(x),round(y),round(x+l*cos(u)),Round(y-l*sin(u)));
end;
function opra(n:integer):integer;
Label
  nach;
Var
  j:integer;
Begin
 j:=n;
 nach:
 if (j-1) mod 4 = 0 then opra:=-1
 else if (j-3) mod 4 = 0 then opra:=1
 else Begin
   j:=j div 2;
   goto nach;
 End;
End;
Begin
   gd:=Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   x:=150;
   y:=150;
   a:=pi/2;
   For i:=1 to c+1 do Begin
     lineto1(x,y,d,a);
     x:=x+d*cos(a);
     y:=y-d*sin(a);
     a:=a-da*opra(i);
   End;
   Readkey;
   CloseGraph;
end.

