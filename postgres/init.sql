DROP DATABASE IF EXISTS test;    

CREATE DATABASE test;    

\c test;        

CREATE TABLE Person(
id SERIAL PRIMARY KEY,
firstname varchar(50),
lastname varchar(50),
age INTEGER,
phonenumber char(9)
);
