FROM openjdk:17-slim as build

MAINTAINER Felipe Neves

COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/accounts-0.0.1-SNAPSHOT.jar"]