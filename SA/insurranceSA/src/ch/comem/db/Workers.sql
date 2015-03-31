    CREATE TABLE Workers (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 3001, INCREMENT BY 1),
    LASTNAME VARCHAR(50) NOT NULL,
    FIRSTNAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(80) NOT NULL,
    POSITION VARCHAR(20) NOT NULL,
    CHECK (POSITION IN ('garage', 'agence', 'siege', 'direction', 'sca')),
    CERTIFICATE_ID INTEGER NOT NULL, 
    PRIMARY KEY (ID)
);

INSERT INTO Workers (LASTNAME, FIRSTNAME, EMAIL, POSITION, CERTIFICATE_ID)
    VALUES
    ('Mavic', 'Arnold', 'mavic.arnold@gmail.com', 'garage', 1001),
    ('Bateau', 'Jean', 'bateau.jean@gmail.com', 'garage', 1002),
    ('Rochat', 'Loic', 'rochat.loic@gmail.com', 'garage', 1003),
    ('Mayer', 'Justin', 'mayer.justin@gmail.com', 'garage', 1004),
    ('Wenger', 'Eric', 'wenger.eric@gmail.com', 'garage', 1005);

/*ALTER TABLE Peoples
ADD FOREIGN KEY (AUTO_ID) REFERENCES Autos(SERIAL_NUMBER);*/


