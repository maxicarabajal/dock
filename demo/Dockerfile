FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/demo-0.0.1.jar
COPY ${JAR_FILE} demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]