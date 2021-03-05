FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENV MESSAGE=${BUILD_RESULT_PATH}

ENTRYPOINT ["java", "-jar", "/app.jar"]