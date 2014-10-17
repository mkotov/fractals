{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Mink2;
Uses CRT, Graph;
var
  gd, gm: Integer;

Procedure Draw(x, y, l, u : Real; t : Integer);
Procedure Draw2(Var x, y: Real; l, u : Real; t : Integer);
Begin
    Draw(x, y, l, u, t);
    x:=x+l*cos(u);
    y:=y-l*sin(u);
End;
Begin
  If t>0 Then Begin
    l:=0.25*l;
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u-pi/2, t-1);
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u+pi/2, t-1);
    Draw2(x, y, l, u+pi/2, t-1);
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u-pi/2, t-1);
    Draw2(x, y, l, u, t-1);
  End
  Else Line(Round(x),Round(y), Round(x+cos(u)*l), Round(y-sin(u)*l))
End;

Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  Draw(100, 100, 280, 0,     3);
  Draw(380, 100, 280, -pi/2,  3);
  Draw(380, 380, 280, -pi,    3);
  Draw(100, 380, 280, -3*pi/2,3);
  ReadKey;
  CloseGraph
End.


