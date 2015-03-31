    CREATE TABLE Workers (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 3001, INCREMENT BY 1),
    LASTNAME VARCHAR(50) NOT NULL,
    FIRSTNAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(80) NOT NULL,
    POSITION VARCHAR(20) NOT NULL,
    CHECK (POSITION IN ('garage', 'agence', 'siege', 'direction')),
    PRIMARY KEY (ID)
);

INSERT INTO Workers (LASTNAME, FIRSTNAME, EMAIL, POSITION)
    VALUES
    ('Mavic', 'Arnold', 'mavic.arnold@gmail.com', 'garage'),
    ('Bateau', 'Jean', 'bateau.jean@gmail.com', 'garage'),
    ('Rochat', 'Loic', 'rochat.loic@gmail.com', 'garage'),
    ('Mayer', 'Justin', 'mayer.justin@gmail.com', 'garage'),
    ('Wenger', 'Eric', 'wenger.eric@gmail.com', 'garage');


