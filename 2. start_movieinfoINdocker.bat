@echo off
echo start springboot docker container in 7778
docker run -p 7778:7778 -d --network springboot-mysql --name movieinfocontainer nitinmanojkumar/movie-info:latest
pause