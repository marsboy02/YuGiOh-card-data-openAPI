FROM openjdk:17

WORKDIR /apps

COPY /build/libs/openapi-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
