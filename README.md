I created an app that presents concepts specific to OOP in Java which includes : 
Encapsulation, Inheritance , Polymorphism, Overriding, Abstraction, Collections, 
Comparators, etc. The project is a medical office scheduling system application 
where you already logged as a client. The application has a menu in which you can
find options such as: 
  -viewing the current list of medical clinics 
  -viewing informations about a particular clinic 
  -viewing informations about all doctors 
  -we cand create an appointment 
  -see al my appointments 
  -modify the data of an apointment 
  -delete an appointment

The project has been brought to the stage of requirements for stage 1:
  -include simple classes with private/protected attributes and methods
  -include at least 2 different collections capable of administering the objects in the application
  -use inheritance for some of the classes used within the collections
  -at least one service class that exposes the system's operations
  -a main class that calls the service's methods
  
 
 
The project has been brought to the stage of requirements for stage 2:

  -CSV files will be used to store at least 4 types of objects from the first stage. Each column in the file is separated with a comma. Example: name,surname,age
  -Generic (not in the context of java generics) singleton services will be created for reading and writing from/to files
  -At system startup, the data will be automatically loaded from the files.
  -An auditing service will need to be created that will log to a CSV file each time an action from the first stage is performed.
