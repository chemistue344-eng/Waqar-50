# syntax=docker/dockerfile:1

# Build stage: use Maven + Java 17 to compile your app
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn -DskipTests package

# Run stage: slim Java 17 runtime
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/pg-books-api-0.0.1.jar /app/app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
