

-- Generated by Relational Schema Center on Tue Jul 04 13:43:11 MSD 2006 for Informix Dynamic Server, V9.4

   
CREATE DATABASE july;

CREATE SCHEMA AUTHORIZATION informix;

CREATE TABLE informix.CFGBASESTATION
  (SAVCONFIGID INTEGER NOT NULL,
   EQUIPMENT INTEGER NOT NULL,
   CONTROLLER INTEGER,
   TYPE1 CHARACTER VARYING(100));

ALTER TABLE informix.CFGBASESTATION ADD CONSTRAINT
  (PRIMARY KEY (SAVCONFIGID, EQUIPMENT) CONSTRAINT PK_CFGBASESTATION);