--------------------------------------------------------
--  DDL for Procedure ADMISSION
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "PROJECT"."ADMISSION" 
(yr IN NUMBER,
a OUT NUMBER,
b OUT NUMBER,
c OUT NUMBER,
d OUT NUMBER,
e OUT NUMBER,
f OUT NUMBER)
is
begin
select count(rollno) into a from student where year = yr and branch = 'CE';
select count(rollno) into b from student where year = yr and branch = 'CSE';
select count(rollno) into c from student where year = yr and branch = 'EE';
select count(rollno) into d from student where year = yr and branch = 'EL';
select count(rollno) into e from student where year = yr and branch = 'ME';
select count(rollno) into f from student where year = yr and branch = 'IT' ;

end;

/
