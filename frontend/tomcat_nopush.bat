@echo off
echo kill 8090
call kill8090.bat
echo Clean and Create Package
call 0CleanCreatePackageSkipTests.bat
echo Create Docker Image
call 1createDOCKERimage.bat
echo Skip pushing Docker Image
echo start tomcat docker container in 8090
call 4launchDockerTomcatContainer.bat
pause