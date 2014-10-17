{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2005             *}
{************************************}

program JStar;
Uses CRT, Graph;
Const
   C = 0; {0..2}
Var
   gd,gm : Integer;
   i, n, ix, iy : Integer;
   s : Integer;
   x, y, x1, y1, xa, ya, r, w: Real;

Begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   x:=0.5;
   y:=0.00001;
   w:=0;
   While not KeyPressed Do Begin
      Case C Of
      0: Begin
           xa := -4 * x + cos(4 * w);
           ya := -4 * y + sin(4 * w);
         End;
      1: Begin
           xa := -4 * x + 1;
           ya := -4 * y;
         End;
      2: Begin
           xa := -4 * x + cos(w);
           ya := -4 * y + sin(w);
         End;
      End;
      r := sqrt(xa*xa + ya*ya);
    w:=arctan(abs(ya/xa));
    If (ya>0)and(xa<0) then w:=pi-w Else
    If (ya<0)and(xa<0) then w:=w+pi Else
    If (ya<0)and(xa>0) then w:=-w;
      case C Of
         0: Begin
         if (random< 0.5) Then Begin
            x1 := - cos(w) - sqrt(r) * cos(w/2) / 2;
            y1 := - sin(w) + sqrt(r) * sin(w/2) / 2;
         End else Begin
            x1 := - cos(w) + sqrt(r) * cos(w/2) / 2;
            y1 := - sin(w) - sqrt(r) * sin(w/2) / 2;
         End;
      End;
      1: Begin
         s := 2 * (Round(random*2)) - 1;
         if (Random<0.5) Then Begin
            x1 := - s * cos(w) - sqrt(r) * cos(w/2) / 2;
            y1 :=   s * sin(w) - sqrt(r) * sin(w/2) / 2;
         End else Begin
            x1 := - s * cos(w) + sqrt(r) * cos(w/2) / 2;
            y1 :=   s * sin(w) + sqrt(r) * sin(w/2) / 2;
         End;
       End;
       2: Begin
         if (Random <0.5) Then Begin
            x1 := - cos(2*w) - sqrt(r) * cos(w/2) / 2;
            y1 := - sin(2*w) + sqrt(r) * sin(w/2) / 2;
         End else Begin
            x1 := - cos(2*w) + sqrt(r) * cos(w/2) / 2;
            y1 := - sin(2*w) - sqrt(r) * sin(w/2) / 2;
         End;
      End;
      End;
      x := x1;
      y := y1;
      ix := Round(x * 100) + 320;
      iy := Round(y * 100) + 240;
      PutPixel(ix, iy, 1);
   End;
   ReadKey;
   CloseGraph;
End.