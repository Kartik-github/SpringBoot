FROM openjdk:21-jdk
EXPOSE 8080
ADD /build/libs/\*.jar api-gateway.jar
ENTRYPOINT [ "java","-jar","/api-gateway.jar"]
