FROM openjdk:8

ENV url jdbc:mysql://basket-mysql:3306/basketbdd
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/gs-rest-service-0.1.0.jar"]
