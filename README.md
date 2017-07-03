# java-sample-project
A Sample Project to be used for examples in https://ralphavalon.wordpress.com/ and https://ralphavalonbr.wordpress.com/

### How to configure ###
* Execute the command:
```
mvn package
```

### About the project ###

* It's a simple project with Spring Boot + Thymeleaf + Spring Data JPA exposing 4 endpoints:
```
/
/create
/rest/
/rest/:user_id
```

* Base path: **http://localhost:8081/**

* The project is about adding and getting users only, but of two ways: *web page* and *REST*.

* **NOTE:** This branch uses a H2 as database. You can configure it on *application.properties*

* **START THE PROJECT:**

* To clean the project and generate a new JAR:

```
mvn clean package
```

* To run the created JAR:

```
java -jar target/JavaSampleProject.jar
```