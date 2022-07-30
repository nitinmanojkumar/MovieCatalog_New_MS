@echo off
echo kill 7779
call kill7779.bat
call 0CleanCreatePackageSkipTests_movieratingservice.bat
echo Create Docker Image
call 1createDOCKERimage_movieratingservice.bat
echo skip Pushing Docker Image
echo start springboot docker container in 7779
docker run -p 7779:7779 -d --network springboot-mysql --name movieratingcontainer nitinmanojkumar/movie-rating:latest
pause