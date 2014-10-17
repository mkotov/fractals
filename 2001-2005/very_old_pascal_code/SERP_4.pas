{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Sierp4;
Uses CRT, Graph;
Var
   gd, gm: Integer;
   x1, y1, x2, y2, x3, y3: real;
   A: Array[1..3, 1..3] of Boolean;
Function BR: Boolean;
Begin
  If Random>0.2 Then BR:=True Else BR:=False;
End;
procedure serp(x1, y1, x2, y2: real; n: integer);
var
  x1n, y1n, x2n, y2n: real;
begin
  if  n > 0  then begin

    x1n:= 2*x1/3+x2 / 3;
    x2n:= x1/3+2*x2 / 3;
    y1n:= 2*y1/3+y2 / 3;
    y2n:= y1/3+2*y2 / 3;
    rectangle(round(x1),round(y1),round(x2),round(y2));
    if A[1,1] Then serp(x1, y1, x1n, y1n, n-1);
    if A[1,2] Then serp(x1n, y1, x2n, y1n, n-1);
    if A[1,3] Then serp(x2n, y1, x2, y1n, n-1);
    if A[2,1] Then serp(x1, y1n, x1n, y2n, n-1);
    if A[2,2] Then serp(x1n, y1n, x2n, y2n, n-1);
    if A[2,3] Then serp(x2n, y1n, x2, y2n, n-1);
    if A[3,1] Then serp(x1, y2n, x1n, y2, n-1);
    if A[3,2] Then serp(x1n, y2n, x2n, y2, n-1);
    if A[3,3] Then serp(x2n, y2n, x2, y2, n-1);
  end;
end;

Begin
  gd:=detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  Randomize;
  Repeat
  ClearDevice;
  For i:=1 to 3 Do For j:=1 to 3 Do A[i,j]:=BR;
  Serp(150, 150,150+9*9*3, 150+9*9*3, 6);
  Delay(20000);
  Until KeyPressed;
  ReadLn;
  CloseGraph;
End.
