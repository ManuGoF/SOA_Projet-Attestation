    CREATE TABLE Clients (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 2001, INCREMENT BY 1),
    LASTNAME VARCHAR(50) NOT NULL,
    FIRSTNAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(80) NOT NULL,
    BIRTHDAY DATE NOT NULL,
    LICENCE_TYPE VARCHAR(50) NOT NULL,
    LICENCE_DATE DATE NOT NULL,
    PRIMARY KEY (ID)
);

/*INSERT INTO Clients (LASTNAME, FIRSTNAME, EMAIL, BIRTHDAY, LICENCE_TYPE, LICENCE_DATE)
    VALUES
    ('Richir', 'Alexandre', 'richir.alexandre@gmail.com', '1991-04-25', 'B2', '2010-03-22'),
    ('Pojet', 'John', 'pojet.john@gmail.com', '1984-11-18', 'B2', '2007-01-10'),
    ('Rochat', 'Frédéric', 'rochat.frederic@gmail.com', '1989-10-12', 'B2', '2010-11-11'),
    ('Bezencon', 'Manu', 'bezencon.manu', '1990-01-02', 'B2, C2, D1', '2008-08-21'),
    ('Djarno', 'Luca', 'djarno.luca@gmail.com', '1994-03-09', 'B2, D1', '2013-12-25');*/


