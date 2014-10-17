{******************************}
{*   name: Kineskop           *}
{*  autor: Kotov D., Kotov M. *}
{*   date: 14.11.2004         *}
{* e-mail: ikot@mail.ru       *}
{*comment: no comment         *}
{*        (c)iK - 2004        *}
{******************************}
Program Kineskop;
Uses Graph, Crt;
Const
   min = 1;
   l0  = 300;
   da  = pi/20;
   x0  = 320;
   y0  = 240;
Var
   gd, gm: Integer;
   x, y  : Integer;
   l     : Real;
   a     : Real;
Procedure Rectangle_(d, u: Real);
Var
  x1, y1: Integer;
  x2, y2: Integer;
  x3, y3: Integer;
  x4, y4: Integer;
Begin
  x1:=Round(x0 + d * cos(u +   pi/4));
  y1:=Round(y0 + d * sin(u +   pi/4));
  x2:=Round(x0 + d * cos(u + 3*pi/4));
  y2:=Round(y0 + d * sin(u + 3*pi/4));
  x3:=Round(x0 + d * cos(u + 5*pi/4));
  y3:=Round(y0 + d * sin(u + 5*pi/4));
  x4:=Round(x0 + d * cos(u + 7*pi/4));
  y4:=Round(y0 + d * sin(u + 7*pi/4));
  Line(x1, y1, x2, y2);
  Line(x2, y2, x3, y3);
  Line(x3, y3, x4, y4);
  Line(x4, y4, x1, y1);
End;

Begin
   gd := Detect;
   InitGraph(gd, gm, 'c:\bp\bgi');
   SetColor(14);
   l:=l0;
   a:=0;
   Repeat
     Rectangle_(l, a);
     a:=a + da;
     l:=l * sin(pi/4) / sin(3*pi/4 - da);
   Until (l <= min) or (KeyPressed);
   Readkey;
   CloseGraph;
end.
