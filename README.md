# spring-oauth2-sample


### Authentication Service

 1. Provides Cleints Dynamic Registration.
 2. Database based backed token store and user details service.
 
### Resource Server

 Secured resource server.

### Authentication Servie Client

 Client uses an __Authentication Service__ as a third party Oath Client.
 
### How to run with docker

   From the root of the project please run the following commands in described order.

    1. ./gradlew clean unpack
    2. docker-compose up
