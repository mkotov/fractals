{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Brown;
Uses Crt, Graph;
Var
   GD, GM, X, Y, dX, dY, I: Integer;
Begin
   GD:=Detect;
   InitGraph(GD, GM, 'c:\bp\bgi');
   X:=639 div 2;
   Y:=470 div 2;
   MoveTo(X,Y);
   Repeat
      dX:=Random(3)-1;
      dY:=Random(3)-1;
      If (X+dX <   0) Then X:=X-dX Else X:=X+dX;
      If (X+dX > 640) Then X:=X-dX Else X:=X+dX;
      If (Y+dY <   0) Then Y:=Y-dY Else Y:=Y+dY;
      If (Y+dY > 480) Then Y:=Y-dY Else Y:=Y+dY;
      LineTo(X,Y);
      For I:=1 To 100 Do PutPixel(Random(640),Random(480),0);{}
      SetColor(15)
   Until KeyPressed;
   CloseGraph
End.
