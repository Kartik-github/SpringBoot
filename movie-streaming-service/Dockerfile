FROM openjdk:21-jdk
EXPOSE 8091
ADD /build/libs/\*.jar movie-streaming.jar
ENTRYPOINT [ "java","-jar","/movie-streaming.jar"]
