\i store_table_schema.sql

CREATE TABLE IF NOT EXISTS item (
    id serial PRIMARY KEY ,
    label text NOT NULL,
    storeid integer REFERENCES store(id),
    checked boolean
);

INSERT INTO item (label,storeid,checked) VALUES
    ('test_item_1', 1, true),
    ('test_item_2', 2, false);
