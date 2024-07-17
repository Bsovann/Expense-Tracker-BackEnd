FROM openjdk:24-slim-bullseye
ADD target/webapp-backend.jar webapp-backend.jar
CMD ["java", "-jar", "/webapp-backend.jar"]