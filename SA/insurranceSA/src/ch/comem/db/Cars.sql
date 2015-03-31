CREATE TABLE Cars (
    SERIAL_NUMBER INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 100000001, INCREMENT BY 1),
    REGISTRATION VARCHAR(20) NOT NULL,
    BRAND VARCHAR(20) NOT NULL,
    MODEL VARCHAR(50) NOT NULL,
    TYPE VARCHAR(50) NOT NULL,
    COLOR VARCHAR(20) NOT NULL,
    PRICE DOUBLE NOT NULL,
    CLIENT_ID INTEGER NOT NULL, 
    PRIMARY KEY (SERIAL_NUMBER)
);

INSERT INTO Cars (REGISTRATION, BRAND, MODEL, TYPE, COLOR, PRICE, CLIENT_ID)
    VALUES
    ('VD 100 777', 'AUDI', 'A3 1.4 TFSI Ambiente', 'Limousine', 'BLACK', 44000, 2001),
    ('VD 200 555', 'BMW', 'X4 xDrive 20d xLine', 'Limousine', 'BLUE', 63200, 2002),
    ('VD 300 444', 'OPEL', 'Antara 2.0 CDTi Cosmo 4WD', 'Limousine', 'RED', 48050, 2003),
    ('VD 400 333', 'VOLVO', 'XC90 D5 AWD Executive', 'Limousine', 'BRAUN', 77300, 2004),
    ('VD 500 222', 'ROVER', 'Evoque TD4 5D Dynamic', 'Limousine', 'WHITE', 59500, 2005);

