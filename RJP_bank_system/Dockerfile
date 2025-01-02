FROM openjdk:21-jdk-slim

WORKDIR /RJP_bank_system

VOLUME /tmp

COPY target/RJP-docker-demo.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]