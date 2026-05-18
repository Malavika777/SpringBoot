#!/bin/bash

echo "Starting Spring Security Microservices Architecture..."
echo

echo "Starting Eureka Service Discovery Server..."
cd eureka-service
mvn spring-boot:run &
EUREKA_PID=$!
cd ..

sleep 10

echo "Starting Auth Service..."
cd auth-service
mvn spring-boot:run &
AUTH_PID=$!
cd ..

sleep 5

echo "Starting User Management Service..."
cd user-management-service
mvn spring-boot:run &
USER_PID=$!
cd ..

sleep 5

echo "Starting Gateway Service..."
cd gateway-service
mvn spring-boot:run &
GATEWAY_PID=$!
cd ..

echo
echo "All services are starting up..."
echo
echo "Service URLs:"
echo "- Eureka Server: http://localhost:8761"
echo "- Gateway Service: http://localhost:8080"
echo "- Auth Service: http://localhost:8081"
echo "- User Management Service: http://localhost:8082"
echo
echo "Wait for all services to start up completely before testing."
echo "Check the console for startup completion messages."
echo
echo "Press Ctrl+C to stop all services"

# Function to cleanup processes on exit
cleanup() {
    echo "Stopping all services..."
    kill $EUREKA_PID $AUTH_PID $USER_PID $GATEWAY_PID 2>/dev/null
    exit
}

# Set trap to cleanup on script exit
trap cleanup SIGINT SIGTERM

# Wait for user to stop
wait
