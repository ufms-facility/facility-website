FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/facility.jar 
WORKDIR /app
ENTRYPOINT java -jar facility-docker.jar