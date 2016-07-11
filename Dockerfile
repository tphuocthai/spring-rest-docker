FROM tomcat:8.5
MAINTAINER Trinh Phuoc Thai <tphuocthai@gmail.com>
RUN ["rm", "-rf", "/usr/local/tomcat/webapps/ROOT"]
ADD target/spring-rest-docker.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080