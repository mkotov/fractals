{$N+}
Program PascalMod2;
Uses Crt, Graph;
Const
  max=31;
Var
  n, i: Integer;
  gd,gm: Integer;
Function Fact(m: Integer): Real; {m!}
Var
  j: Integer;
  s: Real;
Begin
  s:=1;
  For j:=1 to m do s:=s*j;
  Fact:=s;
End;
Function BinomCoeff(m, k: Integer): Integer;
Begin
  BinomCoeff:=Round(Fact(m)/Fact(k)/Fact(m-k));
End;
Begin
  gd:=Detect;
  InitGraph(gd, gm, 'c:\bp\bgi');
  SetColor(15);
  For n:=0 to max do Begin
    For i:=0 to n do Begin
    If BinomCoeff(n,i) mod 2 = 0 Then OutTextXY(n*8, i*8,' ') Else OutTextXY(n*8, i*8,'*');
    End;
  End;
  ReadKey;
  CloseGraph;
End.