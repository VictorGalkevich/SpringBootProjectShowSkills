--liquibase formatted sql

--changeset victordev:1
ALTER TABLE users_aud
ALTER COLUMN password TYPE VARCHAR(128);
