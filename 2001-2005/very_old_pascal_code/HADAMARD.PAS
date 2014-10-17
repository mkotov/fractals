Program Hadamard;
Uses CRT, Graph;
Const
  n=5; {<- ->}
  m=2; {2, 3}
Var
  gd, gm: Integer;
  i, j, k: Integer;
  sum: Integer;
  b: Array[0..639, 0..n] of Byte;
Begin
  gd:=detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
   For i:=0 To 639 Do Begin
      k := 1;
      For j:=0 To n Do Begin
         b[i][j] := (Round(i/k) mod m) mod 2;
         k := k*3;
      End;
   End;
   For i:=0 to 639 Do Begin
     For j:=0 to 479 do Begin
         sum := 0;
         For k:=0 To n Do Begin
            sum := sum+b[i][k]*b[j][k];
         If sum > 0 Then PutPixel(i,j,sum);
      End;
   End;
  End;
  ReadKey;
  CloseGraph;
End.


