# spring-rest-docker

This demo for building maven CRUD app and deploy using docker.

## Here are step to run this:

1. Install docker. Following [this guide](https://docs.docker.com/engine/installation/)
2. Build app as war using `mvn clean package`
3. Run app using `docker-compose up`

## Docker compose creates 5 services:

1. Database container which use mysql image with 1 database named 'restmesure' created
2. Web application container built based on tomcat:8.5 image and deploy the war file as ROOT app
3. Nginx + consul template as load balancer serving on port 80
4. Consul server
5. Registrator

## Scaling app

```
docker-compose scale restapp=3
```

This will create 2 more tomcat container and automatically propagated to nginx load it's configuration (consul-template doing this)

## Testing
Access http://docker-ip URL from your browser to see if it work

## REST API testing

1. Import `spring-rest-docker.postman.json` to your postman collection
2. Create new environment which has `url` key with the value: `http://docker-ip`
3. Exec each pre-defined requests to see result
