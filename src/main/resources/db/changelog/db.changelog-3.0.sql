--liquibase formatted sql

--changeset victordev:1
ALTER TABLE users
ADD COLUMN image VARCHAR(64);

--changeset victordev:2
ALTER TABLE users_aud
ADD COLUMN image VARCHAR(64);
