{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Vetka2;
Uses Graph, CRT;
Const
  min = 1;
Var
 gd, gm : Integer;

Procedure lineto1(x, y : Integer; l, u : real);
Begin
   Line(x, y, Round(x + l * cos(u)), Round(y - l * sin(u)));
End;

Procedure Draw(x, y : Integer; l, u : real);
Begin
   If KeyPressed then exit;
   If l > min then Begin
      lineto1(x, y, l, u);
      x := Round(x + l * cos(u));
      y := Round(y - l * sin(u));
      Draw(x, y, l*0.4, u - pi/4);
      Draw(x, y, l*0.4, u + pi/4);
      Draw(x, y, l*0.7, u);
   End;
End;

Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   Draw(320, 460, 120, pi/2);
   ReadKey;
   CloseGraph;
End.
