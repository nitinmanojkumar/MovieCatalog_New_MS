use ratingdataservice;
drop table ratingdataservice.newratings;
CREATE TABLE newratings (
    ratings float(11) not null,
    movieid varchar(255) primary key not null
);

insert into newratings(ratings,movieid)
values(('Walt Disney',LOWER('avengers1')),
('Warner Bros','harrypotter2'),('Warner Bros','HarryPotter3'),('Sony','Spiderman3'),('Sony','Jumanji2')
,('Walt Disney','Avengers2'),('Walt Disney','Avengers1'));

insert into newratings(ratings,movieid)
values(4.3,LOWER('Spiderman3'));

