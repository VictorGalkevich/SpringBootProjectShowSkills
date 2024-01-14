--liquibase formatted sql

--changeset victordev:1
ALTER TABLE users_aud
DROP COLUMN password;

--changeset victordev:2
ALTER TABLE users_aud
ADD COLUMN password VARCHAR(128);