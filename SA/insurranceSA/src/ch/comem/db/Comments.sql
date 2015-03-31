    CREATE TABLE Comments (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 4001, INCREMENT BY 1),
    TEXT VARCHAR(100) NOT NULL,
    WORKER_ID INTEGER NOT NULL,
    CERTIFICATE_ID INTEGER NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO Comments (TEXT, WORKER_ID, CERTIFICATE_ID)
    VALUES
    ('Commentaire numéro 1', 3001, 1001),
    ('Commentaire numéro 2', 3002, 1002),
    ('Commentaire numéro 3', 3003, 1003),
    ('Commentaire numéro 4', 3004, 1004),
    ('Commentaire numéro 5', 3005, 1005);


