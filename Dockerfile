FROM openjdk:17

ENV APP_HOME=/apps

ARG JAR_FILE_PATH=build/libs/openapi-0.0.1-SNAPSHOT.jar

WORKDIR $APP_HOME

COPY $JAR_FILE_PATH app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
