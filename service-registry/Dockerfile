FROM openjdk:21-jdk
EXPOSE 8761
ARG JAR_FILE
ADD /build/libs/$JAR_FILE service-registry.jar
ENTRYPOINT [ "java","-jar","/service-registry.jar"]
