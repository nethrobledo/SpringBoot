# SpringBoot
Job hunting - sample project to demonstrate the use of Spring Boot, REST APIs and Hibernate

## Test using maven
* Generate project distribution using mvn clean install command on root folder.
* Execute mvn spring-boot:run command on server module
* Open browser on http://localhost:8080/users

## Test using maven and docker
* Generate project distribution using mvn clean install command on root folder.
* docker images
* docker run -p 8080:8080 -t server
* Open browser on http://localhost:8080/users