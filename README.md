#  GTA-VI API


<p align="center">
  <img src="https://img.shields.io/badge/PROJECT-GTA--VI-FF69B4?style=for-the-badge" alt="GTA-VI Project" />
  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge" alt="REST API" />
  <img src="https://img.shields.io/badge/DOCUMENTATION-SWAGGER-green?style=for-the-badge" alt="Swagger Documentation" />
</p>


##  About the Project

The **GTA-VI API** is a RESTful API project developed to provide structured access to application data through HTTP requests.

The API allows other applications, front-end interfaces, and external services to communicate with the backend using standardized HTTP methods and JSON data.

This project aims to demonstrate backend development concepts, API architecture, endpoint organization, and integration with external applications.

##  Table of Contents

- [Technologies](#-technologies)
- [Getting Started](#-getting-started)
- [Installation](#-installation)
- [Running the API](#-running-the-api)
- [API Documentation](#-api-documentation)
- [How to Consume the API](#-how-to-consume-the-api)
- [HTTP Methods](#-http-methods)
- [Request Examples](#-request-examples)
- [Response Format](#-response-format)
- [Error Handling](#-error-handling)
- [Testing the API](#-testing-the-api)
- [Project Structure](#-project-structure)
- [Contributing](#-contributing)
- [Author](#-author)

---

## 🛠 Technologies

The project uses a REST API architecture and Swagger/OpenAPI for API documentation.

- **REST API:** Communication through HTTP requests.
- **JSON:** Data exchange format.
- **Swagger UI:** Interactive API documentation.
- **Springdoc OpenAPI:** API documentation integration (if configured in the project).

##  Getting Started

To run and consume the API locally, you need to have the required development tools installed.

### Prerequisites

- Git
- Java Development Kit (JDK), compatible with the project
- Maven or Gradle, depending on the project configuration
- Postman or Insomnia (optional)
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code

##  Installation

### 1. Clone the repository

```bash
git clone https://github.com/dev-LuccaMonteiro/GTA-VI.git
```

### 2. Access the project directory

```bash
cd GTA-VI
```

### 3. Open the project

Open the project in your preferred IDE and wait for the dependencies to be configured.

If the application uses Maven, install its dependencies with:

```bash
mvn clean install
```

If the project includes the Maven Wrapper, you can also use:

```bash
./mvnw clean install
```

On Windows:

```bash
mvnw.cmd clean install
```

##  Running the API

After installing the dependencies, start the application using your IDE or the appropriate build tool.

For a Maven project:

```bash
mvn spring-boot:run
```

Or, if Maven Wrapper is available:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Once the application has started successfully, the API will be available at:

```text
http://localhost:8080
```

**Note:** Port `8080` is the local address configured for this project. If your application uses another port, adjust the URL accordingly.

---

##  API Documentation

The project provides interactive API documentation through **Swagger UI**.

Swagger allows developers to explore available endpoints, understand request parameters, inspect response formats, and execute HTTP requests directly from the browser.

### Swagger UI

 **Documentation:**

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### How to use Swagger

1. Start the API on your local machine.
2. Open the Swagger UI link in your browser.
3. Explore the available API controllers.
4. Select an endpoint to see its details.
5. Click **Try it out**.
6. Fill in the required parameters or request body.
7. Click **Execute**.
8. Check the HTTP status code and response returned by the API.

Swagger provides an easy way to understand and test the API without needing to write HTTP requests manually.

> **Important:** The Swagger URL above is a local development address. Other users must run the project on their own machines to access it. For public documentation, deploy the API and replace this URL with its public address.

---

##  How to Consume the API

You can consume the GTA-VI API using different tools and programming languages.

The API communicates through HTTP requests and exchanges data in JSON format.

### 1. Using Postman

Postman is a useful tool for testing and consuming REST APIs.

Follow these steps:

1. Open Postman.
2. Create a new HTTP request.
3. Select the HTTP method required by the endpoint.
4. Enter the endpoint URL.
5. Add the necessary headers.
6. If required, provide a JSON request body.
7. Click **Send**.
8. Analyze the response.

Example base URL:

```text
http://localhost:8080
```

The complete endpoint URL must combine the base URL with the endpoint path displayed in Swagger.

### 2. Using JavaScript (Fetch API)

You can also consume the API directly from a JavaScript application.

Example GET request:

```javascript
const API_URL = "http://localhost:8080";

async function getData() {
    try {
        const response = await fetch(`${API_URL}/YOUR-ENDPOINT`);

        if (!response.ok) {
            throw new Error(`HTTP Error: ${response.status}`);
        }

        const data = await response.json();

        console.log(data);

    } catch (error) {
        console.error("Error consuming API:", error);
    }
}

getData();
```

Replace `YOUR-ENDPOINT` with an actual endpoint documented in Swagger.

### 3. Using Axios

Another option is Axios, a popular HTTP client for JavaScript applications.

Install Axios:

```bash
npm install axios
```

Example:

```javascript
import axios from "axios";

const api = axios.create({
    baseURL: "http://localhost:8080"
});

async function getData() {
    try {
        const response = await api.get("/YOUR-ENDPOINT");

        console.log(response.data);

    } catch (error) {
        console.error("API request failed:", error);
    }
}

getData();
```

### 4. Using cURL

You can also make requests directly from your terminal.

Example:

```bash
curl -X GET "http://localhost:8080/YOUR-ENDPOINT" \
-H "Accept: application/json"
```

This allows you to test the API without installing additional applications.

---

##  HTTP Methods

REST APIs commonly use the following HTTP methods:

| Method   | Description                         |
| -------- | ----------------------------------- |
| `GET`    | Retrieves information from the API. |
| `POST`   | Creates a new resource.             |
| `PUT`    | Updates an existing resource.       |
| `PATCH`  | Partially updates a resource.       |
| `DELETE` | Removes a resource.                 |

The actual methods supported by each resource depend on the endpoints implemented in the project.

## Request Examples

The following examples illustrate common REST API request patterns. Replace the paths and fields with the actual definitions provided by Swagger.

### GET – Retrieve information

```bash
curl -X GET "http://localhost:8080/YOUR-ENDPOINT" \
-H "Accept: application/json"
```

### POST – Create a resource

```bash
curl -X POST "http://localhost:8080/YOUR-ENDPOINT" \
-H "Content-Type: application/json" \
-d '{
    "name": "Example",
    "description": "Example data"
}'
```

### PUT – Update a resource

```bash
curl -X PUT "http://localhost:8080/YOUR-ENDPOINT/1" \
-H "Content-Type: application/json" \
-d '{
    "name": "Updated Example",
    "description": "Updated information"
}'
```

### DELETE – Remove a resource

```bash
curl -X DELETE "http://localhost:8080/YOUR-ENDPOINT/1"
```

---

##  Response Format

The API uses JSON as its data exchange format where applicable.

A successful response might look like this:

```json
{
    "id": 1,
    "name": "Example",
    "description": "Example data"
}
```

The example above is illustrative and does not represent a confirmed response from a specific GTA-VI endpoint.

##  Error Handling

HTTP status codes help identify the result of an API request.

| Status Code                 | Meaning                                    |
| --------------------------- | ------------------------------------------ |
| `200 OK`                    | Request completed successfully.            |
| `201 Created`               | Resource successfully created.             |
| `204 No Content`            | Request succeeded without a response body. |
| `400 Bad Request`           | Invalid request or parameters.             |
| `401 Unauthorized`          | Authentication is required or invalid.     |
| `403 Forbidden`             | Access is denied.                          |
| `404 Not Found`             | Requested resource was not found.          |
| `500 Internal Server Error` | Unexpected server-side error.              |

The actual error response structure depends on the backend implementation.

##  Testing the API

You can test the endpoints using:

- **Swagger UI:** Interactive documentation and request execution.
- **Postman:** Manual API testing.
- **Insomnia:** HTTP request testing.
- **cURL:** Terminal-based requests.

For the best experience, start with Swagger to discover the available endpoints and required parameters.

##  Project Structure

The repository contains the main project files and the `GTAVI` directory.

For the exact package structure, controllers, services, repositories, and configuration files, refer to the source code inside that directory.

##  Contributing

Contributions are welcome!

If you want to contribute:

1. Fork this repository.
2. Create a new branch:

```bash
git checkout -b feature/new-feature
```

3. Commit your changes:

```bash
git commit -m "feat: add new feature"
```

4. Push your branch:

```bash
git push origin feature/new-feature
```

5. Open a Pull Request.

##  Author

<p align="center">
  <strong>Developed by Arthur Mota </strong>
</p>

<p align="center">
   If you like this project, consider giving it a star!
</p>

<p align="center">
  <a href="https://github.com/itsarthurmota">
    <img src="https://img.shields.io/badge/GitHub-View%20Repository-black?style=for-the-badge&logo=github" alt="View Repository" />
  </a>
</p>
