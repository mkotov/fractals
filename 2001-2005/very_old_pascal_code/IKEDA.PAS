{*******************************************}
{*    name: Ikeda                          *}
{*  author: Kotov Dmitry, Kotov Matvey     *}
{*  e-mail: ikot@mail.ru                   *}
{* comment: z'=a+b*z*exp[i(k-p/(1+|z^2|))] *}
{*    date: 07.01.2005                     *}
{*            (c)iK - 2005                 *}
{*******************************************}
Program Ikeda;
Uses CRT, Graph;
Const
  a=0.85;
  b=0.9;
  k=0.4;
  p=7.7;
Var
  x, y: Real; { =z }
  u, v: Real;
  r: Real;
  gd, gm: Integer;
  i : Integer;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  x:=0; y:=0; u:=0; v:=0;
  For i:=0 to 30000 do Begin
    r:= k - p / (1 + sqrt(sqr(x*x-y*y)+sqr(2*x*y)));
    u:= a + b*(x*cos(r)-y*sin(r));
    v:= b*(x*sin(r)+y*cos(r));
    PutPixel(Round(u*180)+240, Round(v*180)+280, 14);
    x:=u; y:=v;
  End;
  ReadKey;
  CloseGraph;
End.