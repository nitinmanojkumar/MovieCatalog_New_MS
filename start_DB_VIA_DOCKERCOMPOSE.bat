@echo off
SET mypath=%~dp0
echo start Persistent DB
docker-compose -f docker-compose.yml up
pause