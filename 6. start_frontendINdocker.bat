@echo off
echo start Tomcat docker container in 8080 but exposed in host as 8090
docker run -p 8090:8080 -d --network springboot-mysql --name frontendtomcatcontainer nitinmanojkumar/tomcat-movie-front-end-image:latest
pause