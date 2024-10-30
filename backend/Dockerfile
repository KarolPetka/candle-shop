FROM openjdk:17-jdk-slim AS build

WORKDIR /app

COPY pom.xml /app/
COPY src /app/src

RUN apt-get update && apt-get install -y maven
RUN mvn -B clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar backend.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "backend.jar"]
