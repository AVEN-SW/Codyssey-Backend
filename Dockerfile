FROM openjdk:11
ARG JAR_FILE=build/libs/Codyssey-Backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} build/libs/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/app.jar"]