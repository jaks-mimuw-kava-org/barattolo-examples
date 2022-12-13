DROP DATABASE IF EXISTS test;    

CREATE DATABASE test;    

\c test;        

CREATE TABLE Person(
    id SERIAL PRIMARY KEY,
    first varchar(50),
    last varchar(50),
    age INTEGER,
    phonenumber char(9)
);
