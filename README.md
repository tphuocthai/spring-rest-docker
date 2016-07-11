# spring-rest-docker

This demo for building maven CRUD app and deploy using docker.

Here are step to run this:

1. Build app as war using `mvn clean package`
2. Run app using `docker-compose up`

Docker compose creates 2 services:
1. Database container which use mysql image with 1 database named 'restmesure' created
2. Web application container built based on tomcat:8.5 image and deploy the war file as ROOT app
