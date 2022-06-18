use ratingdataservice;
drop procedure if exists `GetRatingsOfAllProducts`;
DELIMITER //
create procedure GetRatingsOfAllProducts()
Begin
	Select * from ratingdataservice.newratings;
END
//
DELIMITER ;
call GetRatingsOfAllProducts();