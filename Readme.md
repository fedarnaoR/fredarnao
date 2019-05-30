# Web Developer Sample Project

This one is a test for a job interview to check my knowledge about SpringBoot, Thymeleaf and others.

## Answered by

The present test was answered by me ([Federico Arnao Martin](https://www.linkedin.com/in/federicoarnao/))

## Requirements

You are required to develop a web appication to capture and store demographic details for individuals.
There will be 3 pages in total:

|Page|Purpose|Url|Comments|
|---|---|---|---|
|Landing page|It displays two links (Add a new record and List all records)|http://localhost:8080/people|Links look like buttons, but they are not.|
|Add a new record|Displaying all people who were registered into the system.|http://localhost:8080/people/newperson|I added a new button (Cancel) to go back the landing page. When you click on the button Submit you will go to "List all records" page.|
|List all records|Displaying all people into the system|http://localhost:8080/people/list|I added two new buttons: "New person", to go to register other new people, and "Home" to go to the landing page.|

### Add new record
|Field Name|Required|Validation|
|---|---|---|
|Name|Yes|Max 25 characters|
|PPS Number|Yes|Prevent duplicates (it is the PK)
|Date of Birth|Yes|*1.* dd/mm/yyy &nbsp; *2.* Cannot be future date &nbsp; *3.* Must be over 16 years old|
|Mobile Phone|No|Must begin with 08 prefix|

### List All Records
Display all records added and **ordered by the creation date** of the record.
If there are no records display message "**No records have been created**".

## Tech
Spring Boot
Spring MVC
Spring Data / In memory database.
Thymeleaf or JSP.
Front end validation using jQuery or equivalent framework.

## Comments
It was implemented using H2 as an in-memory database, Thymeleaf and jQuery (jQuery and jQuery validation).
I have developed two Unit test in order to check PersonService.

To create a jar package and execute it:
```bash
mvn package && java -jar target\fredarnao-0.0.1.jar
```
