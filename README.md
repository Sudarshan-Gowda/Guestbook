# Guest Book Application Using Spring Boot and JSP
Guestbook application consists of two types of users. <br/>
<ol>
 <li>Guests</li>
  <li>Administrator</li>
</ol>

#### Guests
<ul>
 <li>User needs to login in order to write a new entry in the guestbook</li>
 <li>Guestbook entry can be either a single image or a text</li>
</ul>

#### Administrator
<ul>
 <li>View all the entries posted by all the users</li>
 <li>Approve the entries</li>
 <li>Edit the entries</li>
 <li>Remove the entries</li>
</ul>

### Prerequisites
The following items should be installed in your system:
* Tool - Spring Tool Suite/Eclipse
* MySQL Workbench
* Git
* Java 11
* Maven

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
|SpringSecurityConfig File| [SpringSecurityConfig.java](https://github.com/Sudarshan-Gowda/Guestbook/blob/main/src/main/java/com/guestbook/security/service/SpringSecurityConfig.java) |

## Steps to test the application:

### To Run the Spring MVC Application:
`step 1`: Download this repository & do maven import.<br>  
`step 2`: Create schema with name `guestbook` and execute data base scripts to create table structures from [database.sql](https://github.com/Sudarshan-Gowda/Guestbook/blob/main/src/main/resources/database.sql) and import the default data from file [scripts.sql](https://github.com/Sudarshan-Gowda/Guestbook/blob/main/src/main/resources/scripts.sql) <br><br>
`step 3`: Go to the main class file and run as Java application. <br> or execute the commands `mvn spring-boot:run` to run locally <br> <br>
`step 4`: Once the application starts, By default application will be deployed in 8080 port, and you can access it by using http://localhost:8080/ <br>

### Build Application
  To build the application using maven, use the command `mvn clean install`, this will create production ready jar file under target folder to deploy to any server.
  <br/>
   <img src="https://github.com/Sudarshan-Gowda/Guestbook/blob/main/docs/mvn-build.png" width="100%"/>

  

### To Login to Application
     Navigate to the URL http://localhost:8080/ and use the below credentails to login and manage the application <br>
      -- To login as ADMIN Role -- UN/PW -- `admin/P@ssword123`. <br>
      -- To login as USER Role  -- UN/PW -- `user/P@ssword123` or `user2/P@ssword123` <br>

### To see the complete project flow <br> <br>

 Project Flow for Guest Book <br/>
 <img src="https://github.com/Sudarshan-Gowda/Guestbook/blob/main/docs/project-flow.gif" width="100%"/>
 
 1. Login Page for Guest User/Admin<br/>
  <img src="https://github.com/Sudarshan-Gowda/Guestbook/blob/main/docs/Pic01.png" width="100%"/>
  
 2. Registration Page for Guest User  <br/>
  <img src="https://github.com/Sudarshan-Gowda/Guestbook/blob/main/docs/Pic02.png" width="100%"/>
  
 3. Login as Guest User and create new book entry <br/>
  <img src="https://github.com/Sudarshan-Gowda/Guestbook/blob/main/docs/Pic05.png" width="100%"/>

 4. Login as Admin User and can view all the records <br/> 
  <img src="https://github.com/Sudarshan-Gowda/Guestbook/blob/main/docs/Pic03.png" width="100%"/>
 
 5. Update/View the record for Admin User <br/>
  <img src="https://github.com/Sudarshan-Gowda/Guestbook/blob/main/docs/Pic04.png" width="100%"/>
  
 6. Admin User can do Approve/Update/View/Delete for newly added record by Guest User <br/>
  <img src="https://github.com/Sudarshan-Gowda/Guestbook/blob/main/docs/Pic06.png" width="100%"/>



# Contributing

The [issue tracker](https://github.com/Sudarshan-Gowda/Guestbook/issues) is the preferred channel for bug reports, features requests and submitting pull requests.



