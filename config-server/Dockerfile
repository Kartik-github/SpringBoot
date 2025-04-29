FROM openjdk:21-jdk
EXPOSE 8888
ARG JAR_FILE
COPY Config app/config
COPY /build/libs/$JAR_FILE app/config-server.jar
ENTRYPOINT [ "java","-jar","/app/config-server.jar"]
