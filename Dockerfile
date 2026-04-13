FROM eclipse-temurin:21-jdk

COPY target/expense-tracker-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]