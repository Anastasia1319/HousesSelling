# House Selling

"House Selling" is a platform for real estate agencies that sell homes and their clients. The platform is informative 
in nature and is designed to advertise the services of agencies and the objects they sell.
The application is built on two entities - RealEstateAgency and House.
The application is built on two entities - RealEstateAgency and House.
The relationship between RealEstateAgency-House entities is one-to-many.
In addition, there is an entity HouseAddress, which represents addresses of houses for sale and has a one-to-one 
relationship HouseAddress-House.
The application was created using Spring Boot.  Read more about the technology stack in the "Technologies" part.
The schema and data for sql are located in the root of the project. The parameters to connect to the database 
are specified in the application.properties. The database operation is implemented through the "data" layer using an ORM. 
Then the "service" layer contains all the logic of the application and basic CRUD operations are implemented. 
The "web" layer contains controllers for each entity and ErrorErrorHandler.
The test package contains the Postment collection (in JSON format), with data for testing all project endpoints.
The application is built using Maven. The application was run on localhost:8080.


Technologies:
* Java 17;
* Spring Framework version 6.0.9;
* Spring Boot version 3.1.0;
* Spring Data JPA version 3.1.0;
* Spring WEB version 6.0.9;
* Lombok version 1.18.26;
* Maven;
* PostgreSQL;
* Postman 10.15.3;

