--------------------------------------------------------
--  Ref Constraints for Table PLACEMENT
--------------------------------------------------------

  ALTER TABLE "PROJECT"."PLACEMENT" ADD CONSTRAINT "PLACEMENT_FK1" FOREIGN KEY ("ROLL")
	  REFERENCES "PROJECT"."STUDENT" ("ROLLNO") ENABLE;
 
  ALTER TABLE "PROJECT"."PLACEMENT" ADD CONSTRAINT "PLACEMENT_FK2" FOREIGN KEY ("ID")
	  REFERENCES "PROJECT"."COMPANY" ("CID") ENABLE;
