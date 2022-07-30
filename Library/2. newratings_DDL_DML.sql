use ratingdataservice;
drop table ratingdataservice.newratings;
CREATE TABLE ratingdataservice.newratings (
    ratings float(11) not null,
    movieid varchar(255) primary key not null
);

insert into ratingdataservice.newratings(ratings,movieid) values(4.3,LOWER('avengers1'));
insert into ratingdataservice.newratings(ratings,movieid) values(4.1,LOWER('avengers2'));
insert into ratingdataservice.newratings(ratings,movieid) values(4.0,LOWER('harrypotter2'));
insert into ratingdataservice.newratings(ratings,movieid) values(3.9,LOWER('harrypotter3'));
insert into ratingdataservice.newratings(ratings,movieid) values(3.5,LOWER('jumanji2'));
insert into ratingdataservice.newratings(ratings,movieid) values(4.7,LOWER('spiderman3'));