{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program J2;
Uses Graph, Crt;
Type
   TComplex = Record
     X : Real;
     Y : Real;
   End;
Const
   iter = 50;
   max  = 16;
Var
   z, t, c : TComplex;
   p       : Real;
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
         c.x := 0.11;
         c.y := -0.66;
         While (sqr(z.x) + sqr(z.y) < max) and (n < iter) do Begin
            t := z;
            {z^2 + c}
            Z.X := sqr(t.x) - sqr(t.y);
            Z.Y := 2*t.x*t.y;{}
            {z^3 + c}
            {Z.X := t.x*t.x*t.x - 3*t.x*t.y*t.y + c.x;
            Z.Y := 3*t.x*t.x*t.y - t.y*t.y*t.y + c.y;{}
            {z^4 + c}
            {Z.X := t.x*t.x*t.x*t.x + t.y*t.y*t.y*t.y - 6*t.x*t.x*t.y*t.y + c.x;
            Z.Y := 4*t.x*t.x*t.x*t.y - 4*t.x*t.y*t.y*t.y + c.y;{}
            {1/z^2 + c}
            {p:=sqr(sqr(t.x)+sqr(t.y));
            if p<>0 Then Begin
              Z.X := (sqr(t.x)-sqr(t.y))/p;
              Z.Y := -2*t.x*t.y/p;
            End;          {}
            z.x:=z.x+c.x;
            z.y:=z.y+c.y;{}

            Inc(n);
            If keypressed then cancel := true;
         End;
         If n < iter then Begin
            PutPixel(mx + x,my + y,16 - (n mod 16));
         End;
         If cancel then exit;
      End;
   Readkey;
   CloseGraph;
end.
