<<<<<<< HEAD
FROM eclipse-temurin:17-jdk-alpine
=======
FROM eclipse-temurin:21-jdk
>>>>>>> b8f5b71 (feat: search)
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

