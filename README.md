# RecipesBrazil API
This Java application enables users to manage their favorite recipes.
The features available in the application are:
* Add a recipe
* Edit a recipe
* Delete a recipe
* Fetch a list of recipes, filtering by:
    * Whether or not the dish is vegetarian
    * The number of servings
    * Specific ingredients (either include or exclude)
    * Text search within the instructions.

## Architectural choices
Hexagonal architecture was used in this project. Also known as Ports and Adapters architecture, is an architectural pattern that aims to separate the core business logic of an application from external concerns, such as user interfaces, databases, and external services. It organizes the code into layers, with the application core at the center, surrounded by external layers that communicate through ports (interfaces) and adapters.

#### Architecture diagram
![app-architecture.drawio.png](docs%2Fapp-architecture.drawio.png)

#### Enhanced Entity-Relationship Diagram
![eee-diagram.png](docs%2Feee-diagram.png)

## Tests
In this project unit tests were used with **Junit**, **Mockito** and **AssertJ** and for integrated tests **RestTemplate**, **Spring** and database in memory **H2** were used. Both test scenarios generated **96%** code coverage according to reports extracted with JaCoCo.
#### Test coverage using JaCoCo
![test-coverage.png](docs%2Ftest-coverage.png)


## Documentation
The OpenAPI specification is used to define and document the REST API of the application.
Both documentations can be viewed by accessing the URL below after running the project.
#### Swagger
````
http://localhost:8080/swagger-ui/index.html
````
#### OpenAPI
````
http://localhost:8080/v3/api-docs
````


## Used frameworks and tools
- Spring Boot
- Lombok
- AssertJ
- Mockito
- Junit 5
- Mapstruct
- JaCoCo
- CheckStyle
- Maven
- Flyway
- H2
- MySQL
- Swagger2
- Docker