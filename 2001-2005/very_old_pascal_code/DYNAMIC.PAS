{***************************************}
{*    name: Dynamic                    *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{*    date: 29.11.04                   *}
{*            (c)iK - 2004             *}
{***************************************}
Program Dynamic;
Uses CRT, Graph;
Const
  a = 1;
  b = 3;
  dt= 0.1;
Var
  gd, gm:  Integer;
  i, j, k: Integer;
  x, y, t: Real;
Begin
  gd:=Detect;
  InitGraph(gd,gm,'c:\bp\bgi');
  For i:=0 To 65 Do For j:=0 To 50 Do Begin
    x:=i;
    y:=j;
    For k:=1 To 100 Do Begin
      t:=x;
      y:=y + sin(x+a*sin(b*x))*dt;   {trig}
      x:=t - sin(y+a*sin(b*y))*dt;   {trig}
      PutPixel(Round(x*10), Round(y*10), (i+j) mod 16);
    End;
  End;
  ReadKey;
  CloseGraph;
End.