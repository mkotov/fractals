{***************************************}
{*    name: Rossler Attactor           *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{* comment: No comment                 *}
{*    date: 02.08.2005                 *}
{*            (c)iK - 2005             *}
{***************************************}

Program Rossler;
Uses CRT, Graph;
Const
  x: Real = 3.051522;
  y: Real = 1.582542;
  z: Real = 15.62388;
  dt = 0.0001;
  a = 0.2;
  b = 0.2;
  c = 5.7;
Var
  gd, gm: Integer;
  x1, y1, z1: Real;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  While not KeyPressed Do Begin
    x1 := x + (-y-z)*dt;
    y1 := y + (x+a*y)*dt;
    z1 := z + (b+z*(x-c))*dt;
    x := x1;
    y := y1;
    z := z1;
    PutPixel(Round(19.3*(y - x*0.292893) + 320),
             Round(-11*(z + x*0.292893) + 392), 9);
    End;
    CloseGraph;
    ReadKey;
End.


