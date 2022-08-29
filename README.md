# TestWMS
First attempt to create own WMS system based fully on JAVA

(!) Current version is based on the Spring Framework with the usage of "Spring Boot", "Spring WEB" and "Sprind Data JBA" dependencies.
SQLite is used as database management system.

*****************************************************
Steps of the project creation:
*****************************************************
1) Download prebuild projact from the start.spring.io (dependency to "Spring WEB" and "Spring Data JBA" should be respected)
2) Configure maven depndency to SQLite driver by addyng below strings to the pom.xml file (it always can be taken from the maven repository):

<!-- https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc -->
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.39.2.1</version>
</dependency>

3) Add below strings to the application.properties file (<your package name> should be replaced by your package name):

spring.jpa.database-platform=<your package name>.SQLDialect
spring.datasource.url=jdbc:sqlite:database.db
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

4) SQLite dialect support provided by the class file SQLDialect.java from your package folder
5) If all dependencies are respected then database can be created by running the scratch file "dbcreate.java".

To be continued...
