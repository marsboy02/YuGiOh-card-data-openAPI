FROM openjdk:17

WORKDIR /app

COPY build/libs/openapi-0.0.1-SNAPSHOT.jar /app/openapi-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/app/openapi-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080