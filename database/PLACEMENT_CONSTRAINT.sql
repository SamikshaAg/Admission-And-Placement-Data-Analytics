--------------------------------------------------------
--  Constraints for Table PLACEMENT
--------------------------------------------------------

  ALTER TABLE "PROJECT"."PLACEMENT" ADD CONSTRAINT "PLACEMENT_PK" PRIMARY KEY ("ROLL", "ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PROJECT"."PLACEMENT" MODIFY ("ROLL" NOT NULL ENABLE);
 
  ALTER TABLE "PROJECT"."PLACEMENT" MODIFY ("ID" NOT NULL ENABLE);