{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

Program Standard_Map;
Uses Graph, Crt;
Const
  K = 1.04295;
Var
   t0     : Real;
   gd, gm : Integer;

Function Mod2Pi(x:Real):Real;
Begin
  If x<0 Then x:=x+2*pi;
  Mod2pi:=Frac(x/(2*pi))*2*pi;
End;

Procedure Drw1(x, y: Real);
Var
  t: Real;
  i: Integer;
Begin
  For i:=1 To 1000 Do Begin
    t:=x;
    x:=Mod2Pi(x + K*sin(y));
    y:=Mod2Pi(y + x);
    PutPixel(Round(x*460/(2*pi))+10, Round(y*460/(2*pi))+10, 14);
  End;
End;

Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   SetColor(1); Rectangle(9, 9, 471, 471);
   t0:=0;
   Repeat
     Drw1(t0, 0);
     Drw1(0, t0);
     t0:=t0 + 0.1;
   Until t0 > 2*pi;
   Readkey;
   CloseGraph;
End.

