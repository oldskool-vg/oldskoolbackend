# define base docker image:
FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

# Copy the JAR file from the target directory
COPY target/oldskoolbackend-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "app.jar"]