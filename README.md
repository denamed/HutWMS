# TestWMS
First attempt to create own WMS system based fully on JAVA

(!) Current version is based on the Spring Framework with the usage of "Spring Boot", "Spring WEB" and "Sprind Data JBA" dependencies.
SQLite is used as database management system.

*****************************************************
Steps of the project creation:

1) Download prebuild projact from the https://start.spring.io (dependency to "Spring WEB" and "Spring Data JBA" should be respected)
2) Configure Gradle depndency to SQLite driver by addyng strings to the gradle.build file. String can be found on maven repository
    https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
3) Add below strings to the application.properties file (`{your package name}` should be replaced by your package name):
```Java
spring.jpa.database-platform={your package name}.SQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.datasource.url = jdbc:sqlite:database.db
spring.datasource.driver-class-name = org.sqlite.JDBC
spring.datasource.username =
spring.datasource.password =
```
4) SQLite dialect support provided by the class file SQLDialect.java from your package folder
5) If all dependencies are respected then database can be created by running the scratch file "createdb.java".

To be continued...

*****************************************************
# Structure

```mermaid
  graph TB
    
    node([WMS])-->node1(Stock)
    node([WMS])-->node2(Warehouse)
    node([WMS])-->node3(Users)
    node([WMS])-->node4(Logic)

    node1(Stock)-->Owner
    node1(Stock)-->Characteristics
    Owner-->Catalogue
    Catalogue-->Item
    Characteristics-.->Item
    
    node2(Warehouse)-->Building
    Building-->Module
    Module-->Area
    Area-->Location
    Area-->AreaType
    Location-->Status
    Location-->LocType
    Location-.->Item

    node3(Users)-->AdminsAndWorkers
    node3(Users)-->Rights
    Rights-.->AdminsAndWorkers


