{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Penta;
Uses CRT, Graph;
Procedure Draw(x, y, r, a: Real);
Var
  i: Integer;
  xx, yy: Array [0..5] of Real;
Begin
  For i := 0 to 5 do Begin
    xx[i] := r*cos(a + i*pi*2/5);
    yy[i] := r*sin(a + i*pi*2/5);
  End;
  For i := 0 to 4 do Begin
    Line(Round(x + xx[i]),   Round(y + yy[i]),
         Round(x + xx[i+1]), Round(y + yy[i+1]));
  End;
End;

Procedure ProvRis(x, y, r, a: Real; d: Integer);
Var
  i: Integer;
  h: Real;
Begin
  h := 2*r*cos(pi/5);
  For i := 0 to 4 do begin
    Draw(x - h*cos(a+i*pi*2/5), y - h*sin(a+i*pi*2/5), r, a + pi + i*pi*2/5);
  If d > 0 then
      ProvRis(x - h*cos(a+i*pi*2/5), y - h*sin(a+i*pi*2/5),
              r/(2*cos(pi/5)+1), a+pi+(2*i+1)*pi*2/10, d-1);
  End;
  Draw(x, y, r, a);
  If d > 0 then ProvRis(x, y, r/(2*cos(pi/5)+1), a+pi, d-1);
End;

Var
  gd, gm: Integer;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  ProvRis(320, 260, 95, pi/2, 3);
  ReadKey;
  CloseGraph;
End.
