CREATE TABLE Examples (
    ID_Example INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    CHAIN VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID_Example)
);

INSERT INTO Examples (CHAIN)
    VALUES
    ('Example 1'),
    ('Example 2'),
    ('Example 3'),
    ('Example 4'),
    ('Example 5');

