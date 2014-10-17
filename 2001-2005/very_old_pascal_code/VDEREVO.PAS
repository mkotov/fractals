{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Vderevo;
Uses Graph, CRT;
Const
  min = 3;
Var
 gd, gm : Integer;

Procedure lineto1(x, y : Integer; l, u : real);
Begin
   Line(x, y, Round(x + l * cos(u)), Round(y - l * sin(u)));
End;

Procedure Draw(x, y : Integer; l : real);
Begin
   If KeyPressed then exit;
   If l > min then Begin
      l := l * 0.5;
      lineto1(x, y, l,pi/4);
      lineto1(x, y, l,3*pi/4);
      Draw(Round(x - l * cos(pi/4)), Round(y- l * sin(pi/4)), l);
      Draw(Round(x + l * cos(pi/4)), Round(y- l * sin(pi/4)), l);
   End;
End;

Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   Draw(320, 380, 400);
   ReadKey;
   CloseGraph;
End.
