{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Plazma;
Uses CRT, Graph;
var
  Plasma : Array [0..318, 0..198] of Byte;
  x, y, j: Integer;
  gd, gm : Integer;
  c:Integer;

Procedure RGB(N, R, G, B:Word);
Begin
  Port[$3c8]:=n;
  Port[$3c9]:=R div 4;
  Port[$3c9]:=G div 4;
  Port[$3c9]:=B div 4;
End;

Procedure Adjust(xa,ya,x,y,xb,yb: Integer);
Var
  d: Integer;
  v: Real;
Begin
  if plasma[x, y] <> 0 then exit;
  d:=Abs(xa - xb) + Abs(ya - yb);
  v:=(plasma[xa, ya] + plasma[xb, yb]) / 2 + (random - 0.5) * d * 2;
  If v < 1 Then v:=1;
  If v >= 255 Then v:=255;
  plasma[x, y]:=Trunc(v);
End;

Procedure HalfWay(x1, y1, x2, y2: Integer);
Var
  x, y: Integer;
Begin
  If (x2 - x1 < 2) and (y2 - y1 < 2) Then Exit;
  x:=(x1 + x2) div 2;
  y:=(y1 + y2) div 2;
  Adjust(x1, y1, x,  y1, x2, y1);
  Adjust(x2, y1, x2, y,  x2, y2);
  Adjust(x1, y2, x,  y2, x2, y2);
  Adjust(x1, y1, x1, y,  x1, y2);
  If Plasma[x,y]=0 Then
    plasma[x,y]:=trunc((plasma[x1, y1] + plasma[x2, y1] + plasma[x2, y2] + plasma[x1, y2]) / 4);
  HalfWay(x1, y1, x,  y);
  HalfWay(x,  y1, x2, y);
  HalfWay(x,  y,  x2, y2);
  HalfWay(x1, y,  x,  y2);
end;

Procedure MakePlasma;
Begin
  Plasma[0,   198]:=Random(190);
  Plasma[318, 198]:=Random(190);
  Plasma[318, 0  ]:=Random(190);
  Plasma[0,   0  ]:=Random(190);
  HalfWay(0, 0, 318, 198);
End;

Begin
  Asm
    mov ax ,13h
    int 10h
  End;
  Randomize;
  c:=0;
  MakePlasma;
  For x := 0 to 318 do
   For y := 0 to 198 do
     Mem[$0a000 : y * 320 + x] := plasma[x, y];
  Repeat
    For J:=0 To 43 Do RGB((j+c)mod 256, 255, j*6, 0);
    For J:=0 To 43 Do RGB((43+j+c)mod 256, 255-j*6, 255, 0);
    For J:=0 To 43 Do RGB((86+j+c)mod 256, 0, 255, j*6);
    For J:=0 To 43 Do RGB((129+j+c)mod 256, 0, 255-j*6, 255);
    For J:=0 To 43 Do RGB((172+j+c)mod 256, j*6, 0, 255);
    For J:=0 To 40 Do RGB((215+j+c)mod 256, 255, 0, 255-j*6);
    inc(c);
    delay(1000);
  Until KeyPressed;
  Readkey;
End.
