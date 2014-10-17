Program Plazma;
Uses CRT,Graph;
var
  plasma: array [0..318, 0..198] of byte;
  x, y, j: integer;
  gd,gm : Integer;
Procedure RGB(N, R, G, B:Word);
Begin
    Port[$3c8]:=n;
    Port[$3c9]:=R div 4;
    Port[$3c9]:=G div 4;
    Port[$3c9]:=B div 4;
End;

procedure makeplasma;
  procedure halfway(x1,y1,x2,y2: integer);
    procedure adjust(xa,ya,x,y,xb,yb: integer);
    var
      d: integer;
      v: Real;
    begin
      if plasma[x,y]<>0 then
        exit;
      d:=Abs(xa-xb)+Abs(ya-yb);
      v:=(plasma[xa,ya]+plasma[xb,yb])/2+(random-0.5)*d*2;
      if v<1 then
        v:=1;
      if v>=255 then
        v:=255;
      plasma[x,y]:=Trunc(v);
    end;

  var
    x, y: integer;
    v: Real;
  begin
    if (x2-x1<2) and (y2-y1<2) then
      exit;
    x:=(x1+x2) div 2;
    y:=(y1+y2) div 2;
    adjust(x1,y1,x,y1,x2,y1);
    adjust(x2,y1,x2,y,x2,y2);
    adjust(x1,y2,x,y2,x2,y2);
    adjust(x1,y1,x1,y,x1,y2);
    if plasma[x,y]=0 then
    begin
      v:=(plasma[x1,y1]+plasma[x2,y1]+plasma[x2,y2]+plasma[x1,y2])/4;
      plasma[x,y]:=Trunc(v);
    end;
    halfway(x1,y1,x,y);
    halfway(x,y1,x2,y);
    halfway(x,y,x2,y2);
    halfway(x1,y,x,y2);
  end;

var
  x, y: integer;
begin
  randomize;
  plasma[0,198]:=random(190);
  plasma[318,198]:=random(190);
  plasma[318,0]:=random(190);
  plasma[0,0]:=random(190);
  halfway(0,0,318,198);
end;

Begin
  asm
    mov ax ,13h
    int 10h
  end;
   For J:=0 To 43 Do RGB(0+  j,255, j*6, 0);
   For J:=0 To 43 Do RGB(43 +j,255-j*6, 255, 0);
   For J:=0 To 43 Do RGB(86 +j,0, 255, j*6);
   For J:=0 To 43 Do RGB(129+j,0, 255-j*6, 255);
   For J:=0 To 43 Do RGB(172+j,j*6, 0, 255);
   For J:=0 To 40 Do RGB(215+j,255, 0, 255-j*6);

  makeplasma;
  for x := 0 to 318 do
    for y := 0 to 198 do
      Mem[$0a000:(y)*320+(x)] := plasma[x, y];
  readkey;

End.
