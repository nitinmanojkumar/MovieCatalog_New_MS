@echo off
echo start springboot docker container in 7779
docker run -p 7779:7779 -d --network springboot-mysql --name movieratingcontainer nitinmanojkumar/movie-rating:latest
pause