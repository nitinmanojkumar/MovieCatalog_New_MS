@echo off
echo kill 3306
call kill3306.bat
echo kill 7779
call kill7779.bat
echo start mysql container
docker run -p 3306:3306 -d --network springboot-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=APIDevelopSpringBoot -v persistent-volume-mysql:/var/lib/mysql --name mysqlcontainername mysql:8
echo Clean and Create Package
call 0CleanCreatePackageSkipTests.bat
echo Create Docker Image
call 1createDOCKERimage.bat
echo Pushing Docker Image
call 2docker_push.bat
echo start springboot docker container in 7779
docker run -p 7779:7779 -d --network springboot-mysql --name springbootcontainername nitinmanojkumar/spring-boot-library-microservice
pause