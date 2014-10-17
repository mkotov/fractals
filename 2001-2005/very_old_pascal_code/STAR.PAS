{******************************}
{*   name: Star               *}
{*  autor: Kotov D., Kotov M. *}
{*   date: 14.11.2004         *}
{* e-mail: ikot@mail.ru       *}
{*comment: no comment         *}
{*        (c)iK - 2004        *}
{******************************}
Program Star;
Uses Graph, Crt;
Var
   gd, gm: Integer;
   i, m, c: Integer;
   x, y, x1, y1:Real;
   a, b: Array [0..25] of Real;

Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   x:=1; y:=1; m:=4;  {m = 3,4,5}
   For i:=0 To m Do Begin
      a[2*i] := cos(2*pi * (i+1) / m);
      b[2*i] := sin(2*pi * (i+1) / m);
      a[2*i+1] := 0.5*(cos(2*pi * (i+1) / m) + cos(2*pi * i / m));
      b[2*i+1] := 0.5*(sin(2*pi * (i+1) / m) + sin(2*pi * i / m));
   End;
   While Not KeyPressed Do Begin
      c := Random(2*m);
      x1 := (x/(x*x + y*y))/3 + a[c];
      y1 := (-y/(x*x + y*y))/3 + b[c];
      x := x1 / (x1*x1 + y1*y1);
      y := y1 / (x1*x1 + y1*y1);
      PutPixel(Round(x*70+320), Round(y*70+240), 9);
   End;
   Readkey;
   CloseGraph;
end.



