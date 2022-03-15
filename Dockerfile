FROM openjdk:11.0.10-jre-slim-buster
ARG JAR_FILE=build/libs/*.jar

ARG MYSQL_URL
ENV MYSQL_URL=$MYSQL_URL

ARG MYSQL_USERNAME
ENV MYSQL_USERNAME=$MYSQL_USERNAME

ARG MYSQL_PASSWORD
ENV MYSQL_PASSWORD=$MYSQL_PASSWORD

COPY ${JAR_FILE} login-application.jar
ENTRYPOINT ["java", "-jar", "/login-application.jar"]