FROM postgres:latest

EXPOSE 5432

WORKDIR /docker-entrypoint-initdb.d

COPY item_table_schema.sql .

ENV POSTGRES_DB=tdl