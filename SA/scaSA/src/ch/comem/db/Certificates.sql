    CREATE TABLE Certificates (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1001, INCREMENT BY 1),
    STATE VARCHAR(20) NOT NULL,
    CHECK (STATE IN ('en attente', 'non récupérée', 'non conforme', 'récupérée')),
    CREATION_DATE DATE NOT NULL,
    CAR_SERIAL_NUMBER INTEGER NOT NULL, 
    PRIMARY KEY (ID)
);

/*INSERT INTO Certificates (STATE, CREATION_DATE, CAR_SERIAL_NUMBER, WORKER_ID)
    VALUES
    ('en attente', '2015-03-27', 100000001, 3001),
    ('en attente', '2015-03-28', 100000002, 3002),
    ('en attente', '2015-03-29', 100000003, 3003),
    ('en attente', '2015-03-30', 100000004, 3004),
    ('en attente', '2015-03-31', 100000005, 3005);*/

