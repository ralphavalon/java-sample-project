# java-sample-project
A Sample Project to be used for examples in https://ralphavalon.wordpress.com/ and https://ralphavalonbr.wordpress.com/

### How to configure ###
* Execute the command:
```
mvn package
```

### This project uses JUnit 5 for testing (demo purposes) ###
* To run all tests
```
mvn test
```

* To run tests with tag **example**
```
mvn test -Dgroups=example
```

* Read more about JUnit 5: **http://junit.org/junit5/docs/current/user-guide/**


### About the project ###

* It's a simple project with Spring Boot + Thymeleaf exposing 4 endpoints:
```
/
/create
/rest/
/rest/:user_id
```

* Base path: **http://localhost:8081/**

* The project is about adding and getting users only, but of two ways: *web page* and *REST*.

* **NOTE:** This branch uses a java list as database. Other branches will have JPA/Hibernate to use with any database.

* **START THE PROJECT:**

* To clean the project and generate a new JAR:

```
mvn clean package
```

* To run the created JAR:

```
java -jar target/JavaSampleProject.jar
```