--DROP TABLE IF EXISTS storage2;
--CREATE TABLE storage2(
--book_name varchar(50),
--id varchar(50),
--isbn varchar(50),
--aisle int,
--author varchar(50),
--PRIMARY KEY (id));

drop table IF EXISTS newratings;
CREATE TABLE newratings (
    ratings float(11) not null,
    movieid varchar(255) not null,
    PRIMARY KEY (movieid));

