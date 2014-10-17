{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program J100;
Uses CRT, Graph;
Var
  gd, gm: Integer;
  wx, wy, cx, cy, x, y, r, t: Real;
begin
  gd:=Detect;
  Randomize;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=0;
  y:=0;
  cx:=-0.74543; cy:=0.11301;
  While not KeyPressed Do Begin
    wx:=x-cx;
    wy:=y-cy;
    t:=arctan(abs(wy/wx))/2;
    If (wy>0)and(wx<0) then t:=pi/2-t Else
    If (wy<0)and(wx<0) then t:=t-pi/2 Else
    If (wy<0)and(wx>0) then t:=-t;
    r:=sqrt(sqrt(sqr(wx) + sqr(wy)));
    if Random > 0.022 then r:=-r;
    x:=r*cos(t);
    y:=r*sin(t);
    PutPixel(Round(x*200+320),  Round(y*200+240), 12);
    PutPixel(Round(-x*200+320), Round(-y*200+240), 12);
  End;
  ReadKey;
  CloseGraph;
end.
