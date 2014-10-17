{************************************}
{*    Kotov Dmitry, Kotov Matvey    *}
{*       email: ikot@mail.ru        *}
{*         (c)iK - 2004             *}
{************************************}
Program Gilb;
uses Crt, Graph;
Const
  u=10;
  p=3;
var
  i: Integer;
  gd,gm : Integer;

procedure a(i: integer); forward;
procedure b(i: integer); forward;
procedure c(i: integer); forward;
procedure d(i: integer); forward;

procedure a(i: integer);
begin
  if i > 0 then
  begin
    d(i - 1);
    LineRel( + u, 0);
    a(i - 1);
    LineRel(0, u);
    a(i - 1);
    LineRel(-u, 0);
    c(i - 1);
  end;
end;

procedure b(i: integer);
begin
  if i > 0 then
  begin
    c(i - 1);
    LineRel(-u, 0);
    b(i - 1);
    LineRel(0, -u);
    b(i - 1);
    LineRel(u, 0);
    d(i - 1);
  end;
end;

procedure c(i: integer);
begin
  if i > 0 then
  begin
    b(i - 1);
    LineRel(0, -u);
    c(i - 1);
    LineRel(-u, 0);
    c(i - 1);
    LineRel(0, u);
    a(i - 1);
  end;
end;

procedure d(i: integer);
begin
  if i > 0 then
  begin
    a(i - 1);
    LineRel(0, u);
    d(i - 1);
    LineRel(u, 0);
    d(i - 1);
    LineRel(0, -u);
    b(i - 1);
  end;
end;

begin
   gd := Detect;
   InitGraph(gd,gm,'c:\bp\bgi');
   MoveTo(100, 100);
   a(p);
   ReadKey;
   CloseGraph;
end.