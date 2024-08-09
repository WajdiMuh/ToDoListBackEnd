CREATE TABLE meal (
                             id serial PRIMARY KEY,
                             startdate TIMESTAMPTZ NOT NULL,
                             enddate TIMESTAMPTZ NOT NULL,
                             title TEXT NOT NULL
);