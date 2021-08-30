# **Cinema-app** 
Website which imitates work online cinema.

Based on architectural style REST with stateless authentication using frameworks: Hibernate, Spring. 

Had two built-in roles : admin and user(default role at registration)

## _FUNCTIONS :_

**All roles functions :**
* Get all movies.
* Get all cinema halls.
* Get all movie sessions.
* Get available movie sessions

**Admin functions :**
* Add new movies.
* Add new cinema halls.
* Add new movie sessions.
* Add update movie sessions.
* Add delete movie sessions.

**User functions :**
* Get own orders.
* Complete own orders in own shopping cart.

## _DATABASE STRUCTURE :_

<img src="https://i.ibb.co/pWxXSww/diagram.png" alt="diagram">

## _PROJECT USES :_

* Java 11.
* Maven 4.0.0.
* Tomcat 9.0.50.
* MySQL Workbench 8.0.25.
* Maven Checkstyle Plugin 3.1.1.
* Hibernate 5.4.27.Final.
* Spring 5.3.9.
* Spring Security 5.5.2.

## _HOW TO RUN PROJECT :_

1. Clone this project and open it in your IntelliJ IDEA(Add SDK(11 or above)).
1. Install MySQL Workbench(8.0.25 or above) and configure your schema. Change your parameters in db.properties(Example below)

   <img src="https://i.ibb.co/8gWcRqj/example.png" alt="example">
1. Run the project with Tomcat configuration.