use movieinfo;
drop table movieinfo.newmovielist;
CREATE TABLE movieinfo.newmovielist (
    movieid varchar(255) primary key,
    moviedesc varchar(255),
    moviename varchar(255) not null
);

insert into movieinfo.newmovielist(movieid,moviedesc,moviename) values(LOWER('avengers1'),'The Avengers, is a 2012 American superhero film based on the Marvel Comics superhero team of the same name.','The Avengers');
insert into movieinfo.newmovielist(movieid,moviedesc,moviename) values(LOWER('avengers2'),'Age of Ultron is a 2015 American superhero film based on the Marvel Comics superhero team the Avengers','Avengers: Age of Ultron');
insert into movieinfo.newmovielist(movieid,moviedesc,moviename) values(LOWER('harrypotter2'),'An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.','Harry Potter and the Chamber of Secrets');
insert into movieinfo.newmovielist(movieid,moviedesc,moviename) values(LOWER('harrypotter3'),'Harry Potter, Ron and Hermione return to Hogwarts School of Witchcraft and Wizardry for their third year of study, where they delve into the mystery','Harry Potter and the Prisoner of Azkaban');
insert into movieinfo.newmovielist(movieid,moviedesc,moviename) values(LOWER('jumanji2'),'A team of friends return to Jumanji to rescue one of their own but discover that.','Jumanji: The Next Level');
insert into movieinfo.newmovielist(movieid,moviedesc,moviename) values(LOWER('spiderman3'),'Spider-Man 3 is a 2007 American superhero film based on the Marvel Comics character Spider-Man.','Spider-Man™ 3');