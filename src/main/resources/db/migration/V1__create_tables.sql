CREATE TABLE country (
  Code CHAR(3) NOT NULL,
  Name VARCHAR(52) NOT NULL,
  Continent VARCHAR(50) NOT NULL DEFAULT 'Co-administrated',
  Region VARCHAR(26) NOT NULL,
  Surfacearea DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  Indepyears SMALLINT DEFAULT NULL,
  Population INT NOT NULL DEFAULT 0,
  Lifeexpectancy DECIMAL(3,1) DEFAULT NULL,
  GNP DECIMAL(10,2) DEFAULT NULL,
  GNPOld DECIMAL(10,2) DEFAULT NULL,
  Localname VARCHAR(45) NOT NULL DEFAULT 'No-Name',
  Government VARCHAR(45) NOT NULL DEFAULT 'Co-administrated',
  Leader VARCHAR(60) DEFAULT NULL ,
  Capital INT DEFAULT NULL,
  Code2 CHAR(2) NOT NULL,
  PRIMARY KEY (Code)
);

CREATE TABLE city (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(35) NOT NULL,
  Countrycode CHAR(3) NOT NULL,
  District VARCHAR(50) NOT NULL,
  Population INT NOT NULL,
  CONSTRAINT FK_City_Country FOREIGN KEY (CountryCode) REFERENCES country (Code)
);

CREATE TABLE countrylanguage (
  Countrycode CHAR(3) NOT NULL,
  Language VARCHAR(30) NOT NULL,
  Isofficial CHAR(1) NOT NULL DEFAULT 'F',
  Percentage DECIMAL(4,1) NOT NULL DEFAULT 0.0,
  PRIMARY KEY (Countrycode, Language),
  CONSTRAINT FK_CountryLanguage_Country FOREIGN KEY (Countrycode) REFERENCES country (Code)
);
