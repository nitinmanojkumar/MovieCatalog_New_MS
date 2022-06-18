INSERT INTO Storage2(book_name,id,isbn,aisle,author) values('Cypress','abcd4','abcd','4','Rahul');
INSERT INTO Storage2(book_name,id,isbn,aisle,author) values('Devops','fdsefr343','fdsefr3','43','Rahul');
INSERT INTO Storage2(book_name,id,isbn,aisle,author) values('Devops','ddy22','ddy','22','Shetty');

INSERT INTO Storage2(book_name,id,isbn,aisle,author) values('Cypress1','abcd41','abcd1','41','Rahul1');

INSERT INTO Storage2(book_name,id,isbn,aisle,author) values('Test','Test','Test','1111','Test');

SET SQL_SAFE_UPDATES = 0;
delete from Storage2 where isbn='111';

select * from Storage2;