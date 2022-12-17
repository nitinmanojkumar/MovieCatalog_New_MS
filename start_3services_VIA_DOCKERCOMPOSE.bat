@echo off
SET mypath=%~dp0
echo start Persistent DB
docker-compose -f .\movie-rating-services\movie-rating-services\docker-compose.yml up -d
docker-compose -f .\movie-info-services\movie-info-services\docker-compose.yml up -d
docker-compose -f .\movie-catalog-services\movie-catalog-services\docker-compose.yml up -d
pause