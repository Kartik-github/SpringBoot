FROM openjdk:21-jdk
EXPOSE 8090
ARG JAR_FILE
ADD /build/libs/$JAR_FILE movie-catalog.jar
ENTRYPOINT [ "java","-jar","/movie-catalog.jar"]
