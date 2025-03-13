# Traini8 - Training Center Registry MVP

This is an MVP for a registry system for Government funded Training Centers. The application provides APIs to create and retrieve training center information.

## Tech Stack

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- mysql (in-memory)
- Maven
- Lombok

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. Clone the repository
2. The application will start running at `http://localhost:8080`

## API Documentation

### 1. Create Training Center

- **URL**: `/api/training-centers`
- **Method**: `POST`
- **Content-Type**: `application/json`
- **Request Body**:
```json
{
 "centerName": "Tech Skills Center",
 "centerCode": "TECHSKILL123",
 "address": {
   "detailedAddress": "123 Main Street",
   "city": "Bangalore",
   "state": "Karnataka",
   "pincode": "560001"
 },
 "studentCapacity": 200,
 "coursesOffered": ["Java Programming", "Web Development", "Data Science"],
 "contactEmail": "contact@techskills.com",
 "contactPhone": "9876543210"
}
Project Structure

src/main/java/com/traini8/registry/
├── Traini8Application.java (Main application class)
├── controller
│   └── TrainingCenterController.java (REST endpoints)
├── exception
│   ├── DuplicateCenterCodeException.java
│   ├── ErrorResponse.java
│   └── GlobalExceptionHandler.java
├── model
│   ├── Address.java
│   └── TrainingCenter.java (Entity classes)
├── repository
│   └── TrainingCenterRepository.java (Data access)
└── service
    └── TrainingCenterService.java (Business logic)
