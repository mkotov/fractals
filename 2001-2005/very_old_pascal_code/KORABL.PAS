{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Ship;
Uses Graph, Crt;
Type
   TComplex = Record
     X : Real;
     Y : Real;
   End;
Const
   iter = 30;
   max  = 16;
Var
   z, t, c : TComplex;
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
         c.x := X * 0.0025-0.2;
         c.y := Y * 0.0025-0.3;
         z.x := 0;
         z.y := 0;
         While (sqr(z.x) + sqr(z.y) < max) and (n < iter) do Begin
            t := z;
            Z.X := sqr(t.x) - sqr(t.y) + c.x;
            Z.Y := 2*abs(t.x*t.y) + c.y;
            z.x:=z.x+c.x;
            z.y:=z.y+c.y;
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
