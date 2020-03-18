Employee Accessing Neo4j Data Rest
================================== 

Overview
--------

The primary goal of the Spring Data project is to make it easier to build Spring-powered applications that use new data access technologies such as non-relational databases.

This demo web application shows developers how to quickly get started with [Spring Data Neo4j](https://github.com/spring-projects/spring-data-neo4j) library and the [Neo4j](http://neo4j.org) graph database.


This project is built using:

- Spring Boot 2.2.5.RELEASE
- Spring Data Neo4j 5
- Neo4j OGM 3.2.10
- AngularJS 1.7
- Bootstrap 3.3
- Maven 3.6.2
- JDK 1.8
- Eclipse Photon Release (4.8.0)


It leverages combines the power Spring Data and Spring Boot with the Neo4j Object Graph Mapper(OGM) via a RESTful interface with which a web client application such as AngularJS.

Getting Started
---------------

### Prerequisites

You will need to following to run this application:

- [Java 8+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Maven](https://maven.apache.org/)


### Download the application

Either [download](https://github.com/neo4j-examples/sdn-university/archive/master.zip) the application or use `git` to clone the application:

```
git clone https://github.com/ebenhabi/employee-neo4j-data-rest.git
cd cd employee-neo4j-data-rest
```

### Starting the application

No configuration is required as this application will run with a temporary embedded Neo4j Database by default. See below on how to set this up with a standalone Neo4j Server using bolt or the http drivers.

You can start the application using maven:

```
mvn spring-boot:run
```

And that's it! Head to <http://localhost:8080> to see your application running.

#### Using the Bolt driver

If you'd like to run this application using the fast bolt driver against a standalone Neo4j instance then you will need to do the following.

1. Make sure you have a [Neo4j](http://neo4j.org) instance installed and running.
1. Change the `pom.xml` to comment out the embedded driver and the embedded neo4j instance dependencies and instead uncomment the bolt driver.
1. You'll need to provide connection credentials for the database to the bolt driver. To do this, set the Neo4j username and password in `src/main/resources/application.properties`
    ```
    spring.data.neo4j.uri=bolt://localhost:7687
    spring.data.neo4j.username=<your username>
    spring.data.neo4j.password=<your password>

    ```
1. You can then start the application using the same maven run command shown above.

#### Testing with the Postman

1. Make sure you have a [Neo4j](http://neo4j.org) instance installed and running.
1. You'll need to import the collection files in Postman, click the Import button in the header bar. In the IMPORT modal, select the sample files to upload located in `src/main/resources/data/Employees accessing-neo4j-data-rest.postman_collection.json` 
1. You should see your collection with a request you just imported in the sidebar as shown in the image below.
1. Open the Post request and click the send button in order to add the data in Neo4j Database.
1. Open the Get request and click the send button in order to visualize data fetched from Neo4j Database.




