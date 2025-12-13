# ---------- BUILD ----------

# Use a valid Gradle image
FROM gradle:8.3-jdk17 AS build

WORKDIR /app

# Copy Gradle wrapper and build files (for caching)
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle .
COPY settings.gradle .

# Copy source code
COPY src ./src

# Build the JAR (skip tests for faster builds)
RUN ./gradlew clean bootJar --no-daemon -x test


# ---------- RUN ----------

# Use a valid OpenJDK runtime image
FROM openjdk:17-slim

WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Use environment variables for database and secret keys
ENV SPRING_DATASOURCE_URL=${OLYMPIACOSFCAPP_PROJECT_DATABASE}
ENV SPRING_DATASOURCE_USERNAME=${OLYMPIACOSFCAPP_PROJECT_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${OLYMPIACOSFCAPP_PROJECT_PASSWORD}
ENV APP_SECRET_KEY=${OLYMPIACOSFCAPP_PROJECT_SECRET_KEY}
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=none

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]