# Use OpenJDK 17 base image
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy Maven built jar into the container
COPY target/*.jar app.jar

# Expose port used by Spring Boot
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java","-jar","app.jar"]
