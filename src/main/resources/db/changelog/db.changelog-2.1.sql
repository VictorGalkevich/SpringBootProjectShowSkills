--liquibase formatted sql

--changeset victordev:1
CREATE TABLE IF NOT EXISTS revision
(
    id BIGSERIAL PRIMARY KEY ,
    timestamp BIGINT NOT NULL
);

--changeset victordev:2
CREATE TABLE IF NOT EXISTS users_aud
(
    id BIGINT,
    rev BIGSERIAL REFERENCES revision (id),
    revtype SMALLINT ,
    username VARCHAR(64) NOT NULL UNIQUE ,
    birth_date DATE,
    firstname VARCHAR(64),
    lastname VARCHAR(64),
    role VARCHAR(32),
    company_id BIGINT
);
