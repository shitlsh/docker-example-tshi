FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#
#FROM maven:3.6.3-jdk-8 as builder
#WORKDIR /app
#COPY ./ /app
#EXPOSE 8080
#RUN ["mvn", "clean", "install"]
#
#FROM openjdk:8-jdk-alpine as prod
#WORKDIR /app
#COPY --from=0 /app/target/docker-demo-luna-0.0.1-SNAPSHOT.jar /app
#CMD ["java", "-jar", "docker-demo-luna-0.0.1-SNAPSHOT.jar"]