{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Ms;
Uses Graph, Crt;
const
l=512;
Var
   n,t    : Integer;
   gd, gm : Integer;
   m      : Array [0..l] of Integer;
   a: Integer;
   t2:integer;
Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   For n:=0 to l do m[n]:=0;
   For t:=1 to 8 do Begin
     n:=0;
     Repeat
       t2:=Round(exp(t*ln(2)));
       For a:=0 to t2 do m[n+a]:=m[n+a]+a;
       For a:=t2-1 downto 1 do m[n+2*t2-a]:=m[n+2*t2-a]+a;
      n:=n+2*t2;
     Until n>=l;
   End;
   For n:=0 to l do Line(n, 439 - m[n], n - 1, 439 - m[n-1]);
   ReadKey;
   CloseGraph;
end.

