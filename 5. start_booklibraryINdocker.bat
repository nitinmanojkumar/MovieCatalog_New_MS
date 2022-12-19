@echo off
echo start springboot docker container in 7776
docker run -p 7776:7776 -d --network springboot-mysql --name springbootcontainername nitinmanojkumar/spring-boot-library-microservice:latest
pause