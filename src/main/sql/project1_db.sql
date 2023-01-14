CREATE TABLE Person
(
    id          int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name        varchar(50) UNIQUE NOT NULL,
    yearOfBirth int NOT NULL CHECK (yearOfBirth > 1919 AND yearOfBirth < 2018)
);

CREATE TABLE Book
(
    id        int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    person_id int                  REFERENCES person (id) ON DELETE SET NULL,
    title     varchar(255)         NOT NULL,
    author    varchar(50)          NOT NULL,
    year      int NOT NULL CHECK (year > 0) NOT NULL
);