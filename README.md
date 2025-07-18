
# ðŸ” Spring Security - JWT Authentication Demo

This project is a simple Spring Boot application demonstrating **JWT-based authentication with role-based authorization**.  
It uses an in-memory H2 database and exposes secure REST endpoints for login, user management, and profile access.

---

## ðŸš€ Step 1: Run the Project

Start the Spring Boot application:

```bash
./mvnw spring-boot:run
```

---

## ðŸ’¾ Step 2: Access the H2 Console

Use your browser to access the H2 database console:

```
http://{{IP}}/h2-console
```

Use the following JDBC URL:

```
jdbc:h2:mem:users-db
```

â„¹ï¸ This lets you inspect in-memory users and roles during runtime.

---

## ðŸ”‘ Step 3: Login to Get Access & Refresh Tokens

**Endpoint:**
```
POST http://{{IP}}/login
```

Use the following credentials:
- `username=admin`
- `password=1234`

**cURL:**
```bash
curl -X POST {{IP}}/login   -H "Content-Type: application/x-www-form-urlencoded"   -d "username=admin&password=1234"
```

âœ… The response contains an `access_token` and a `refresh_token`.

---

## ðŸ‘¥ Step 4: Get Users List (Requires `USER` Role)

**Endpoint:**
```
GET http://{{IP}}/users
```

ðŸ”’ Requires a user with the `USER` role.  
Include the access token in the Authorization header.

**cURL:**
```bash
curl -X GET {{IP}}/users   -H "Authorization: Bearer <access_token>"
```

---

## âž• Step 5: Add a New User (Requires `ADMIN` Role)

**Endpoint:**
```
POST http://{{IP}}/users
```

ðŸ”’ Requires a user with the `ADMIN` role.  
Use the access token of an admin user.

**JSON Body:**
```json
{
  "username": "ayoub",
  "password": "1234"
}
```

**cURL:**
```bash
curl -X POST {{IP}}/users   -H "Authorization: Bearer <admin_access_token>"   -H "Content-Type: application/json"   -d '{"username": "ayoub", "password": "1234"}'
```

---

## ðŸ” Step 6: Refresh Access Token

**Endpoint:**
```
GET http://{{IP}}/refreshToken
```

ðŸ”„ Get a new access token using the previously received refresh token.

**cURL:**
```bash
curl -X GET {{IP}}/refreshToken   -H "Authorization: Bearer <refresh_token>"
```

---

## ðŸ‘¤ Step 7: Get Current User Profile

**Endpoint:**
```
GET http://{{IP}}/profile
```

ðŸ”’ Secured endpoint to retrieve the authenticated user's profile.

**cURL:**
```bash
curl -X GET {{IP}}/profile   -H "Authorization: Bearer <access_token>"
```

---

## ðŸ“‚ Postman Collection

You can import the following collection into Postman to test all endpoints:

ðŸ“¥ [Download Collection](./test%20spring%20security.postman_collection.json)

---

> ðŸ“ Replace `{{IP}}` with your actual backend URL (e.g., `http://localhost:8080`)
