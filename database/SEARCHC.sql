--------------------------------------------------------
--  DDL for Procedure SEARCHC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "PROJECT"."SEARCHC" 
(
i IN NUMBER,
ce_12 OUT NUMBER,
cs_12 OUT NUMBER,
ee_12 OUT NUMBER,
el_12 OUT NUMBER,
me_12 OUT NUMBER,
it_12 OUT NUMBER,
ce_13 OUT NUMBER,
cs_13 OUT NUMBER,
ee_13 OUT NUMBER,
el_13 OUT NUMBER,
me_13 OUT NUMBER,
it_13 OUT NUMBER,
ce_14 OUT NUMBER,
cs_14 OUT NUMBER,
ee_14 OUT NUMBER,
el_14 OUT NUMBER,
me_14 OUT NUMBER,
it_14 OUT NUMBER
)AS 
BEGIN
 select count(roll)into ce_12 from placement where id=i and roll like '121%';
 select count(roll)into cs_12 from placement where id=i and roll like '122%';
 select count(roll)into ee_12 from placement where id=i and roll like '123%';
 select count(roll)into el_12 from placement where id=i and roll like '124%';
 select count(roll)into me_12 from placement where id=i and roll like '125%';
 select count(roll)into it_12 from placement where id=i and roll like '126%';


 select count(roll)into ce_13 from placement where id=i and roll like '131%';
 select count(roll)into cs_13 from placement where id=i and roll like '132%';
 select count(roll)into ee_13 from placement where id=i and roll like '133%';
 select count(roll)into el_13 from placement where id=i and roll like '134%';
 select count(roll)into me_13 from placement where id=i and roll like '135%';
 select count(roll)into it_13 from placement where id=i and roll like '136%';
 
 select count(roll)into ce_14 from placement where id=i and roll like '141%';
 select count(roll)into cs_14 from placement where id=i and roll like '142%';
 select count(roll)into ee_14 from placement where id=i and roll like '143%';
 select count(roll)into el_14 from placement where id=i and roll like '144%';
 select count(roll)into me_14 from placement where id=i and roll like '145%';
 select count(roll)into it_14 from placement where id=i and roll like '146%';

END SEARCHC;

/
