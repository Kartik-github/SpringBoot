FROM openjdk:21-jdk
EXPOSE 8091
ARG JAR_FILE
ADD /build/libs/$JAR_FILE movie-streaming.jar
ENTRYPOINT [ "java","-jar","/movie-streaming.jar"]
