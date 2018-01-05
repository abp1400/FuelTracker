This README file is for the Event Tracker project I created. The purpose of this project is to create a REST API with CRUD functions utilizing MySQL as a database, Java to create the data objects, Spring as the framework, and Gradle as the Build Tool.

The events I tracked in my project were fuel payments, which consisted of the name of the gas station, its address, the grade of gas, the amount of gallons purchased, the price per gallon, the total purchase price, and the date of the transaction.  

I captured the data using a one-table MySQL database, called fueldb, with a table called "payment." Each payment id was assigined an integer as its primary key, and it was auto-incremented.  The name of the station, address, and grade were stored as VARCHARs.  Gallons, price per gallon, and total price were stored as DECIMALs, and date was stored as a DATE.

I created a corresponding Payment object in Java, utilizing appropriate annotation to map the objects to database and tested the mappings with JUnit.

I then created the Controller, DAO and DAOImpl using Spring MVC.  The controller, called "PaymentController," had five methods:
index, show, create, delete, and update.  Index showed all the data objects. Show displayed the object by id. Create created a new data object. Delete deleted the object, and Update updated the object with new data.

The controller used corresponding DAO and DAOImpl methods which were based on Spring's EntityManager.  The show and index methods basically used the Entity Manager's FIND function and the delete method used the Entity Manager's REMOVE function.  

The create and update methods used FasterXML's Jackson ObjectMapper to create or update the objects from a JSON string before passing them to the Entity Manager.    

All controller methods were tested locally via the Postman tool.  After all methods were found to be functional, I copied and uploaded my fueldb database to AWS via a dump file and exported my Spring MVC Rest project to a WAR file and also uploaded it to AWS.  I then tested all the methods again on AWS using the Postman tool.

The API can be used (and tested) using the following URLs:

http://54.156.178.25:8080/RestProject/rest/payments/ ( displays all payments)

http://54.156.178.25:8080/RestProject/rest/payments/{id} (displays payment by ID)

http://54.156.178.25:8080/RestProject/rest/payments/ (using POST in Postman and passing in a Json string, creates a payment)

http://54.156.178.25:8080/RestProject/rest/payments/ (using DELETE in Postman and passing in a Json string, deletes a payment)

http://54.156.178.25:8080/RestProject/rest/payments/{id} (using PUT in Postman and passing in a Json string, updates a payment)
