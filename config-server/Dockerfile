FROM openjdk:21-jdk
EXPOSE 8888
ARG JAR_FILE
RUN mkdir config
COPY ../Config config
COPY /build/libs/$JAR_FILE config-server.jar
ENTRYPOINT [ "java","-jar","/config-server.jar"]
