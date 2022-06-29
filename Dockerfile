#BUILD E PACKAGE
FROM maven:3.8.4-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip
#RUN
FROM openjdk:11
MAINTAINER "github.com/erick-lara"
COPY --from=build /home/app/target/*.jar pianos-ws-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/pianos-ws-1.0.0.jar"]
