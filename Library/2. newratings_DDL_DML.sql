use ratingdataservice;
drop table ratingdataservice.newratings;
CREATE TABLE ratingdataservice.newratings (
    ratings float(11) not null,
    movieid varchar(255) primary key not null
);

insert into ratingdataservice.newratings(ratings,movieid)
values(('Walt Disney',LOWER('avengers1')),
('Warner Bros','harrypotter2'),('Warner Bros','HarryPotter3'),('Sony','Spiderman3'),('Sony','Jumanji2')
,('Walt Disney','Avengers2'),('Walt Disney','Avengers1'));

insert into ratingdataservice.newratings(ratings,movieid) values(4.3,LOWER('avengers1'));
insert into ratingdataservice.newratings(ratings,movieid) values(4.1,LOWER('avengers2'));
insert into ratingdataservice.newratings(ratings,movieid) values(4.0,LOWER('harrypotter2'));
insert into ratingdataservice.newratings(ratings,movieid) values(3.9,LOWER('harrypotter3'));
insert into ratingdataservice.newratings(ratings,movieid) values(3.5,LOWER('jumanji2'));
insert into ratingdataservice.newratings(ratings,movieid) values(4.7,LOWER('spiderman3'));

