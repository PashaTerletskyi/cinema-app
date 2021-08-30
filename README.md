# **Cinema-app** 
Website which imitates work online-cinema.

Based on architectural style REST with stateless authentication using frameworks: Hibernate, Spring. 

Had two built-in roles : admin and user (default role at registration).

## _FUNCTIONS :_

**All roles functions :**
* Get all movies. Endpoint : /movies
* Get all cinema halls. Endpoint : /cinema-halls
* Get all movie sessions. Endpoint : /movie-sessions
* Get available movie sessions. Endpoint : /movie-sessions/available

**Admin functions :**
* Add new movies. Endpoint : /movies
* Add new cinema halls. Endpoint : /cinema-halls
* Add new movie sessions. Endpoint : /movie-sessions
* Update a movie sessions with id. Endpoint : /movie-sessions/{id}
* Delete a movie sessions with id . Endpoint : /movie-sessions/{id}

**User functions :**
* Get user's own orders. Endpoint : /orders
* Add a ticket with movie session to his shopping cart. Endpoint : /shopping-carts/movie-sessions
* View his shopping cart. Endpoint : /shopping-carts/by-user
* Complete an order. Endpoint : /orders/complete

## _DATABASE STRUCTURE :_

<img src="https://i.ibb.co/pWxXSww/diagram.png" alt="diagram">

## _PROJECT USES :_

* Java 11.
* MySQL.
* Maven 4.0.0.
* Tomcat 9.0.50.
* Maven Checkstyle Plugin 3.1.1.
* Hibernate 5.4.27.Final.
* Spring 5.3.9.
* Spring MVC 5.3.9.
* Spring Security 5.5.2.

## _HOW TO RUN PROJECT :_

1. Clone this project and open it in your IntelliJ IDEA(Add SDK(11 or above)).
2. Install MySQL Workbench(8.0.25 or above) and configure your schema. Change your parameters in db.properties(Example below)

   <img src="https://i.ibb.co/8gWcRqj/example.png" alt="example">
3. Run the project with Tomcat configuration. 
4. You can test app functionality with Postman : 
* To test admin functions use already created user (email : admin@gmail.com, password : admin)
* To test user functions first use Postman to register a new user. 

Add to Headers Key : Content, Value : application/json. (Example below) 

<a href="https://imgbb.com/"><img src="https://i.ibb.co/w4MRTVj/ex1.png" alt="ex1" border="0"></a>

Choose POST and add endpoint : /register 

Then choose Body -> raw -> JSON :   (Example below)
<img src="https://i.ibb.co/KD0Hq44/ex2.png" alt="ex2">
