--DROP TABLE IF EXISTS storage2;
--CREATE TABLE storage2(
--book_name varchar(50),
--id varchar(50),
--isbn varchar(50),
--aisle int,
--author varchar(50),
--PRIMARY KEY (id));

drop table IF EXISTS newmovielist;
CREATE TABLE newmovielist (
    movieid varchar(255),
    moviedesc varchar(255),
    moviename varchar(255) not null,
    PRIMARY KEY (movieid));


