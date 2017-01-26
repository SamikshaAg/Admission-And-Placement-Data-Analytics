--------------------------------------------------------
--  DDL for Procedure TOP_PERFORMER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "PROJECT"."TOP_PERFORMER" 
(
yr IN NUMBER,
cur OUT sys_refcursor
)AS 
BEGIN
open cur for SELECT distinct roll,id,package from placement where placedyear=yr order by package desc;
END TOP_PERFORMER;

/
