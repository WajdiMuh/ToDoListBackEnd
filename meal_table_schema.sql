CREATE TABLE meal (
                             id serial PRIMARY KEY,
                             mealID INTEGER,
                             startdate TIMESTAMPTZ NOT NULL,
                             enddate TIMESTAMPTZ NOT NULL,
                             title TEXT NOT NULL
);