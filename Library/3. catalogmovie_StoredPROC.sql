use catalogmovie;
drop procedure if exists `GetAllProducts`;
DELIMITER //
create procedure GetAllProducts()
Begin
	Select * from catalogmovie.movielist;
END
//
DELIMITER ;
call GetAllProducts();