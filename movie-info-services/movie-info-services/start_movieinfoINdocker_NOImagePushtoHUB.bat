@echo off
echo kill 7778
call kill7778.bat
echo Clean and Create Package
call 0CleanCreatePackageSkipTests_movieinfoservice.bat
echo Create Docker Image
call 1createDOCKERimage_movieinfoservice.bat
echo skip Pushing Docker Image
echo start springboot docker container in 7778
docker run -p 7778:7778 -d --network springboot-mysql --name movieinfocontainer nitinmanojkumar/movie-info:latest
pause