# todoapp-BE
Backend (Spring Boot) code for the To Do Application

This project is using **java 17**. 
I have installed the latest JDK for implementation i.e. JDK 22

Once you have downloaded the required JDK, you can configure the project with the appropriate SDK to build and run.

For the database, we are using postgresSQL as defined in the **application.properties** file.

The database uses **localhost** and port **5432** to run. The name of the database is **todoapp**.

Once the database is set up, you can run the Java code and the relevant tables will be created from the entities in the **todoapp** database.

Once the above steps are completed, we can test the backend separately locally using postman with requests sent to **localhost:8080**.

Sample endpoint:
GET request - http://localhost:8080/todo_application/todoitems
