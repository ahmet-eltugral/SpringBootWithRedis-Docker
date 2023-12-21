
FROM openjdk:17
COPY target/spring-redis-0.0.1-SNAPSHOT.jar spring-redis-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "spring-redis-0.0.1-SNAPSHOT.jar"]
