FROM openjdk:21-jdk
EXPOSE 8080
ARG JAR_FILE
ADD /build/libs/$JAR_FILE api-gateway.jar
ENTRYPOINT [ "java","-jar","/api-gateway.jar"]
