CREATE TABLE Autos (
    SERIAL_NUMBER INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 100000001, INCREMENT BY 1),
    REGISTRATION VARCHAR(20) NOT NULL,
    BRAND VARCHAR(20) NOT NULL,
    MODEL VARCHAR(50) NOT NULL,
    TYPE VARCHAR(50) NOT NULL,
    COLOR VARCHAR(20) NOT NULL,
    PRICE DOUBLE NOT NULL,
    OWNER_ID INTEGER NOT NULL, 
    PRIMARY KEY (SERIAL_NUMBER)
);

INSERT INTO Autos (REGISTRATION, BRAND, MODEL, TYPE, COLOR, PRICE, OWNER_ID)
    VALUES
    ('VD 100 777', 'AUDI', 'A3 1.4 TFSI Ambiente', 'Limousine', 'BLACK', 44000, 1001),
    ('VD 200 555', 'BMW', 'X4 xDrive 20d xLine', 'Limousine', 'BLUE', 63200, 1002),
    ('VD 300 444', 'OPEL', 'Antara 2.0 CDTi Cosmo 4WD', 'Limousine', 'RED', 48050, 1003),
    ('VD 400 333', 'VOLVO', 'XC90 D5 AWD Executive', 'Limousine', 'BRAUN', 77300, 1004),
    ('VD 500 222', 'ROVER', 'Evoque TD4 5D Dynamic', 'Limousine', 'WHITE', 59500, 1005);

/*ALTER TABLE Autos
ADD FOREIGN KEY (OWNER_ID) REFERENCES Peoples(PERSON_ID);*/
