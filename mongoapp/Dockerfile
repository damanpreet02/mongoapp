# Use official Java 21 image
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and pom first (for caching)
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn

# Download dependencies
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copy the rest of the project
COPY src src

# Build Spring Boot app
RUN ./mvnw clean package -DskipTests

# Expose Spring Boot port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/mongoapp-0.0.1-SNAPSHOT.jar"]
