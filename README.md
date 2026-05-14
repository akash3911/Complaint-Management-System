# Smart Complaint Management System (Backend)

A backend-only Spring Boot API for managing user complaints with JWT authentication.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT (JJWT)
- MySQL
- Maven

## Base URL
- http://localhost:8080

## Complaint Status Values
- OPEN
- IN_PROGRESS
- RESOLVED

## Auth APIs
### Register
- POST /auth/register
- Body:
```json
{
  "name": "Alice",
  "email": "alice@example.com",
  "password": "Passw0rd!"
}
```

### Login
- POST /auth/login
- Body:
```json
{
  "email": "alice@example.com",
  "password": "Passw0rd!"
}
```
- Response:
```json
{
  "token": "<jwt>",
  "tokenType": "Bearer"
}
```

## Complaint APIs (JWT required)
Add header: Authorization: Bearer <jwt>

### Create Complaint
- POST /complaints
- Body:
```json
{
  "title": "Water leakage",
  "description": "There is a pipe leak in the basement."
}
```

### View My Complaints
- GET /complaints

### Update Complaint Status
- PUT /complaints/{id}/status?status=IN_PROGRESS

## Quick Postman Examples
### Register
- Method: POST
- URL: http://localhost:8080/auth/register
- Body (raw JSON):
```json
{
  "name": "Alice",
  "email": "alice@example.com",
  "password": "Passw0rd!"
}
```

### Login
- Method: POST
- URL: http://localhost:8080/auth/login
- Body (raw JSON):
```json
{
  "email": "alice@example.com",
  "password": "Passw0rd!"
}
```

### Create Complaint
- Method: POST
- URL: http://localhost:8080/complaints
- Headers:
  - Authorization: Bearer <jwt>
- Body (raw JSON):
```json
{
  "title": "Street light issue",
  "description": "Street light in front of my house is not working."
}
```

### List My Complaints
- Method: GET
- URL: http://localhost:8080/complaints
- Headers:
  - Authorization: Bearer <jwt>

### Update Status
- Method: PUT
- URL: http://localhost:8080/complaints/1/status?status=RESOLVED
- Headers:
  - Authorization: Bearer <jwt>
