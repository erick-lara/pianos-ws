#BUILD
FROM maven:3.8.4-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip
#PACKAGE
FROM openjdk:11
MAINTAINER "github.com/erick-lara"
COPY target/pianos-ws-0.0.1-SNAPSHOT.jar pianos-ws-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/pianos-ws-1.0.0.jar"]
