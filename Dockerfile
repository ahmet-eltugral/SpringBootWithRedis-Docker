
FROM openjdk:17
COPY target/spring-redis-0.0.1-SNAPSHOT.jar spring-redis-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENV SPRING_REDIS_HOST=localhost
CMD ["java", "-jar", "spring-redis-0.0.1-SNAPSHOT.jar"]
FROM redis:latest

# Redis sunucu çalıştığı zaman kullanılacak portu belirtin
EXPOSE 6379

# Redis sunucu başladığında çalışacak komut
CMD ["redis-server", "--bind", "0.0.0.0"]