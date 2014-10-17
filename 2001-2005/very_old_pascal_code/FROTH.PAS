{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Froth;
Uses Graph, CRT;
Type
   TComplex=Record
     x: Real;
     y: Real;
   end;
Const
   iter = 50;
   max = 16;
Var
   z,z1,c: TComplex;
   x,y,n : Integer;
   Cancel: Boolean;
   gd,gm : Integer;
   mx, my: Integer;

Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   Cancel:=False;
   mx:=GetMaxX div 2;
   my:=GetMaxY div 2;
   For y:=-my to mx do
      For x:=-mx to mx do Begin
         n:=0;
         z.X:=X*0.01;
         z.Y:=Y*0.01;
         c.X:=1;
         c.Y:=1.02871;
         While ((sqr(z.x) + sqr(z.y)) < max) and (n < iter) do Begin
            z1:=z;
            z.x:=sqr(z1.x) - sqr(z1.y) - c.x * (z1.x + z1.y);
            z.y:=2 * z1.x * z1.y - c.y * (z1.x - z1.y);
            Inc(n);
            If KeyPressed Then Cancel:=True;
         End;
         If n=iter then PutPixel(mx + x, my + y, Round((sqr(z.x) + sqr(z.y))*10));{}
         If Cancel Then Exit;
      End;
   ReadKey;
   CloseGraph;
End.