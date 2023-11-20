DROP DATABASE IF EXISTS PASSWORDMANAGER;

CREATE DATABASE IF NOT EXISTS PASSWORDMANAGER;
USE PASSWORDMANAGER;
# -----------------------------------------------------------------------------
#       TABLE : PASSWORD
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PASSWORD
 (
   IDPASSWORD INTEGER(2) NOT NULL AUTO_INCREMENT ,
   NAMEPASSWORD VARCHAR(128) NULL  ,
   PASSWORD TEXT NULL  ,
   CREATEDPASSWORD DATE NULL  
   , PRIMARY KEY (IDPASSWORD) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SITE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SITE
 (
   IDSITE INTEGER(2) NOT NULL AUTO_INCREMENT ,
   SITE CHAR(32) NULL  
   , PRIMARY KEY (IDSITE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : USE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS USE
 (
   IDPASSWORD INTEGER(2) NOT NULL  ,
   IDSITE INTEGER(2) NOT NULL  
   , PRIMARY KEY (IDPASSWORD,IDSITE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE USE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_USE_PASSWORD
     ON USE (IDPASSWORD ASC);

CREATE  INDEX I_FK_USE_SITE
     ON USE (IDSITE ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE USE 
  ADD FOREIGN KEY FK_USE_PASSWORD (IDPASSWORD)
      REFERENCES PASSWORD (IDPASSWORD) ;


ALTER TABLE USE 
  ADD FOREIGN KEY FK_USE_SITE (IDSITE)
      REFERENCES SITE (IDSITE) ;

