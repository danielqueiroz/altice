# The project
Provides endpoints for calculating the Alticci number give a number N.
The sequence is defined by the following formula:

```
n=0 => a(0) = 0
n=1 => a(1) = 1
n=2 => a(2) = 1
n>2 => a(n) = a(n-3) + a(n-2)
```

## Getting started

### Prerequisites
JDK 19, Maven, Docker

### Build and run
```
mvn install
docker-compose up
```

### Testing
This application uses JUnit for unit testing.
You can launch the unit tests by using the following maven command:
```
mvn test
```

### Built with
* Java 19
* SpringBoot
* Rest API
* Swagger
* Redis (cache)
* JUnit

## API Documentation
The API documentation can be found in:
```
http://localhost:8080/api-docs
```
Also, it is possible to see and test the app through a visual interface of swagger:
```
http://localhost:8080/swagger-ui/index.html
```

## Author
**Daniel Queiroz** - [Github](https://github.com/danielqueiroz)
