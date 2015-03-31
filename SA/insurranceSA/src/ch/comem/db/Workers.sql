    CREATE TABLE Workers (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 3001, INCREMENT BY 1),
    LASTNAME VARCHAR(50) NOT NULL,
    FIRSTNAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(80) NOT NULL,
    POSITION VARCHAR(20) NOT NULL,
    CHECK (POSITION IN ('garage', 'agence', 'siege', 'direction')),
    CERTIFICATE_NUMBER VARCHAR(50) NOT NULL, 
    PRIMARY KEY (ID)
);

INSERT INTO Workers (LASTNAME, FIRSTNAME, EMAIL, POSITION, CERTIFICATE_NUMBER)
    VALUES
    ('Mavic', 'Arnold', 'mavic.arnold@gmail.com', 'garage', 'ASS10 5000 1001'),
    ('Bateau', 'Jean', 'bateau.jean@gmail.com', 'garage', 'ASS10 5000 2002'),
    ('Rochat', 'Loic', 'rochat.loic@gmail.com', 'garage', 'ASS10 5000 3003'),
    ('Mayer', 'Justin', 'mayer.justin@gmail.com', 'garage', 'ASS10 5000 4004'),
    ('Wenger', 'Eric', 'wenger.eric@gmail.com', 'garage', 'ASS10 5000 5005');


