--------------------------------------------------------
--  DDL for Procedure BRNCHPRFM
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "PROJECT"."BRNCHPRFM" 
(yr IN NUMBER,
p OUT NUMBER,
q OUT NUMBER,
r OUT NUMBER,
s OUT NUMBER,
t OUT NUMBER,
u OUT NUMBER)
is
begin
declare
type asd is varray(6) of number;
ar asd;
br asd;
begin
ar :=asd(0,0,0,0,0,0);
br :=asd(0,0,0,0,0,0);
if(yr=2016)
then
select count(distinct roll) into ar(1) from placement where roll like '121%';
select count(distinct roll) into ar(2) from placement where roll like '122%';
select count(distinct roll) into ar(3) from placement where roll like '123%';
select count(distinct roll) into ar(4) from placement where roll like '124%';
select count(distinct roll) into ar(5) from placement where roll like '125%';
select count(distinct roll) into ar(6) from placement where roll like '126%';
admission(2012,br(1),br(2),br(3),br(4),br(5),br(6));

elsif(yr=2017) then
select count(distinct roll) into ar(1) from placement where roll like '131%';
select count(distinct roll) into ar(2) from placement where roll like '132%';
select count(distinct roll) into ar(3) from placement where roll like '133%';
select count(distinct roll) into ar(4) from placement where roll like '134%';
select count(distinct roll) into ar(5) from placement where roll like '135%';
select count(distinct roll) into ar(6) from placement where roll like '136%';
admission(2013,br(1),br(2),br(3),br(4),br(5),br(6));
else 

select count(distinct roll) into ar(1) from placement where roll like '141%';
select count(distinct roll) into ar(2) from placement where roll like '142%';
select count(distinct roll) into ar(3) from placement where roll like '143%';
select count(distinct roll) into ar(4) from placement where roll like '144%';
select count(distinct roll) into ar(5) from placement where roll like '145%';
select count(distinct roll) into ar(6) from placement where roll like '146%';
admission(2014,br(1),br(2),br(3),br(4),br(5),br(6));
end if;

p := ar(1)/br(1);
q := ar(2)/br(2);
r := ar(3)/br(3);
s := ar(4)/br(4);
t := ar(5)/br(5);
u := ar(6)/br(6);

end;
end;

/
