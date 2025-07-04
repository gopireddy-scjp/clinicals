# Clinicals API

A Spring Boot RESTful API for managing clinical data, including component name, value, and measured date/time.

## Features

- Create, read, update, and delete clinical data records
- Stores component name, value, and measured date/time
- Built with Java, Spring Boot, and Maven

## Getting Started

### Prerequisites

- Java 21 or later
- Maven 3.6+
- A running database (e.g., MySQL, PostgreSQL, H2)

### Setup

1. Clone the repository:
2. Configure your database in `src/main/resources/application.properties`.

3. Build and run the application:

## API Endpoints

| Method | Endpoint              | Description                |
|--------|----------------------|----------------------------|
| GET    | /api/clinical        | List all clinical data     |
| GET    | /api/clinical/{id}   | Get clinical data by ID    |
| POST   | /api/clinical        | Create new clinical data   |
| PUT    | /api/clinical/{id}   | Update clinical data       |
| DELETE | /api/clinical/{id}   | Delete clinical data       |

## add API Endpoints for Patient
| Method | Endpoint              | Description                |
|--------|----------------------|----------------------------|
| GET    | /api/patient         | List all patients          |
| GET    | /api/patient/{id}    | Get patient by ID          |
| POST   | /api/patient         | Create new patient         |
| PUT    | /api/patient/{id}    | Update patient             |
| DELETE | /api/patient/{id}    | Delete patient             |

## Example Clinical Data Model

```json
{
  "componentName": "Blood Pressure",
  "componentValue": "120/80",
  "measuredDateTime": "2024-06-10T14:30:00"
}


```

## Prompts

prompt-1:
I am a senior java developer. I want to create a application that captures the patient and his clinical data.
suggest a good tech stack for the rest api and single page application.

prompt-2:
How can i crate a clinical spring boot project while using mysql database to save patient and clinical data.

prompt-3:
create patient data jpa model class with primary key id, first name, last name and age.

prompt-4:
create clinical data jpa model class with component name, component value and measured date time

prompt-5:
create patient repository that uses patient data model

prompt-7:
create clinical data jpa repository that uses clinical data model

prompt-8:
create patientService and it's implement and it uses patientRepository

prompt-9:
create clinicalDataService and it's implementation and it uses clinicaldatarepository

prompt-10:
create patient rest controller that uses the patient service and exposes a rest api to perform create, read, update and delete operations.

prompt-11:
create clinical rest controller that uses the clinical data service and exposes a rest api to perform create, read, update and delete operations.


prompt-12:
write junit unit test cases for ClinicalDataServiceImpl by using mock followed by // given // when // then pattern

prompt-13:
write junit unit test cases for PatientServiceImpl by using mock followed by // given // when // then pattern and test case names
as should_save_patient_data this pattern

prompt-14:
write spring boot integration test cases for PatientController by using MockMvc and mock and spring boot test

prompt-15:
write spring boot integration test cases for ClinicalDataController by using MockMvc and mock and spring boot test

