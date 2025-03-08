CREATE TABLE meal (
                             id serial PRIMARY KEY,
                             mealdate TIMESTAMPTZ NOT NULL,
                             title TEXT NOT NULL
);