DROP DATABASE IF EXISTS test;    

CREATE DATABASE test;    

\c test;        

CREATE TABLE House(
    address VARCHAR PRIMARY KEY,
    area INTEGER
);

CREATE TABLE Person(
    id SERIAL PRIMARY KEY,
    first varchar(50),
    last varchar(50),
    age INTEGER,
    phonenumber char(9),
    house VARCHAR
);
