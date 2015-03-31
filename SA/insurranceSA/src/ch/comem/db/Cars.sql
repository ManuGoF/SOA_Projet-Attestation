CREATE TABLE Cars (
    SERIAL_NUMBER VARCHAR(50) NOT NULL,
    BRAND VARCHAR(20) NOT NULL,
    MODEL VARCHAR(50) NOT NULL,
    TYPE VARCHAR(50) NOT NULL,
    COLOR VARCHAR(20) NOT NULL,
    PRICE DOUBLE NOT NULL,
    CLIENT_ID INTEGER NOT NULL, 
    PRIMARY KEY (SERIAL_NUMBER)
);

INSERT INTO Cars (SERIAL_NUMBER, BRAND, MODEL, TYPE, COLOR, PRICE, CLIENT_ID)
    VALUES
    ('VF7 X2R FVF 7200 1110', 'AUDI', 'A3 1.4 TFSI Ambiente', 'Limousine', 'BLACK', 44000, 2001),
    ('VF7 X2R FVF 7200 2120', 'BMW', 'X4 xDrive 20d xLine', 'Limousine', 'BLUE', 63200, 2002),
    ('VF7 X2R FVF 7200 3130', 'OPEL', 'Antara 2.0 CDTi Cosmo 4WD', 'Limousine', 'RED', 48050, 2003),
    ('VF7 X2R FVF 7200 4140', 'VOLVO', 'XC90 D5 AWD Executive', 'Limousine', 'BRAUN', 77300, 2004),
    ('VF7 X2R FVF 7200 5150', 'ROVER', 'Evoque TD4 5D Dynamic', 'Limousine', 'WHITE', 59500, 2005);

