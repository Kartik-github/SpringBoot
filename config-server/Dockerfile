FROM openjdk:21-jdk
EXPOSE 8888
COPY /build/libs/\*.jar config-server.jar
ENTRYPOINT [ "java","-jar","/config-server.jar"]
