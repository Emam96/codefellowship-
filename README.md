# CodeFellowShip

## This is a full stack web app,it allows users to add post,follow users and see their posts.

# Run the App:
1. Create a new database with `CREATE DATABASE` command, in order to use it for the app.
2. change the `application.properties` file and add you database info.
3.  $ ./gradlew bootRun  on your terminal.

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
- ("/index"): to get home page
- ("/login"): to login
- ("/signup"): to signup
- ("/profile"): to see your profile and posts.
- ("/feed"): to see your followed friends posts.