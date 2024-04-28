FROM adoptopenjdk/openjdk11:alpine
WORKDIR /app
COPY target/my-application.jar my-application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "my-application.jar"]