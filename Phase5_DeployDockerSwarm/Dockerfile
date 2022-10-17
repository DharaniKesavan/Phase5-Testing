FROM openjdk:8-jdk-alpine
COPY target/spring-boot-dockerswarm.jar dockerswarm.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/dockerswarm.jar"]
