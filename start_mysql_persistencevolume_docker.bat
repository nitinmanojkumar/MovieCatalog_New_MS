@echo off
echo kill 3306
call kill3306.bat
echo start mysql container
docker run -p 3306:3306 -d --cap-add=sys_nice --security-opt seccomp=unconfined --network springboot-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=movieinfo -v persistent-volume-mysql:/var/lib/mysql --name mysqlcontainername mysql:8
pause