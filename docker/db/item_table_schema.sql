CREATE TABLE item (
    id serial PRIMARY KEY ,
    label text NOT NULL,
    storeid integer REFERENCES store(id),
    checked boolean
);
