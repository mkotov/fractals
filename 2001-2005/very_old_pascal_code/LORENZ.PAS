{***************************************}
{*    name: Lorenz's Attactor          *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{* comment: No comment                 *}
{*    date: 27.11.2004                 *}
{*            (c)iK - 2004             *}
{***************************************}

Program Lorenz;
Uses CRT, Graph;
Const
  x: Real = 3.051522;
  y: Real = 1.582542;
  z: Real = 15.62388;
  dt = 0.0001;
  a = 5;
  b = 15;
  c = 1;
Var
  gd, gm: Integer;
  x1, y1, z1: Real;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  While not KeyPressed Do Begin
    x1 := x + a*(-x+y)*dt;
    y1 := y + (b*x-y-z*x)*dt;
    z1 := z + (-c*z+x*y)*dt;
    x := x1;
    y := y1;
    z := z1;
    PutPixel(Round(19.3*(y - x*0.292893) + 320),
             Round(-11*(z + x*0.292893) + 392), 9);
    End;
    CloseGraph;
    ReadKey;
End.


