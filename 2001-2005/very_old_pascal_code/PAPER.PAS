{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

program Paper;
uses CRT, Graph;

var
  gd, gm: Integer;
  L     : Integer;

procedure Draw(x, y, l, u : Real; t : Integer);
procedure Draw2(var x, y: Real; l, u : Real; t : Integer);
begin
    Draw(x, y, l, u, t);
    x := x + l*cos(u);
    y := y - l*sin(u)
end; {proc Draw2}

begin
  if t > 0 then begin
    l := l*0.453;
    Draw2(x, y, l, u, t-1);
    Draw2(x, y, l, u+7*pi/15, t-1);
    Draw2(x, y, l, u-7*pi/15, t-1);
    Draw2(x, y, l, u, t-1)
  end
  else Line(Round(x), Round(y), Round(x+cos(u)*l), Round(y-sin(u)*l))
end; {proc Draw}

begin
  gd := Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  L := GetMaxY - 20;
  Draw(L+10, 10,   L, -pi,   4);
  Draw(10,   L+10, L, 0,     4);
  Draw(10,   10,   L, -pi/2, 4);
  Draw(L+10, L+10, L, pi/2,  4);

  ReadKey;
  CloseGraph
end. {program Paper}


