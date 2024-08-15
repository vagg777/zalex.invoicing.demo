# Use Java 21 ( > 17 would be fine)
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy your application JAR file into the container
# Replace 'myapp.jar' with the actual name of your JAR file
COPY target/zalexinvoicingdemo-0.0.1-SNAPSHOT.jar /app/zalexinvoicingdemo-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 8080

# Run the Java application
ENTRYPOINT ["java", "-jar", "/app/zalexinvoicingdemo-0.0.1-SNAPSHOT.jar"]
