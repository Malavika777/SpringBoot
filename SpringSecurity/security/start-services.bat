@echo off
echo Starting Spring Security Microservices Architecture...
echo.

echo Starting Eureka Service Discovery Server...
start "Eureka Server" cmd /k "cd eureka-service && mvn spring-boot:run"

timeout /t 10 /nobreak > nul

echo Starting Auth Service...
start "Auth Service" cmd /k "cd auth-service && mvn spring-boot:run"

timeout /t 5 /nobreak > nul

echo Starting User Management Service...
start "User Management Service" cmd /k "cd user-management-service && mvn spring-boot:run"

timeout /t 5 /nobreak > nul

echo Starting Gateway Service...
start "Gateway Service" cmd /k "cd gateway-service && mvn spring-boot:run"

echo.
echo All services are starting up...
echo.
echo Service URLs:
echo - Eureka Server: http://localhost:8761
echo - Gateway Service: http://localhost:8080
echo - Auth Service: http://localhost:8081
echo - User Management Service: http://localhost:8082
echo.
echo Wait for all services to start up completely before testing.
echo Check the console windows for startup completion messages.
pause
