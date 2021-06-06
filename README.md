# Employee REST API application

## Default url
    http://localhost:8080/employeerest/


# REST API

The REST API app is described below. 
It contains 2 layers of Spring project, EmployeeDbAppSpring is for Database Operations and employeerestapi is for exposing the endpoints

## Get list of Things

### Request

`GET /employees/`

    http://localhost:8080/employeerest/employees

## Create a new Employee

### Request

`POST /employees/`

    http://localhost:8080/employeerest/employees

### Sample JSON data 
    
{
    "name": "aziz",
    "surname": "gasimov",
    "salary": 400.99
}


## Get an employee

### Request

`GET /employee/id`

    http://localhost:8080/employeerest/employee/1

## if get a non-existent Thing

### Request

`GET /employee/id`

    http://localhost:8080/employeerest/employee/999999

### Response

    HTTP 404 Not Found

## Update an Employee

### Request

`PUT /employee/:id`

    http://localhost:8080/employeerest/employee/18

## Delete a Thing

### Request

`DELETE /employee/id`

    http://localhost:8080/employeerest/employee/1


## Pagination and Sorting
`default to page number (pageNum) = 1, page size (pageSize) = 10`

`GET /employees`

    http://localhost:8080/employeerest/employees?pageSize=8

    http://localhost:8080/employeerest/employees?pageNum=2

`default sort string is "name"`
`GET /employees`

    http://localhost:8080/employeerest/employees?sortBy="name"
