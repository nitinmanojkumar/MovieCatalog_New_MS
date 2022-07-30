@echo off
echo start springboot docker container in 7777
docker run -p 7777:7777 -d --network springboot-mysql --name moviecatalogcontainer nitinmanojkumar/movie-catalog:latest
pause