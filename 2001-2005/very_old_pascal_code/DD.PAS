{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program DD;
Uses Graph, CRT;
Const
  min = 1;
Var
 gd, gm : Integer;

Procedure Draw(x, y, l : Integer);
Begin
   If KeyPressed then exit;
   If l > min then Begin
      l := l div 2;
      line(x, y, x, y - l);
      line(x, y - l, x - l, y - l);
      line(x, y - l, x + l, y - l);
      Draw(x - l, y - l, l);
      Draw(x + l, y - l, l);
   End;
End;

Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   Draw(320, 460, 300);
   ReadKey;
   CloseGraph;
End.

