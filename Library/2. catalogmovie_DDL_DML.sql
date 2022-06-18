use catalogmovie;
drop table catalogmovie.movielist;
CREATE TABLE catalogmovie.movielist (
    production varchar(255) not null,
    movieid varchar(255) primary key not null
);

insert into catalogmovie.movielist(production,movieid)
values(('Walt Disney',LOWER('avengers1')),('Warner Bros','harrypotter2'),('Warner Bros','HarryPotter3'),('Sony','Spiderman3'),('Sony','Jumanji2')
,('Walt Disney','Avengers2'),('Walt Disney','Avengers1'));

insert into catalogmovie.movielist(production,movieid) values('Walt Disney',LOWER('Avengers2'));
insert into catalogmovie.movielist(production,movieid) values('Walt Disney',LOWER('Avengers1'));
insert into catalogmovie.movielist(production,movieid) values('Warner Bros',LOWER('harrypotter2'));
insert into catalogmovie.movielist(production,movieid) values('Warner Bros',LOWER('HarryPotter3'));
insert into catalogmovie.movielist(production,movieid) values('Sony',LOWER('Spiderman3'));
insert into catalogmovie.movielist(production,movieid) values('Sony',LOWER('Jumanji2'));






