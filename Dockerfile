# ---------- BUILD ----------

# Use a valid Gradle image
FROM gradle:9.2.1-jdk17 AS build

WORKDIR /app

# Copy Gradle wrapper and build files (for caching)
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle .
COPY settings.gradle .

# Make gradlew executable
RUN chmod +x gradlew

# Copy source code
COPY src ./src

# Build the JAR (skip tests for faster builds)
RUN ./gradlew clean bootJar --no-daemon -x test


# ---------- RUN ----------

# Use a valid OpenJDK runtime image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]