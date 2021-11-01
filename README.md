# CodeFellowShip

## This is a full stack web app,it allows users to add post,follow users and see their posts.

# Run the App:
1. change the `application.properties` file and add you database info.
$ ./gradlew bootRun

## Localhost
* localhost:8080

## application properties:
- after you clone this repo make sure to edit application.properties.
    * spring.datasource.platform=postgres
    * spring.datasource.url=jdbc:postgresql://localhost:5432/`your database name`
    * spring.datasource.username=`username`
    * spring.datasource.password=`password`
    * spring.jpa.hibernate.ddl-auto=create

# Routes:
- ("/"): to get home page
- ("/login"): to login
- ("/signup"): to signup
- ("/profile"): to see your profile and posts.