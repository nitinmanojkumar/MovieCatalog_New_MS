@echo off
echo start Tomcat docker container in 8080
docker run -p 8090:8080 -d --network springboot-mysql --name tomcatcontainer nitinmanojkumar/tomcat-movie-front-end-image:latest
pause