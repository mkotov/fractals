{***************************************}
{*    name: Последовательность Морса   *}
{*  author: Kotov Dmitry, Kotov Matvey *}
{*  e-mail: ikot@mail.ru               *}
{*    date: 11.08.05                   *}
{*            (c)iK - 2005             *}
{***************************************}
Program tm;
Uses CRT;
Var
  i,j: Integer;
  pow: Integer;
  a: Integer;
  mt: Array [0..512] of Boolean;
Begin
  clrscr;
  mt[0]:=false;
  For i:=0 to 8 do Begin
    pow:=Round(exp(i*ln(2)));
    For j:=0 to pow do mt[j+pow]:=not mt[j];
  End;
  For i:=0 to 63 Do If mt[i] Then Write(1) Else Write(0);
  ReadKey;
End.