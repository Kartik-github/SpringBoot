FROM openjdk:21-jdk
EXPOSE 8090
ADD /build/libs/\*.jar movie-catalog.jar
ENTRYPOINT [ "java","-jar","/movie-catalog.jar"]
