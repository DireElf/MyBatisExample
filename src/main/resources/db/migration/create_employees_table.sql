DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    surname VARCHAR(50),
    email VARCHAR(50),
    age NUMERIC(2,0)
);
