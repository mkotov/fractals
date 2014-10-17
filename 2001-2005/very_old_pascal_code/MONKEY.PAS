{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program MonkeyTree;
Uses CRT, Graph;
var
  gd, gm: Integer;

Procedure Draw(x, y, l, u : Real; t, q,s : Integer);
Procedure Draw2(Var x, y: Real; l, u : Real; t, q,s : Integer);
Begin
    Draw(x, y, l, u, t, q,s);
    x := x + l*cos(u);
    y := y - l*sin(u);
End;
Begin
  If t > 0 then Begin
    If q = 1 then Begin
      x := x + l*cos(u);
      y := y - l*sin(u);
      s:=-s;
      u:=u+pi;
    End Else
    If q = 3 then Begin
      x := x + l*cos(u);
      y := y - l*sin(u);
      s:=s;
      u:=u+pi;
    End Else
    If q = 2 then Begin
      s:=-s
    End Else
    If q = 0 then Begin
      s:=s
    End;
    l := l/3;
    Draw2(x, y, l,           u+s*pi/3,   t-1, 2,s);
    Draw2(x, y, l,           u+s*pi/3,   t-1, 1,s);
    Draw2(x, y, l,           u,          t-1, 0,s);
    Draw2(x, y, l,           u-s*pi/3,   t-1, 1,s);
    Draw2(x, y, l*sqrt(3)/3, u-s*7*pi/6, t-1, 1,s);
    Draw2(x, y, l*sqrt(3)/3, u-s*7*pi/6, t-1, 2,s);
    Draw2(x, y, l*sqrt(3)/3, u-s*5*pi/6, t-1, 3,s);
    Draw2(x, y, l*sqrt(3)/3, u-s*pi/2,   t-1, 3,s);
    Draw2(x, y, l*sqrt(3)/3, u-s*pi/2,   t-1, 0,s);
    Draw2(x, y, l,           u,          t-1, 3,s);
    Draw2(x, y, l,           u,          t-1, 0,s);

  End
  Else Line(Round(x), Round(y), Round(x+cos(u)*l), Round(y-sin(u)*l));
End;

Begin
  gd := Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  Draw(50, 365, 430, 0, 3, 0, 1);
  ReadKey;              {^}
  CloseGraph
End.


