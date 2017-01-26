--------------------------------------------------------
--  DDL for Procedure TOP_COMPANY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "PROJECT"."TOP_COMPANY" 
(
yr IN NUMBER,
cur OUT sys_refcursor
)AS 
BEGIN
open cur for SELECT id ,avg(package) from placement where placedyear=yr group by id order by avg(package) desc;

END TOP_COMPANY;

/
