# Spring Security Microservices Architecture

This project demonstrates a complete microservices architecture with Spring Security, similar to what your mentor showed you. It includes four main services:

## 🏗️ Architecture Overview

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Eureka        │    │   Gateway       │    │   Auth          │
│   Service       │    │   Service       │    │   Service       │
│   (8761)        │    │   (8080)        │    │   (8081)        │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
                    ┌─────────────────┐
                    │   User Mgmt      │
                    │   Service        │
                    │   (8082)         │
                    └─────────────────┘
```

## 🚀 Services

### 1. **Eureka Service Discovery Server** (Port: 8761)
- **Purpose**: Service registry and discovery
- **Features**: 
  - Service registration
  - Health monitoring
  - Load balancing support
- **URL**: http://localhost:8761

### 2. **Gateway Service** (Port: 8080)
- **Purpose**: API Gateway and routing
- **Features**:
  - Request routing to microservices
  - JWT token validation
  - Security enforcement
  - Load balancing
- **URL**: http://localhost:8080

### 3. **Auth Service** (Port: 8081)
- **Purpose**: Authentication and authorization
- **Features**:
  - User login/logout
  - JWT token generation
  - User registration
  - Token validation
- **URL**: http://localhost:8081

### 4. **User Management Service** (Port: 8082)
- **Purpose**: User data management
- **Features**:
  - User profile CRUD operations
  - User search and filtering
  - User statistics
- **URL**: http://localhost:8082

## 🛠️ How to Run

### Prerequisites
- Java 17+
- Maven 3.6+

### Step 1: Start Eureka Server
```bash
cd eureka-service
mvn spring-boot:run
```
**URL**: http://localhost:8761

### Step 2: Start Auth Service
```bash
cd auth-service
mvn spring-boot:run
```
**URL**: http://localhost:8081

### Step 3: Start User Management Service
```bash
cd user-management-service
mvn spring-boot:run
```
**URL**: http://localhost:8082

### Step 4: Start Gateway Service
```bash
cd gateway-service
mvn spring-boot:run
```
**URL**: http://localhost:8080

## 🔐 Security Flow

1. **Client** sends request to **Gateway** (http://localhost:8080)
2. **Gateway** checks if authentication is required
3. If yes, **Gateway** validates JWT token
4. If valid, **Gateway** routes request to appropriate service
5. **Service** processes request and returns response
6. **Gateway** returns response to client

## 📡 API Endpoints

### Authentication (via Gateway)
- `POST /auth/login` - User login
- `POST /auth/register` - User registration
- `POST /auth/validate` - Token validation

### User Management (via Gateway)
- `GET /users` - Get all users
- `GET /users/{id}` - Get user by ID
- `POST /users` - Create user profile
- `PUT /users/{id}` - Update user profile
- `DELETE /users/{id}` - Delete user profile

## 🧪 Testing the System

### 1. Register a User
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123",
    "email": "test@example.com"
  }'
```

### 2. Login
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123"
  }'
```

### 3. Access Protected Resource
```bash
curl -X GET http://localhost:8080/users \
  -H "Authorization: Bearer YOUR_JWT_TOKEN"
```

## 🔧 Configuration

### JWT Configuration
All services use the same JWT secret for token validation:
```yaml
jwt:
  secret: mySecretKey123456789012345678901234567890
  expiration: 86400000 # 24 hours
```

### Database
- **Auth Service**: H2 database (in-memory)
- **User Management Service**: H2 database (in-memory)
- **H2 Console**: Available at http://localhost:8081/h2-console and http://localhost:8082/h2-console

## 🎯 Key Features

### 1. **Service Discovery**
- All services register with Eureka
- Services can find each other by name
- Automatic health monitoring

### 2. **Security**
- JWT-based authentication
- Token validation at gateway level
- Role-based access control

### 3. **Scalability**
- Each service can be scaled independently
- Load balancing support
- Fault isolation

### 4. **Monitoring**
- Eureka dashboard for service status
- H2 console for database inspection
- Comprehensive logging

## 🚨 Troubleshooting

### Common Issues

1. **Port Conflicts**: Make sure ports 8080, 8081, 8082, and 8761 are available
2. **Service Discovery**: Ensure Eureka server is running before other services
3. **JWT Tokens**: Use the same JWT secret across all services
4. **Database**: H2 databases are in-memory and reset on restart

### Logs
Check application logs for detailed error messages:
```bash
# Check Eureka logs
tail -f eureka-service/logs/application.log

# Check Gateway logs
tail -f gateway-service/logs/application.log
```

## 📚 Learning Points

This project demonstrates:
- **Microservices Architecture**: Service separation and communication
- **Spring Security**: JWT authentication and authorization
- **Service Discovery**: Eureka server and client configuration
- **API Gateway**: Request routing and security
- **Database Integration**: JPA and H2 database setup
- **REST APIs**: Complete CRUD operations

## 🎓 Next Steps

1. **Add more services** (e.g., notification service, file service)
2. **Implement OAuth2** for more advanced authentication
3. **Add database persistence** (PostgreSQL, MySQL)
4. **Implement monitoring** (Spring Boot Actuator, Micrometer)
5. **Add API documentation** (Swagger/OpenAPI)
6. **Implement caching** (Redis)
7. **Add message queues** (RabbitMQ, Kafka)

This architecture provides a solid foundation for enterprise-level applications with proper security, scalability, and maintainability.
