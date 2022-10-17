FROM maven:3.8-openjdk-17 AS build-env

WORKDIR /app

COPY pom.xml .

RUN mvn verify --fail-never

COPY src src

RUN mvn -Dmaven.test.skip=true package

FROM openjdk:17-slim

WORKDIR /app

COPY --from=build-env /app/target/documents-0.0.1-SNAPSHOT.jar /app/app.jar

ENV MONGODB_USERNAME=root
ENV MONGODB_PASSWORD=secret

CMD ["java", "-jar", "app.jar"]