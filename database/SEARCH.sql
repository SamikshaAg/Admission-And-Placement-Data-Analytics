--------------------------------------------------------
--  DDL for Procedure SEARCH
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "PROJECT"."SEARCH" 
(
srch IN varchar2,
c_company OUT sys_refcursor,
s_student OUT sys_refcursor
)AS 
BEGIN
open s_student for SELECT rollno,name,branch,year,fathername,address,mobileno,email from student where name=srch;
open c_company for SELECT cid from company where cname=srch;
END SEARCH;

/
