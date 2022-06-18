use catalogmovie;
drop table movielist;
CREATE TABLE movielist (
    production varchar(255) not null,
    movieid varchar(255) primary key not null
);

insert into movielist(production,movieid)
values(('Walt Disney',LOWER('avengers1')),
('Warner Bros','harrypotter2'),('Warner Bros','HarryPotter3'),('Sony','Spiderman3'),('Sony','Jumanji2')
,('Walt Disney','Avengers2'),('Walt Disney','Avengers1'));

insert into movielist(production,movieid)
values('Walt Disney',LOWER('Avengers2'));

