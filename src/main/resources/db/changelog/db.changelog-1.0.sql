--liquibase formatted sql

--changeset mshmatov:1
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    birth_date DATE NOT NULL,
    sex VARCHAR(2) NOT NULL
);
--rollback DROP TABLE user;

--changeset mshmatov:2
CREATE TABLE IF NOT EXISTS runs (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES users (id),
    start_latitude REAL NOT NULL,
    start_longitude REAL NOT NULL,
    start_datetime TIMESTAMPTZ NOT NULL,
    finish_latitude REAL,
    finish_longitude REAL,
    finish_datetime TIMESTAMPTZ,
    distance INT
);
--rollback DROP TABLE runs;