use movieinfo;
drop procedure if exists `GetAllMovieDescAndSummary`;
DELIMITER //
create procedure GetAllMovieDescAndSummary()
Begin
	Select * from movieinfo.newmovielist;
END
//
DELIMITER ;
call GetAllMovieDescAndSummary();