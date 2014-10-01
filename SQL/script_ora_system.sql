-- code � executer avec le compte system
CREATE SMALLFILLE TABLESPACE "TBS_GESTFESTI14" DATAFILE 'c:\ORADATA\BAZDEV14\FI01_TBSGESTFESTI14' SIZE 5M LOGGING EXTENT MANAGEMENT LOCAL SEGMENT SPACE MANAGEMENT AUTO;
CREATE user GESTFESTI14 IDENTIFIED BY mpgestfesti DEFAULT tablespace TBS_GESTFESTI TEMPORARY tablespace temp;
GRANT connect TO GESTFESTI14;
GRANT resource TO GESTFESTI14;