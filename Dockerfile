FROM openjdk:11
MAINTAINER "github.com/erick-lara"
COPY target/pianos-ws-0.0.1-SNAPSHOT.jar pianos-ws-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/pianos-ws-1.0.0.jar"]
