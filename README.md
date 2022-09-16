# TestWMS
First attempt to create own WMS system based fully on JAVA

(!) Current version is based on the Spring Framework with the usage of "Spring Boot", "Spring WEB" and "Sprind Data JBA" dependencies.
SQLite is used as database management system.

*****************************************************
The project contains prebuilt project from start.spring.io
Support of SQLite is realized by SQLDialect.java file. 
JAVA SDK used for the project is Liberica SDK v.17
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


