FROM openjdk:17

WORKDIR /app

COPY . /app

RUN ./gradle build

CMD ["java", "-jar", "/app/build/libs/openapi-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080