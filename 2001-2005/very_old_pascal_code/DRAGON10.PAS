{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Dragon10;
Uses CRT, Graph;
Const
  m =8;  {3..15}
Var
  i, n, l: Integer;
  x, y, c, r,ra,x1,y1: Real;
  a, b: Array [0..m] of Real;
  gd, gm: Integer;
Begin
  gd := Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  For i:=0 to m-1 do Begin
    a[i] := cos(2*pi*i/m);
    b[i] := sin(2*pi*i/m);
  End;
  r := sqrt(1.25*m);
  x := 1; y := 1;
  While not KeyPressed do Begin
    l:=Random(m+1);
    ra:=1/(sqrt(3*(x*x+y*y)));
    If l mod 2 = 0 then Begin
      x1 := -x/r + ra*y/r + a[l];
      y1 := -ra*x/r - y/r + b[l];
    End
    Else Begin
      x1 :=  x/r + ra*y/r + a[l];
      y1 := -ra*x/r + y/r + b[l];
    End;
    x := x1;
    y := y1;
    PutPixel(Round(320+150*x),round(250+150*y),Random(16));
  End;
  ReadKey;
  CloseGraph;
End.
