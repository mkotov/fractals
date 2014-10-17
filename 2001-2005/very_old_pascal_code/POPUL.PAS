{***************************************}
{*    name: Bifurcation                *}
{*   autor: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{*    date: 18.11.2004                 *}
{*            (c)iK - 2004             *}
{***************************************}
program Popul;
Uses CRT, Graph;
Var
   gd,gm: Integer;
   x, a: Real;
Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   x:=0.6;
   a:=2.7;
   Repeat
     x:=a*x*(1-x);
     PutPixel(Round(x*640),Round((a-2.8)*400),1);
     a:=a+0.000001;
   Until a>=4;
   ReadKey;
   CloseGraph;
End.