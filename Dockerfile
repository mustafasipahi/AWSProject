FROM maven:3.8.6-amazoncorretto-8 AS maven_build
WORKDIR /build_app
COPY pom.xml pom.xml
COPY UserModule/pom.xml UserModule/pom.xml
COPY src ./src
COPY UserModule/src UserModule/src
RUN mvn clean package

FROM openjdk:8
COPY --from=maven_build /build_app/*.jar my_app.jar
ENTRYPOINT ["java", "-jar", "my_app.jar"]



#   docker rmi -f
#
#   docker build -t my_app:0.1 .
#   docker images
#   docker run