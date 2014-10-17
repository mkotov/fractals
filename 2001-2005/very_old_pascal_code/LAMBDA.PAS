{***************************************}
{*    name: Lambda                     *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{* comment: No comment                 *}
{*    date: 2.08.05                    *}
{*            (c)iK - 2005             *}
{***************************************}
Program Lambda;
Uses Graph, Crt;
Type
   TComplex = Record
     X : Real;
     Y : Real;
   End;
Const
   iter = 30;
   max  = 100;
Var
   z, c    : TComplex;
   p, q    : Real;
   x, y, n : Integer;
   gd, gm  : Integer;
   mx, my  : Integer;
Begin
   Randomize;
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   Mx := GetMaxX div 2;
   My := GetMaxY div 2;
   For y := -my to my do
      For x := -mx to mx do Begin
         n := 0;
         c.x := X * 0.01 + 1;
         c.y := Y * 0.01;
         z.x := 0.5;
         z.y := 0;
         While (sqr(z.x) + sqr(z.y) < max) and (n < iter) do Begin
            p := z.x - sqr(z.x) + sqr(z.y);
            q := z.y - 2*z.x*z.y;
            z.x := c.x*p - c.y*q;
            z.y := c.x*q + c.y*p;
            Inc(n);
            If KeyPressed then Exit;
         End;
         If n < 30 then PutPixel(mx + x,my + y,n mod 16)
      End;
   Readkey;
   CloseGraph;
End.
