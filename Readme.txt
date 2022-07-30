1. Kill 3306 port --> run "kill3306.bat" file as admin
2. Start sql as persistent volume --> run "start_mysql_persistencevolume_docker.bat" file
3. Make sure the propery "spring.datasource.url" in all 3 services's "Application.property"
	3.1 If you want to run the springboot locally then 
		--> spring.datasource.url=jdbc:mysql://localhost:3306/{useRespectiveDBtableName}?useSSL=false&allowPublicKeyRetrieval=true
	3.2 If you want to run the springboot as docker container then 
		--> spring.datasource.url=jdbc:mysql://mysqlcontainername/{useRespectiveDBtableName}?useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=10
	for Rating --> useRespectiveDBtableName =ratingdataservice
	for Catalog --> useRespectiveDBtableName =catalogmovie
	for Info --> useRespectiveDBtableName =movieinfo	
	
4. Start the springboot files 
	4.1 RUN "start_movieratingINdocker_includeImagePushtoHUB.bat"
	4.2 RUN "start_movieinfoINdocker_includeImagePushtoHUB.bat"
	4.3 RUN "start_moviecatalogINdocker_includeImagePushtoHUB.bat"