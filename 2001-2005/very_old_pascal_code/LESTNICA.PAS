{***************************************}
{*    name: Chertova lestnica          *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{* comment: No comment                 *}
{*    date: 2.08.05                    *}
{*            (c)iK - 2005             *}
{***************************************}

Uses Crt, Graph;
Const
  max = 2187;
Var
   gd, gm : Integer;
   C      : Array [0..max] of Integer;
   i      : Integer;
   x, y   : Integer;

Procedure Draw(x: Integer; L: Word);
Var
  s : Word;
Begin
  If L > 0 then Begin
    s := L div 3;
    Draw(x, s);
    Draw(x + 2*L, s);
  End
  Else C[x]:=1;
End;

Begin
  gd := Detect;
  For i:=0 to max do C[i]:=0;
  InitGraph(gd,gm,'c:\bp\bgi');
  Draw(0, max);
  For i:=1 to max do C[i]:=C[i-1]+c[i];
  For i:=0 to max do Begin
    x := Round(i/max*639);
    y := Round(C[i]/C[max]*479);
    Line(x, 479, x, 479 - y);
  End;
  ReadKey;
  CloseGraph;
End.
