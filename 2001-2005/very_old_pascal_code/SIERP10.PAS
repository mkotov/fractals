{***************************************}
{*    name: tr Sierpinsky              *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{*    date: 22.11.2004                 *}
{*            (c)iK - 2004             *}
{***************************************}
Program Sierp10;
Uses CRT, Graph;
Var
  gd, gm: Integer;
  l, x, y: Real;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=0; y:=0;
  Randomize;
  While not Keypressed Do Begin
    l:=2/3*pi*random(3);
    x:=x/2+cos(l);
    y:=y/2+sin(l);
    PutPixel(320 + Round(x*130), 240 + Round(y*130), 14);
  End;
  Readkey;
  CloseGraph;
End.

