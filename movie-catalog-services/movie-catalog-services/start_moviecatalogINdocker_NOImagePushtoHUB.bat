@echo off
echo kill 7777
call kill7777.bat
echo Clean and Create Package
call 0CleanCreatePackageSkipTests_moviecatalogservice.bat
echo Create Docker Image
call 1createDOCKERimage_moviecatalogservice.bat
echo skip Pushing Docker Image
echo start springboot docker container in 7777
docker run -p 7777:7777 -d --network springboot-mysql --name moviecatalogcontainer nitinmanojkumar/movie-catalog:latest
pause