# Spring Data Jpa Examples<br>

## Introduction<br>
In this repository you will find several database query examples, using <b>Spring Data Jpa</b>. 
The code examples was made in addition to a <b>Microsoft Word</b> file that discusses the <i>pros</i> and <i>cons</i> of the different
query methods available in <b>Spring Data Jpa</b>

## Technologies<br>
* Java 8
* Spring Boot 2.3.4
* Maven 

## Launch<br>

### 1)<br>
To run the project, you need to connect it to a local Microsoft SQL database instance. 
After this you have to reformat the application.properties file, and edit the following lines:<br><br>
spring.datasource.url=jdbc:sqlserver://localhost;databaseName=<<i>DATABASENAME</i>><br>
spring.datasource.username=<<i>USERNAME</i>><br>
spring.datasource.password=<<i>PASSWORD</i>><br>

Follow these guidelines to instanciate a local database:<br>
https://docs.microsoft.com/en-us/sql/relational-databases/lesson-1-connecting-to-the-database-engine?view=sql-server-ver15

You do not have to create Tables in the database.
### 2)<br>
Run the application once. This way Spring Data JPA will create all necessary database tables.
After this you can run the test queries against your local database instance. 
