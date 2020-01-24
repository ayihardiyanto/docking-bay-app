FROM openjdk:8-jre-alpine
WORKDIR /
ADD target/docking-system-app-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar", "file_inputs.txt"]