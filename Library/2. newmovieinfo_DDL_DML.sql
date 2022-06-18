use movieinfo;
drop table newmovielist;
CREATE TABLE newmovielist (
    movieid varchar(255) primary key,
    moviedesc varchar(255),
    moviename varchar(255) not null
);

insert into newmovielist(movieid,moviedesc,moviename)
values((LOWER('avengers1'),'The Avengers, is a 2012 American superhero film based on the Marvel Comics superhero team of the same name.','The Avengers'),
('Warner Bros','harrypotter2'),('Warner Bros','HarryPotter3'),('Sony','Spiderman3'),('Sony','Jumanji2')
,('Walt Disney','Avengers2'),('Walt Disney','Avengers1'));

insert into movieinfo.newmovielist(movieid,moviedesc,moviename)
values('jumanji2','Jumanji: The Next Level 3 Desc','Jumanji: The Next Level 3');

