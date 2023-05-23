FROM openjdk:17

MAINTAINER maltesh <malteshbk1999@gmail.com>

COPY target/jobhub-1-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","jobhub-1-0.0.1-SNAPSHOT.jar"]


