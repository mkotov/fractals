{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Qs;
Uses Graph, Crt;
Var
   n      : Integer;
   gd, gm : Integer;
   q      : Array [1..640] of Integer;
Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   q[1]:=1;
   q[2]:=1;
   for n:=3 to 640 do Begin
     q[n]:=q[n - q[n - 1]] + q[n - q[n - 2]];
     Line(n, 480 - q[n], n - 1, 480 - q[n - 1]);
   End;
   ReadKey;
   CloseGraph;
end.

