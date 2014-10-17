{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Tree3;
Uses CRT, Graph;
Var
  gd, gm: Integer;

Procedure FrTree(x, y, l, u : Real; t : Integer);
Begin
  If t>0 then Begin
    l := l*0.5;
    Line(Round(x),Round(y),Round(x+l*cos(u)),Round(y-l*sin(u)));
    x := Round(x + l * cos(u));
    y := Round(y - l * sin(u));
    FrTree(x, y, l, u, t-1);
    FrTree(x, y, l, u+pi/4, t-1);
    FrTree(x, y, l, u-pi/4, t-1);
  End;
End;

Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  FrTree(320, 460, 350, pi/2,   6);
  FrTree(320, 460, 350, 3*pi/4, 6);
  FrTree(320, 460, 350, pi/4,   6);
  ReadKey;
  CloseGraph
End.

