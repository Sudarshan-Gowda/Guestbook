# spring-boot-admin-server-client
GuestBook Application using Spring Book

### Prerequisites
The following items should be installed in your system:
* Tool - Spring Tool Suite/Eclipse
* MySQL Workbench
* Git
* Java 11

### Technologies Used
* Java 11
* Spring boot
* JSP, HTML, CSS
* Bootstrap, JQuery, JS
* MySQL

### Steps to Clone The Repository Application Locally:

1) Download this Project from Git.
```
git clone https://github.com/Sudarshan-Gowda/Guestbook.git
```
2) To Import the Project Using Eclipse or STS
```
File -> Import -> Maven -> Existing Maven project -> spring-boot-admin
```
 
## Looking for something in particular?

|Guest Book  | Class or Java property files  |
|--------------------------|---|
|Configuration File | [application.properties](https://github.com/Sudarshan-Gowda/Guestbook/blob/main/src/main/resources/application.properties) |
|Scripts - Create File| [database.sql](https://github.com/Sudarshan-Gowda/Guestbook/blob/main/src/main/resources/database.sql) |
|Scripts - Insert File| [scripts.sql](https://github.com/Sudarshan-Gowda/Guestbook/blob/main/src/main/resources/scripts.sql) |

## Steps to test the application:

### To Run the Spring MVC Application:
`step 1`: Download this repository & do maven import.<br>  
`step 2`: Create schema with name `guestbook` and execute data base scripts to create table structures from [database.sql](https://github.com/Sudarshan-Gowda/Guestbook/blob/main/src/main/resources/database.sql) and import the default data from file [scripts.sql](https://github.com/Sudarshan-Gowda/Guestbook/blob/main/src/main/resources/scripts.sql) <br><br>
`step 3`: Go to the main class file and run as Java application. <br> or execute the commands `mvn spring-boot:run` to run locally <br> <br>
`step 4`: Once the application starts, By default application will be deployed in 8080 port, and you can access it by using http://localhost:8080/ <br>

### To Login to Application
     Navigate to the URL http://localhost:8080/ and use the below credentails to login and manage the application <br>
      -- To login as ADMIN Role -- UN/PW -- `admin/P@ssword123`. <br>
      -- To login as USER Role  -- UN/PW -- `user/P@ssword123` or `user2/P@ssword123` <br>

### To see the complete project flow <br> <br>

 <img src="https://github.com/Sudarshan-Gowda/Guestbook/blob/main/docs/project-flow.gif" width="100%"/>


# Contributing

The [issue tracker](https://github.com/Sudarshan-Gowda/Guestbook/issues) is the preferred channel for bug reports, features requests and submitting pull requests.



