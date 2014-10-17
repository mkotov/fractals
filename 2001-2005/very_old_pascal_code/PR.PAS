{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Pr;
Uses Graph, CRT;
Const
  min = 2;
Var
 gd, gm : Integer;

Procedure Draw(x, y, l : Integer);
Begin
   If KeyPressed then exit;
   If l > min then Begin
      l := l div 2;
      SetFillStyle(1,1);
      Bar(x,y,x+l,y-l*2);
      SetFillStyle(1,15);
      Bar(x,y,x-l,y-l*2);
      Draw(x - l div 2, y - l, l);
      Draw(x + l div 2, y - l, l);
   End;
End;

Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   Draw(320, 350, 256);
   ReadKey;
   CloseGraph;
End.

