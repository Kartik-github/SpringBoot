FROM openjdk:21-jdk
EXPOSE 8761
ADD /build/libs/\*.jar service-registry.jar
ENTRYPOINT [ "java","-jar","/service-registry.jar"]
