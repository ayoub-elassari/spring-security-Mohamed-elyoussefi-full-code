🔐 Spring Security - JWT Authentication Demo
This project is a simple Spring Boot application demonstrating JWT-based authentication with role-based authorization.
It uses an in-memory H2 database and exposes secure REST endpoints for login, user management, and profile access.

🚀 Step 1: Run the Project
Start the Spring Boot application:

bash
Copy
Edit
./mvnw spring-boot:run
💾 Step 2: Access the H2 Console
Use your browser to access the H2 database console:

css
Copy
Edit
http://{{IP}}/h2-console
Use the following JDBC URL:

makefile
Copy
Edit
jdbc:h2:mem:users-db
ℹ️ This lets you inspect in-memory users and roles during runtime.

🔑 Step 3: Login to Get Access & Refresh Tokens
arduino
Copy
Edit
POST http://{{IP}}/login
Use the following credentials:

username=admin

password=1234

cURL:

bash
Copy
Edit
curl -X POST {{IP}}/login \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "username=admin&password=1234"
✅ The response contains an access_token and a refresh_token.
You'll use these tokens in subsequent requests.

👥 Step 4: Get Users List (Requires USER Role)
arduino
Copy
Edit
GET http://{{IP}}/users
🔒 Requires a user with the USER role.
Include the access token from the login step in the Authorization header.

cURL:

bash
Copy
Edit
curl -X GET {{IP}}/users \
  -H "Authorization: Bearer <access_token>"
➕ Step 5: Add a New User (Requires ADMIN Role)
arduino
Copy
Edit
POST http://{{IP}}/users
🔒 Requires a user with the ADMIN role.
Use the access_token of an admin user.

JSON Body:

json
Copy
Edit
{
  "username": "ayoub",
  "password": "1234"
}
cURL:

bash
Copy
Edit
curl -X POST {{IP}}/users \
  -H "Authorization: Bearer <admin_access_token>" \
  -H "Content-Type: application/json" \
  -d '{"username": "ayoub", "password": "1234"}'
🔁 Step 6: Refresh Access Token
arduino
Copy
Edit
GET http://{{IP}}/refreshToken
🔄 This endpoint allows users to get a new access token using the previously received refresh_token.

cURL:

bash
Copy
Edit
curl -X GET {{IP}}/refreshToken \
  -H "Authorization: Bearer <refresh_token>"
👤 Step 7: Get Current User Profile
arduino
Copy
Edit
GET http://{{IP}}/profile
🔒 Secured endpoint to retrieve details of the currently authenticated user.

cURL:

bash
Copy
Edit
curl -X GET {{IP}}/profile \
  -H "Authorization: Bearer <access_token>"
