{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program DPif;
Uses Graph, CRT;
Const
  max = 3;
Var
 gd, gm : Integer;

Procedure lineto1(x, y : Integer; l, u : real);
Begin
   Line(x, y, Round(x + l * cos(u)), Round(y - l * sin(u)));
End;

Procedure Draw(x, y : Integer; l, u : real);
Begin
   If KeyPressed then exit;
   If l > max then Begin
      l := l * 0.7;
      lineto1(x, y, l, u);
      x := Round(x + l * cos(u));
      y := Round(y - l * sin(u));
      Draw(x, y, l, u + pi / 4);
      Draw(x, y, l, u - pi / 6);
   End;
End;

Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   Draw(320, 460, 200, pi/2);
   ReadKey;
   CloseGraph;
End.
