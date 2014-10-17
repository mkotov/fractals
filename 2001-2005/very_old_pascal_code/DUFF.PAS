{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
program Duff;
Uses CRT, Graph;
Var
   gd, gm : Integer;
   it, i : Integer;
   a, b, w, t, x, y, x1, y1: Real;
Begin
   gd := Detect;
    InitGraph(gd, gm, 'c:\bp\bgi');
    x := 0.0;
    y := 0.0;
    t := 0.0;
    a := 0.25;   {<- ->}
    b := 0.3;    {<- ->}
    w := 1;      {<- ->}
    it:=600;
    SetColor(0);
    For i:=1 to it Do Begin
      x1 := x + y/(2*pi);
      y1 := y + (-(x*x*x) + x - a*y + b*cos(w*t))/(2*pi);
      t  := t + 0.01;
      x := x1;
      y := y1;
      LineTo(Round(x*180+320),Round(y*180+240));
      SetColor(random(14)+1);
    End;
    ReadKey;
    CloseGraph;
End.

