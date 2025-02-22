CREATE TABLE store (
    id serial PRIMARY KEY,
    name TEXT NOT NULL,
    type INT NOT NULL
);

INSERT INTO store (name,type) VALUES
    ('DM',0),
    ('Nahkauf', 1),
    ('Arabic Shop', 1),
    ('Sparparadies', 2);