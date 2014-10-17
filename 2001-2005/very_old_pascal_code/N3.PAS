{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program N3;
Uses Graph, Crt;
Type
   TComplex = Record
     X : Real;
     Y : Real;
   End;
Const
   iter = 50;
   max  = 1e+6;
   min  = 1e-6;
Var
   z, t, d : TComplex;
   p       :  Real;
   x, y, n : Integer;
   Cancel  : Boolean;
   gd, gm  : Integer;
   mx, my  : Integer;
Begin
   Cancel := False;
   Randomize;
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   Mx := GetMaxX div 2;
   My := GetMaxY div 2;
   For y := -my to my do
      For x := -mx to mx do Begin
         n := 0;
         z.x := X * 0.005;
         z.y := Y * 0.005;
         d := z;
         While (sqr(z.x)+sqr(z.y) < max) and (sqr(d.x)+sqr(d.y) > min)
              and (n < iter) do Begin
            t := z;
            {z^3 - 1}
            p := sqr(sqr(t.x)+sqr(t.y));
            z.x := 2/3*t.x + (sqr(t.x)-sqr(t.y))/(3*p);
            z.y := 2/3*t.y*(1-t.x/p);{}
            d.x := abs(t.x - z.x);
            d.y := abs(t.y - z.y);
            Inc(n);
            If keypressed then cancel := true;
         End;
            PutPixel(mx + x,my + y,16 - (n mod 16));
         If cancel then exit;
      End;
   Readkey;
   CloseGraph;
end.
