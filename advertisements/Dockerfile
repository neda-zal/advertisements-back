FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/advertisements.jar
COPY ${JAR_FILE} advertisements.jar
ENTRYPOINT ["java","-jar","/advertisements.jar"]