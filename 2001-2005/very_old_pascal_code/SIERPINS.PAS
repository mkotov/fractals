{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Sierp;
Uses Graph, Crt;
Type
   TComplex = Record
     X : Real;
     Y : Real;
   End;
Const
   iter = 50;
   max  = 127;
Var
   z : TComplex;
   x, y, n : Integer;
   gd, gm  : Integer;
   mx, my  : Integer;
Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   Mx := GetMaxX div 2;
   My := GetMaxY div 2;
   For y := -my to my do
      For x := -mx to mx do Begin
         n := 0;
         z.x := X * 0.005;
         z.y := Y * 0.005;
         While (sqr(z.x) + sqr(z.y) < max) and (n < iter) do Begin
           If z.y>0.5 Then Begin
             z.x:=2*z.x;
             z.y:=2*z.y-1;
           End Else
           If z.x>0.5 Then Begin
             z.x:=2*z.x-1;
             z.y:=2*z.y;
           End Else
           Begin
             z.x:=2*z.x;
             z.y:=2*z.y;
           End;
           Inc(n);
         End;
            PutPixel(mx + x,my + y,16 - (n mod 16));
         If KeyPressed Then Break;
      End;
   Readkey;
   CloseGraph;
end.
