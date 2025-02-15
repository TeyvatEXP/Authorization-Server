FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY /app/target/app-0.0.1.jar app.jar
CMD ["java", "-jar", "app.jar"]
