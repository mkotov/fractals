{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Thorn;
Uses Graph, Crt;
Type
   TComplex = Record
     X : Real;
     Y : Real;
   End;
Const
   iter = 15;
   max  = 400;
Var
   z, t, c : TComplex;
   p       : Real;
   x, y, n : Integer;
   gd, gm  : Integer;
   mx, my  : Integer;
   i       : Integer;
Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   For i:=0 To 15 Do SetPalette(i,i);
   For i:=0 To 15 Do SetRGBPalette(i,i*4,i*4,i*4);
   Mx := GetMaxX div 2;
   My := GetMaxY div 2;
   For y := -my to my do
      For x := -mx to mx do Begin
         n := 0;
         z.x := X * 0.01;
         z.y := Y * 0.01;
         c.x := 1; {<-- -->}
         c.y := 1; {<-- -->}
         While (sqr(z.x) + sqr(z.y) < max) and (n < iter) Do Begin
            t := z;
            Z.X := t.x/cos(t.y) + c.x;
            Z.Y := t.y/cos(t.x) + c.y;
            Inc(n);
         End;
            PutPixel(mx + x, my + y, n);
         If KeyPressed Then Break;
      End;
   Readkey;
   CloseGraph;
End.
